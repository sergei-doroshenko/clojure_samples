(ns samples.w02.multi-methods)

(def figs [{:type :rect :w 10 :h 20}
           {:type :rect :w 5  :h 10}
           {:type :circle :r 15}
           {:type :circle :r 20}])
           
;; Math/PI
(defn perimeter [fig]
  (case (:type fig)
    :circle (* 2 Math/PI (:r fig))
    :rect (* 2 (+ (:w fig) (:h fig)))))

(map perimeter figs)

;; fig -> :rect | :circle. Dispatch function + implementation
(defn dispatch [fig] (:type fig))

;;(defmulti p2 dispatch)
(defmulti p2 (fn [fig] (:type fig))) ;; with anonimous function

(defmethod p2 :circle [fig]
  (* 2 Math/PI (:r fig)))

(defmethod p2 :rect [fig]
  (* 2 (+ (:w fig) (:h fig))))

(p2 {:type :rect :w 10 :h 20})
(map p2 figs)

;; in some place in my custom namespace
;; user.ns
(defmethod p2 :triangle [fig]
  (+ (:a fig) (:b fig) (:c fig)))

(p2 {:type :triangle :a 5 :b 5 :c 10})

(defmethod p2 :default [fig] 0)
;; here default function works
(p2 {:type :hex :side 12})

;; Function example that save data to db
(defmulti store (fn [db k v] (class db)))
;;(defmethod store com.redis.RedisDB [db k v]
;;  (.store db (str k) (str v)))

;;(defn dispatch [a b c] (even? (+ a b c)))
;;(defmulti test-t dispatch)

(defmulti test-t (fn [a b c] (even? (+ a b c))))

(defmethod test-t true [a b c] "A")
(defmethod test-t false [a b c] "Z")
(test-t 1 2 3)
