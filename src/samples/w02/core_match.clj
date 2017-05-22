(ns samples.w02.core-match
  (:use [clojure.core.match :only (match)]))

(def req (vec (.split "select students where id > 10" " ")))
(println req)

(match req
       ["select" & _]
       (println "Match found!")
       :else (println "No match found!"))


(defn prepare-query [query]
  (vec (.split query " ")))

(defn check-match2 [query]
  (match query
         ["select" tbl & _]
         (do (println "Table is:" tbl)
             (check-match (vec (drop 2 query))))
         ["where" a b c] (println "Conditions:" a b c)
         :else (println "No match found!")))

;(check-match (prepare-query "select students where id > 10"))

(defn check-match [query, res]
  (match query
         ["select" tbl & _]
         (do (println "Table is:" tbl)
             (check-match (vec (drop 2 query)) (conj res (str tbl))))
         ["where" a b c & _]
         (do (println "Conditions:" a b c)
             (check-match (vec (drop 4 query)) (conj res :where a b c)))
         ["order" _ f & _]
         (do (println "order by: " f)
             (check-match (vec (drop 3 query)) (conj res :order-by f)))
         ["limit" n & _]
         (do (println "limit: " n)
             (check-match (vec (drop 2 query)) (conj res :limit n)))
         ["join" tbl _ lcol _ rcol & _]
         (do (println "join: " tbl " on " lcol " = " rcol)
             (check-match (vec (drop 2 query)) (conj res :joins [lcol tbl rcol])))
         :else (apply list res)))
(println
  (check-match
    (prepare-query "select student where id = 10 order by id limit 2 join subject on id = sid")
    []))
