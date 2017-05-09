(ns samples.w01.anonimous-functions)

(def evens (fn [coll] (filter even? coll)))
(evens [1 2 3 4 5 6])

(def my-fu (fn [a b] (+ a b)))
(my-fu 3 4)
