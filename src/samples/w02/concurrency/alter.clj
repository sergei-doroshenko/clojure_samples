(ns samples.w02.alter)

(def my_num (ref 0))
;; change to commute and see the results
(defn inc_alter []
  (dosync
    (try
      (println "Alter: " (alter my_num inc))
      (catch Throwable t
        (do
          (println "Caught " (.getClass t))
          (throw t))))))

(defn test_alter []
  (let [threads (for [x (range 0 50)] (Thread. #(inc_alter)))]
    (do
      (println "---- Alter ----")
      (doall (map #(.start %) threads))
      (doall (map #(.join %) threads))
      (println "---- After loop: ----")
      (inc_alter))))

(test_alter)
