(ns samples.w01.collections-as-functions)

(map {:x 1} [:x :y :z])
(filter #{1 2 3} [3 4 5 6])

(def v [:a :b :c])
(get v 1)
(v 1)
(= (get v 0) (v 0))

(def m {1 "one"
        2 "two"
        3 "three"})
(get m 10 "?")
(m 2 "?")

(map #(get m % "?") [1 2 3 2 1 4 2])
(map m [1 2 3])

(def s #{"piss" "fuck"})
(get s "piss")
(s "fuck")
(remove #(get s %) ["cat" "dog" "fuck" "piss" "horse"])
(remove s ["cat" "dog" "fuck" "piss" "horse"])

;; Keyword is a function that looks for itself
:k1 :k2
(get {:k1 1 :k2 2} :k1)
(:k1 {:k1 1 :k2 2} 7)
(:k3 {:k1 1 :k2 2} 7)

(defn f [m] (:key m)) ;; null safe call
{:name "Sergei" :age 37}
(def users [
            {:name "Jhon" :age 30}
            {:name "Sara" :age 24}
            {:name "Adam" :age 35}])
            
;; get all users names
(map #(get % :name) users)
(map :name users)
(apply min (map :age users))


            
