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

(defn check-match [query]
  (match query
         ["select" tbl & _]
         (do (println "Table is:" tbl)
             (check-match (vec (drop 2 query))))
         ["where" a b c] (println "Conditions:" a b c)
         :else (println "No match found!")))

(check-match (prepare-query "select students where id > 10"))
