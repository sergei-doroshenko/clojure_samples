(ns samples.w01.exception)

(try
  (throw (Exception. "123"))
  (catch Exception e
    (.printStackTrace e)
    8))

(try
  (throw (ex-info "message" {:x 1 :y 2}))
  (catch clojure.lang.ExceptionInfo e
    [(.getMessage e) (ex-data e)]))
