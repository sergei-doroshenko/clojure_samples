(ns samples.w02.ref-samples)

;; alter
(defn transfer-money [from to amount]
  (dosync
    (if (< @from amount)
      (throw (IllegalStateException.
               (str "Account has less money than required! "
                    @from " < " amount)))
      (do (alter from - amount)
          (alter to + amount)))))

(def ^:private acc-1 (ref 1000))
(def ^:private acc-2 (ref 1000))

(transfer-money acc-1 acc-2 500)
(println @acc-1)
(println @acc-2)

;; For commutative changes
;; operation is commutative if changing the order of the operands does not change the result
(defn add-to-deposit [to amount]
  (dosync
    (commute to + amount)))
(add-to-deposit acc-1 100)
(println (deref acc-1))

(defn write-log [log-msg]
  (io!
    (println log-msg)))
(write-log "test")
(dosync (write-log "test"))

