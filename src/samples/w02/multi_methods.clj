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

(defn dispatch [fig] (:type fig))

(defmulti p2 dispatch)

(defmethod p2 :circle [fig]
  (* 2 Math/PI (:r fig)))

(defmethod p2 :rect [fig]
  (* 2 (+ (:w fig) (:h fig))))

(p2 {:type :rect :w 10 :h 20})
(map p2 figs)
(+ 2 3 4 5)

