(ns samples.w02.concurrency.vars)

(def ^:dynamic *test-var* 10)
(println *test-var*)

(let [a (agent {})]
  (send a
        (fn [_] (do (
                      (binding [*test-var* 100]
                        (println *test-var*)))))))

(println *test-var*)

(defn add-to-var [num]
  (+ *test-var* num))

(defn print-var [txt]
  (println txt *test-var*))

(defn run-thread [x]
  (.run (fn []
          (print-var (str "Thread " x " before:"))
          (binding [*test-var* (rand-int 10000)]
            (print-var (str "Thread " x " after:"))))))
;(doseq [x (range 3)] (run-thread x))
(for [x (range 3)] (run-thread x))

(let [t (Thread. (fn []
                   (alter-var-root #'*test-var* (constantly 223))
                   (println (str "new value: " *test-var*))))]
  (.start t))
(println *test-var*)