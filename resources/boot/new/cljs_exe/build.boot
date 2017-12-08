(set-env!
 :source-paths    #{"src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "2.1.4"  :scope "test"]
                 [com.cemerick/piggieback   "0.2.2"  :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12" :scope "test"]
                 [cljs-node-io              "0.5.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [org.clojure/core.async    "0.3.443"]
                 [org.clojure/tools.cli     "0.3.5"]])

(def js-dependencies {:nexe "2.0.0-rc.22"})

(require '[adzerk.boot-cljs :refer [cljs]])

(task-options! cljs {:compiler-options
                     {:optimizations :none
                      :target :nodejs
                      :npm-deps js-dependencies
                      :install-deps true
                      :source-map true
                      :hashbang false}})

(deftask build
  "compile cljs to js with default cljs compiler settings"
  []
  (comp (speak)
        (cljs)
        (target :dir #{"target"})))

(deftask production
  "adjust cljs compiler options for production"
  []
  (task-options! cljs (fn [opts]
                        (-> opts
                            (assoc-in [:compiler-options :optimizations]
                                      :simple)
                            (update-in [:compiler-options] dissoc :source-map))))
  identity)

(deftask dev
  "watch and rebuild the project with development cljs presets"
  []
  (comp (watch)
        (build)))

(deftask binary
  "use nexe to package js into a binary"
  []
  (with-pre-wrap fileset
    ((sh "node" "scripts/build.js"))
    (commit! fileset)))

(deftask package
  "compile clojurescript to javascript with production settings and output a native binary"
  []
  (comp (production)
        (build)
        (binary)))
