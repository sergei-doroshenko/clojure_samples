(ns samples.w01.binding)

(def x 1)

(defn f [x] x)

(def ^:dynamic *log* false)

;; change value for a partucular code block
(binding [*log* 77] *log*)

*log*
;; set some context
(def ^:dynamic *pprint* false)
(def ^:dynamic *escape-unicode* false)

;;(defn write-json [obj & {as: options}] [obj options]) 
  ;(binding [*pprint* (:pprint opts false)]) (str obj))
 ;;--> str
(write-json [1 2 3])    ;;--> "1 2 3"

(defn to-json [obj & {:as opts}]
  (binding [*pprint* (:pprint opts "test")])
  (str obj "-" *pprint*))

(to-json "input")



