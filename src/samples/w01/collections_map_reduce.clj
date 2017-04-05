(ns samples.w01.collections-map-reduce)

(def xs [1 2 3 4 5])
(map #(+ 1 %) xs)
(map inc xs)
(map dec xs)
(filter #(odd? %) xs)
(remove even? xs)
(= 
   (filter #(odd? %) xs) 
   (remove even? xs))    ;; true

;; Lazy

(take 10 
  (remove odd? 
    (map dec 
      (filter odd? 
        (map inc 
          (range 1000))))))

(reduce (fn [acc el] (+ acc el)) 0 xs) ;; 15
(reduce + 0 xs)                        ;; 15
(reduce conj [] xs)

(def data1 [{:id 1} {:id 2} {:id 3}]) ;; we need map :id = :x, 1 (map #(keyword %)) (get data2 :x)
(def data2 [{:x 1 :v "A"} {:x 2 :v "B"} {:x 3 :v "C"}])
(reduce conj []
  (map #(merge {:d 200} %) data1))

(->> data1
     (map #(merge % (first (filter (fn [rec] (= (:x rec) 1)) data2))))             
     (reduce conj []))

;; (find-for-merge :id 2 data1)
;; => {:id 2}
(defn find-for-merge [field val data]
  (first (filter #(= (field %) val) data)))
(find-for-merge :id 2 data1)

;; Merge two vectors of maps
;; [{:id 1, :x 1, :v "A"} {:id 2, :x 2, :v "B"} {:id 3, :x 3, :v "C"}]
(->> data1
     (map #(merge % (find-for-merge :x (:id %) data2)))             
     (reduce conj []))


(get {:id 3 :val 100} :id)
(map #(merge % (first ) data1))
(let [i 1] 
  (first (filter #(= (get % :x) i) data2)))
(first (filter (fn [rec] (= (:x rec) 1)) data2))



(reduce conj '() xs)

(map inc xs)
(for [x xs]
  (+ 1 x))
(for [v [[1 2] [3 4]] 
      x v
      :let [y (+ 1 x)]
      :when (even? y)
      :while (< x 5)]
  (+ 1 x))

(doseq [x [1 2 3]]
  (println x)) ;; executes side effects
