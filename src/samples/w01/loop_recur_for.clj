(ns samples.w01.loop-recur-for)

(loop [i 0]
  (if (< i 10)
    (do (println i)
        (recur (+ i 1)))))

(def letters (seq ["a" "b" "c"]))
(for [l letters] (println l))

(def v nil)
(println (if v "yes" "no"))

(let [data ["x" "y" "z"]]
  (loop [i 1
         l (first data)]
    (if l
      (do (println l)
          (recur (+ i 1) (get data i))))))

(for [x (range 10)]
  (println (str "x: " x)))
