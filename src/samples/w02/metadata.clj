(ns samples.w02.metadata)

(def m {:s 2})
(meta m)

(with-meta m {:doc "abc"})
(println (meta (with-meta m {:doc "abc"})))

;; compilers hints :private, :dynamic, :const
(def ^{:private true} x 0)
(:private (meta #'x))

;; can be private via :private or 'defn-'
(defn- f "docstring" ^ String [^Long x y z])
(meta #'f)
(println (:doc (meta #'f)))
(println (meta (first (:arglists (meta #'f)))))
(println (meta (first (first (:arglists (meta #'f))))))