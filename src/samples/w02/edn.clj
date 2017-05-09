(ns samples.w02.edn)
;; EDN better than JSON

(pr-str {:a 1})
(read-string "{:a 1}")

(spit "f.edn" {:b 3})
(read-string (slurp "f.edn"))
;; more safe method
(clojure.edn/read-string (slurp "f.edn"))

;; extension
;; #tag form
;; #inst "2017-05-02" -> java.util.Date. In this case '#inst' is a taged literal
(let [t #inst "2017-05-02"]
  (class t))                                                ;;java.util.Date

