(ns samples.w02.advanced.reducers
  require '[clojure.core.reducers :as r])
(def v [1 2 3])

(banch (reduce + (map inc v)))
(banch (r/reduce + (r/map inc v)))


