(ns samples.w02.transients)

(defn vrange [n]
  (loop [i 0 v []]
    (if (< i n)
      (recur (inc i) (conj v i))
      v)))

(defn vrangeT [n]
  (loop [i 0 v (transient [])]
    (if (< i n)
      (recur (inc i) (conj! v i))
      (persistent! v))))

; don't forget that 'def' define global var for current namespace
(time (def v  (vrange  1000000)))
(time (def vT (vrangeT 1000000)))

(defprotocol TestProtocol
  (get-data [this])
  (set-data [this o]))

(deftype Test [^:unsynchronized-mutable x-var]
  TestProtocol
  (get-data [this] x-var)
  (set-data [this o] (set! x-var o)))

(def a (Test. 10))
(println (get-data a))
(set-data a 42)
(println (get-data a))