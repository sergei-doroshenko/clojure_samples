(ns samples.w02.with-local-v)

(defn factorial [x]
  (with-local-vars [acc 1, cnt x]
    (while (> @cnt 0)
      (var-set acc (* @acc @cnt))
      (var-set cnt (dec @cnt)))
    @acc))

(println (factorial 5))
