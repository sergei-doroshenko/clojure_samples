(ns samples.w02.concurrency.promises)

(def p (promise))
; set p in separated thread
(do (future
      (Thread/sleep 5000)
      (deliver p :fred))
    (println @p))
