(ns samples.w02.type-hints)

(set! *warn-on-reflection* true)
;; type hint here
(defn strlen ^Integer [^String s]
  (.length  s))

(strlen "abc")
(.intValue (strlen "abc"))

(def x "hello")
(StringBuilder. ^String x)

;; it can be
;; ^Classname
;; ^long ^int ^short ^byte
;; ^longs = long[] ^ints = int[]

(defrecord R [^long a ^byte b])

