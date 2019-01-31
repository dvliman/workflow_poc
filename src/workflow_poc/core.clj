(ns workflow-poc.core
  (:require [overseer.worker :as overseer])
  (:gen-class))

(def db-spec
  {:classname "org.h2.Driver"
   :subprotocol "h2"
   :subname "file:/Users/gt/workflow-poc/data/jobs"})

(def overseer-config
  {:store
   {:adapter :h2
    :config db-spec}})

(def job-graph
  {:first []
   :second1 [:first]
   :second2 [:first]
   :third [:second1]})

(def job-handlers
  {:start (fn [job] (println "start"))
   :second1 (fn [job] (println "second1"))
   :second2 (fn [job] (println "second2"))
   :third (fn [job] (println "third"))
   :fourth (fn [job] (println "fourth: not in job-graph"))})

(defn start-overseer-worker []
 (overseer/start
   overseer-config
   (overseer/store overseer-config)
   job-handlers))

(defn -main [& args]
  (println "Hello, World!"))
