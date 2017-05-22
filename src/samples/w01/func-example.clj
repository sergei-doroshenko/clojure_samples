(ns samples.w01.func-example)
;; function definition
(defn average
  [numbers]
  (/ (apply + numbers) (count numbers)))

(average [60 80 100 400])

(average [120 40 280])
;; key - hash keyword
;; oper - comparision operation <,=,>,...
;; val - value for comparison
;; data - hash, contains keyword, e.g. {:age 24 .....}
(defn make-where-function [key oper val]
  (fn [data] (oper (key data) val)))

(def rec {:id 10 :name "Ivan" :age 25})
(def check-age (make-where-function :age >= 25))
(println (check-age rec))                                   ; true
(println (check-age {:age 30}))                             ; true
(println ((make-where-function :age >= 25) {:age 30}))      ; true
(println (apply check-age [rec]))                           ; true
(println (apply (make-where-function :age > 20) [{:age 30}])) ; true
(println (apply (make-where-function :name = "Ivan") [{:name "Ivan"}])) ; true

(> 3 5)
(apply > [3 5])
(apply < [2 5 4])                                           ; false 2 < 5 < 9
(apply < [2 5 9])                                           ; true  2 < 5 < 9
