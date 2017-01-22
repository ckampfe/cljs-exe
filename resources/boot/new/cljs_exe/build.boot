(set-env!
 :source-paths    #{"src/cljs"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs          "1.7.228-2"  :scope "test"]
                 [adzerk/boot-cljs-repl     "0.3.3"      :scope "test"]
                 [adzerk/boot-reload        "0.4.13"     :scope "test"]
                 [com.cemerick/piggieback   "0.2.1"      :scope "test"]
                 [org.clojure/tools.nrepl   "0.2.12"     :scope "test"]
                 [weasel                    "0.7.0"      :scope "test"]
                 [org.clojure/clojurescript "1.9.293"]
                 [org.clojure/core.async    "0.2.395"]
                 [org.clojure/tools.cli     "0.3.5"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]])

(deftask build []
  (comp (speak)
        (cljs)
        (target :dir #{"target"})))

(deftask run []
  (comp (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production []
  (task-options! cljs {:compiler-options
                       {:optimizations :simple
                        :target :nodejs}})
  identity)

(deftask development []
  (task-options! cljs {:compiler-options
                       {:optimizations :simple
                        :source-map true
                        :target :nodejs}}
                 reload {:on-jsload '{{name}}.core/-main})
  identity)

(deftask dev
  "Simple alias to run application in development mode"
  []
  (comp (watch)
        (development)
        (build)))

(deftask setup []
  ((sh "yarn")))

(deftask package []
  ((sh "node" "scripts/build.js")))

(deftask release []
  (comp (production)
        (build)))
