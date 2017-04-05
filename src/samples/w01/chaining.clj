(ns samples.w01.chaining)

(as-> 17 x
      (+ x 1)
      (- 100 x)
      (str x))

(as-> [1 2 3 4 5 6] xs
      (map inc xs)
      (filter even? xs)
      (remove #(> % 5) xs)
      (vec xs)
      (str xs))
;; same as, read from right to left <- 
(str (vec (remove #(> % 5) (filter even? (map inc [1 2 3 4 5 6])))))

;; ->> get passed argument and set on last position in function call; use for collections
(->> [1 2 3 4 5 6]
     (map inc)
     (filter even?)
     (remove #(> % 5))
     (vec)
     (str))
(->> (map list [:a :b :c] [1 2 3]) 
     (flatten))
;; -> get argument and set on 1st position
(-> 1 
    (+ 1)
    (- 2)
    (str 3))

(-> {:a {:b {:c 1}}} :a :b :c (+ 1))
(some-> {:a {:b {:c 1}}} :a :x :c (+ 1)) ;; stop when meet nil, there is some->>
