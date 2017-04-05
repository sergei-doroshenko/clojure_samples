(ns samples.w01.destructuring)

(defn f [x]
  [:ok (* 2 x) (pos? x)])
(f 1)

(let [res (f -1)
      success? (first res)
      val      (get res 1)
      pos?     (get res 2)]
  [success? val pos?])
;; same
(let [[success? val pos?] (f 1)]
  [success? val pos?])
;; nested, recursive
(defn f2 [x]
  [:ok [(* 2 x) (/ 2 x)] (pos? x)])
(f2 10)
(let [[success? [v1 v2] pos?] (f2 10)]
  [success? v1 v2 pos?])
(let [[_ [v1 v2] pos? :as full] (f2 10)]
  [v1 v2 pos? full])
;;
;; map destructuring
(def m {:name "Jhon" :age 37})
(def m2 {:name "Ivan"})
(let [n (:name m)
      a (:age m)]
  [n a])

(let [{n :name a :age :or {a 10} :as full} m2] 
  [n a full])
(let [{:keys [name age]} m] ;; strs
  [name age])

(defn f3 [x & [flag]])
(f3 1)
(f3 1 false)

(defn fop [_ & {:as opts}]
  opts)
(fop 1 :flag true
       :debug false
       :indent 11)
  




