(ns {{name}}.core
  (:require [cljs.nodejs :as nodejs]
            [cljs.core.async :refer [chan >! alts!]]
            [cljs.tools.cli :refer [parse-opts]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(nodejs/enable-util-print!)

(def current-value (atom 1))

(defn factorial [max]
  (reduce (fn [acc i]
            (let [a (* acc i)]
              (reset! current-value a)
              (println "current value:" @current-value)
              a))
          (range 1 (+ max 1))))

(def cli-options
  [["-f" "--factorial NUMBER" "factorial to calculate"
   :default 10
   :parse-fn #(js/parseInt % 10)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]
    ]
   ["-g" "--goroutines NUMBER" "number of goroutines to use"
    :default 10
    :parse-fn #(js/parseInt % 10)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]
    ]
   ["-h" "--help"]])

(defn -main [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)
        f (:factorial options)
        g (:goroutines options)
        chans (repeatedly g chan)]

    (cond
      (:help options) (do
                        (println summary)
                        (.exit nodejs/process 0))
      errors (do
               (println "errors")
               (println errors)
               (.exit nodejs/process 1)))

    (println "Running factorial" f "in" g "goroutines...")

    (go (let [[v c] (alts! chans)]
          (println "got" v "from" (js->clj c))))

    (doseq [c chans]
      (go (>! c (factorial f))))))

(set! *main-cli-fn* -main)
