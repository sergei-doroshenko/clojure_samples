(ns samples.w02.reify-proxy
  (:import (java.util ArrayList Collections Comparator Timer TimerTask)))

(let [arr (ArrayList. [3 1 2 4])
      dir -1
      comp (reify Comparator
             (compare [this a b]
               (* dir (- b a))))]
  (Collections/sort arr comp)
  arr)

;; (proxy [SuperClass IFaces ...] [constructor-args]
;;  (method [args] ... ))

(let [task (proxy [TimerTask] []
             (run []
               (println (rand))))]
  (.schedule (Timer.) task 500))
