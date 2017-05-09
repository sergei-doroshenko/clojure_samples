(ns samples.w02.multi-methods02)

;; Multiple inheritance. Here we define a bot.
(def bot {:memory :file
          :iface  :console
          :brain  :default})

;; Here we define some functions with bot
;; bot derives file memory
;; here dispatch function is anonimous function
(defmulti remember (fn [bot k v] (:memory bot)))
(defmulti recall (fn [bot k] (:memory bot)))

;; bot derives console iface
(defmulti print-msg (fn [bot s] (:iface bot)))
(defmulti read-cmd (fn [bot] (:iface bot)))

;; bot derives default brain
(defmulti run-cmd (fn [bot cmd] (:brain bot)))

(defmethod remember :file [bot k v] "Write to a file!")
(remember bot "val" "key")
