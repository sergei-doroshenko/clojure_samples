(ns samples.w02.protocols
  (:import (java.util Date))
  (:require [clojure.string :as str]))

(defprotocol ICal 
  (day   [_])
  (month [_ base-month])
  (year  [_]))

(defn format-cal [cal] 
  (str (day cal) "." (month cal 1) "." (year cal)))

(extend-type Date 
  ICal
  (day   [this] (.getDate this))
  (month [this base-month] (+ base-month (.getMonth this)))
  (year  [this] (+ 1900 (.getYear this))))

;; call function, created new Date()
(format-cal (Date.))

;; create interface on the fly
(defn create-ical [d m y] 
  (reify ICal 
    (day   [_] d)
    (month [_ b] (+ b m))
    (year  [_] y)))

(format-cal (create-ical 26 4 2017))
