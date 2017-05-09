(ns samples.w02.file-sys
  (:require [clojure.java.io :as io]))

(spit "file.txt" [:a 1])
(slurp "file.txt")                                          ;; URLs, Readers, Socets

*in*
*out*
*err*

;; writer example
(with-open [wr (io/writer "out.txt")]
  (binding [*out* wr]
    (print "Hello, Sergei!!!")
    (flush)))
(slurp "out.txt")

(with-out-str
  (print "Hello, again!!!")
  (flush))

;; reader example
(with-open [rd (io/reader "out.txt")]
  (vec
    (for [line (line-seq rd)]
      line)))
;; same
(with-open [rd (io/reader "file.txt")]
  (vec (line-seq rd)))                                      ;; lazy sequence

(io/as-file "out.txt")
(.getName (io/as-file "out.txt"))
(file-seq (io/as-file "out.txt"))

(spit "resources/custom.properties"
      "start.button.name=Start")
(slurp "resources/custom.properties")
(io/resource "custom.properties")
