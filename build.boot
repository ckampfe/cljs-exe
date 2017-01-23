(def project 'cljs-exe/lein-template)
(def version "0.1.0-SNAPSHOT")

(set-env! :resource-paths #{"resources" "src"}
          ;; uncomment this if you write tests for your template:
          ;; :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [seancorfield/boot-new "RELEASE"]
                            [adzerk/bootlaces "0.1.13" :scope "test"]
                            [adzerk/boot-test "RELEASE" :scope "test"]])

(require '[adzerk.boot-test :refer [test]]
         '[boot.new :refer [new]]
         '[adzerk.bootlaces :refer :all])

(bootlaces! version)

(task-options!
 pom {:project     project
      :version     version
      :description "Run Clojurescript as a native binary"
      :url         "https://github.com/ckampfe/cljs-exe"
      :scm         {:url "https://github.com/ckampfe/cljs-exe"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
 push {:gpg-sign false})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

