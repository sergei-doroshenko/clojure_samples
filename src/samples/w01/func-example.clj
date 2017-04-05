(ns samples.w01.func-example)
;; function definition
(defn average
  [numbers
   (/ (apply + numbers) (count numbers))])

(average [60 80 100 400])

(average [120 40 280])
