(ns samples.w02.concurrency.agent)

(def ^:private counters-agent (agent {}))

(defn a-inc-counter [name]
  (send counters-agent update-in [name]
         (fnil inc 0)))

(defn a-dec-counter [name]
  (send counters-agent update-in [name]
         (fnil dec 0)))

(defn a-reset-counter [name]
  (send counters-agent assoc name 0))

(println @counters-agent)
(a-inc-counter :alpha)
(a-inc-counter :beta)
(a-reset-counter :alpha)
(println @counters-agent)

;; *agent* - ref to current agent
;; How to use in transactions???
;; send, send-off in transactions

(def err-agent (agent 1))
(send err-agent (fn [_] (throw "We have a problem!")))
;(send err-agent identity)

(def err-agent (agent 1 :error-mode :continue))
(send err-agent (fn [_] (throw "We have a problem!")))
(send err-agent inc)
(println (deref err-agent))


