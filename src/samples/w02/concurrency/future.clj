(ns samples.w02.concurrency.future)

(def future-test
  (future (do (Thread/sleep 1000)
              :finished)))

(println (realized? future-test))
(println @future-test)

(println (realized? future-test))
(println @future-test)
