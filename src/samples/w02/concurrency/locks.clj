(ns samples.w02.concurrency.locks
  (:import (java.util HashMap)))

(defn add-to-map [h k v]
  "can be safelly called from a few threads"
  (locking h
    (.put h k v)))

(def h (HashMap.))
(add-to-map h "test-key" "test-val")
(println h)
