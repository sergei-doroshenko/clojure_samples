; namespaces
;
(ns samples.w01.basics-01)

(defn f [x] x
 (def z 121))

; refer to const
org.sdoroshenko.basics-01/z

(let [x 10] 
  org.sdoroshenko.basics-01/z)

;; get function from namespace
clojure.core/sort

(require '[clojure.string :as str2])

(str2/join "," [1, 3, 4])

(defn hello [& {:keys [salutation name] 
                :or {salutation "Hello" name "World"}}]
  (str salutation " " name))
(hello :name "Ivan" :salutation "Hi")

(defn limit* [data n]
  (if-not (empty? data) 
    (take n data)))

(limit* [1 2 3 4] 3)

(defn fun-fun [data & {:keys [x y z]}]
  (as-> data data'
        (if-not (not y) (limit* data' y) data')))
(fun-fun [1 2 3 4])
(fun-fun [1 2 3 4] :x 1 :y 2 :z 3)
(fun-fun '(1 2 3 4) :x 1 :y 2 :z 3)
  
