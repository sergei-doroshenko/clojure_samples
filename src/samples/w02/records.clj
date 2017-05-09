(ns samples.w02.records)

(def point {:x 1 :y 2})
(:x point)

;; custom type
(deftype PointT [^long x ^long y])
(def p (PointT. 10 12))
(.-x p)
(.-y p)

(defrecord PointR [^long x ^long y])
(def prec (PointR. 11 12))
(.-x prec)
(.-y prec)
(:x prec)
(get prec :x)
(def prec2 (assoc prec :x 20))

;; can add new property
(:z (assoc prec :z 30))
(:x prec)
(:x prec2)

;; auto generated equals method
(= (PointR. 10 10) (PointR. 10 10))

(defprotocol IFormat
  (format- [this]))

(defrecord Cal [d m y])
(extend-protocol IFormat 
  Cal
  (format- [this] (str (.-d this) "." (.-m this) "." (.-y this))))
(format- (Cal. 25 4 2017))
;; implements protocol directly in record
(defrecord Cal2 [d m y]
  IFormat
  (format- [_] (str d "." m "." y))
  java.lang.Comparable
  (compareTo [_ o2]
    (compare [y m d]
      [(.-y o2) (.-m o2) (.-d o2)])))

(def c2 (Cal2. 22 4 2017))
(.format- c2)
(.compareTo (Cal2. 12 4 2017) (Cal2. 14 04 2017))


