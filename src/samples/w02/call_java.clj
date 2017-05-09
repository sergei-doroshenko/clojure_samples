(ns samples.w02.call-java
  (:import (java.io File)))

;; call costructor
(File. "." "call_java.clj")

;; call method
(.toUpperCase "abc")

;; call static method
(Math/sqrt 25)

Math/PI
(deftype Struct2 [a b c])
(.-a (Struct2. 1 2 3))
; setter call
; (set! (.-a x) 5)
; macros. analog of '->' for mutable objects
(doto (java.util.HashMap.)
  (.put "a" 1)
  (.put "b" 2))
; create and start new Thread
(.start (Thread. #(println "hello")))

; the same, but we return created Thread
(let [th (Thread. #(println "hello2"))]
  (.start th)
  th)

;; same with doto, create, start and return new Thread
(doto (Thread. #(println "hello3"))
  (.start))
