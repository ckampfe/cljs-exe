(ns boot.new.cljs-exe
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "cljs-exe"))

(defn cljs-exe
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println "Generating fresh 'boot new' cljs-exe project.")
    (->files data
             ["README.md"                        (render "README.md"    data)]
             ["resources/js/app.cljs.edn"        (render "app.cljs.edn" data)]
             ["build.boot"                       (render "build.boot"   data)]
             ["scripts/build.js"                 (render "build.js"     data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs"    data)]
             ["package.json"                     (render "package.json" data)]
             ["yarn.lock"                        (render "yarn.lock"    data)])))
