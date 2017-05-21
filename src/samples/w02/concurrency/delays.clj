(ns samples.w02.concurrency.delays)

(defn use-delays [x]
  {:result (delay (println "Evaluating result...." x) x)
   :some-info true})

(def a (use-delays 10))
(println a)

(println @(:result a))
(println @(:result a))
(println (:result a))