(ns samples.w02.concurrency.validator)

(def a (atom 2))

(set-validator! a pos?)
;; k - unic observer id
;; r - object
;; o - old value
;; n - new value
(add-watch a "watch 1: "
           (fn [k r o n] (println k r o n)))
(add-watch a "watch 2: "
           (fn [k r o n] (println k r o n)))

(swap! a dec)
(swap! a inc)
(swap! a dec)
(swap! a dec)
