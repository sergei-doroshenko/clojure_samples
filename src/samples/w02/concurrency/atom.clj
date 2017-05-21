(ns samples.w02.concurrency.atom)
; syncronized, uncoordinated change
(def ^:private counters-atom (atom {}))

(defn inc-counter [name]
  (swap! counters-atom update-in [name]
         (fnil inc 0)))

(defn dec-counter [name]
  (swap! counters-atom update-in [name]
         (fnil dec 0)))

(defn reset-counter [name]
  (swap! counters-atom assoc name 0))

(println @counters-atom)
(inc-counter :alpha)
(inc-counter :beta)
(reset-counter :alpha)
(println @counters-atom)
(reset! counters-atom {})
(println @counters-atom)



