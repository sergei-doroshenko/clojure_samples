(ns samples.w02.concurrency.pmap)

(defn long-job [n]
  (Thread/sleep 3000)
  (+ n 10))

(time (doall (map long-job (range 4))))
(time (doall (pmap long-job (range 4))))

(time (doall (pvalues
               (do (Thread/sleep 3000) 1)
               (do (Thread/sleep 3000) 2)
               (do (Thread/sleep 3000) 3))))
