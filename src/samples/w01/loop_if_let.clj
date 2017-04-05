(ns samples.w01.example)

(when
  (< 1 2)
  5)

(if true 
  (do 
    (println "test") 
    (+ 1 2 3)) 
  :no)

(let [x 11 
      y (+ 10 x) 
      z (+ x y)] 
  (+ x y z))

(loop [x   10
       acc 0]
  (if (pos? x)
    (do
      (println x acc)
      (recur (- x 1) (+ acc x)))
    acc))

;; fibonacci numbers
(let [N 7]
  (loop [i       0
         fib-i-1 0
         fib-i   1]
    (if (= i N)
      fib-i
      ;; what we do with it, new values of:
      ;;        i   fib-i-1      fib-i
      (recur (inc i) fib-i (+ fib-i-1 fib-i)))))
;;
(defn fun22 [data]
  (loop [input data result []]
    (if (empty? input) result
      (let [element (first input)]
        (println element)
        (recur (remove #(= element %) input) (conj result (str "a" element)))))))


(fun22 [1 2 3])
(not-empty [1 2 3])
(first (remove #(= 2 %) [1 2 3]))
;; function
(defn my-func [x]
  (println "fa")
  (+ x 1))

(my-func 3)

;; check args lengs and number
(defn f2 
  ([]    0)
  ([_]   1)
  ([_ _] 2))


(f2)
(f2 3)
(f2 "hello" 47)
