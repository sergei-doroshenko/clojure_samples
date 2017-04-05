;; collections
; List
(ns samples.w01.collections-example)

'(1 2 3)
(list 1 2 3 4) ; linked list
(def l (list 1 2 3))
(conj l 4 5 6)
(nth l 2 :default)
(nth l 20 10)

;; Vector
[1 2 3 4]
(class [])
(def v [1 2 3])
(conj v 4 5 6)
(nth v 2) ;; iterate throu the vector
(get v 0 :default) ;; random access

;; Map
(def m {:x 10 [1 2 3] 20})
(sorted-map "y" 2 "x" 3)
(get m :x :default)
(assoc m :z 30)
(get m :z)
(dissoc m [1 2 3])
(contains? m :x)
(contains? {:a 1 :b 2} :a) ;; true

;; Set
(def s #{1 2 3})
(conj s 4)
(conj s 2) ;; returns #{1 3 2}, doesn't add dublicated element
(contains? s 2)
(get s 1)
(clojure.set/union #{1 2 3} #{4 5 6} #{"hello" "goodbye"})
(clojure.set/difference #{1 2 3 4} #{3 4}) ;; #{1 2}

;; Equality
(= [1 2 3] '(1 2 3))
(= #{[1 2 3]} #{'(1 2 3)})

;; Immutability

