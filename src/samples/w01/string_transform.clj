(ns samples.w01.string-transform)

(require '[clojure.string :as str])
(def s "bps|feedbacks|publishing|runs|packages|studio|preferences|notifications|securestore|mxApplication|campaigns|datasource|qualifications|schedulers|fileuploads|permissions|users|usecases|images|botconfigs|filters|activities|definitions")
s
(->> (str/split s #"\|")
     (sort)
     (str/join "|"))

