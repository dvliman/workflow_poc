(defproject workflow-poc "0.1.0-SNAPSHOT"
  :aot [workflow-poc.core]
  :main workflow-poc.core
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [io.framed/overseer "0.8.8"]])
