(ns samples.w01.string-example)

(class "Hello")

(.length "abc")
(count "hello")
(.indexOf "abc" "b")
;; convert to string
(str 1)
(str [1 2 3])
(str 1 "-" :x "-" nil)

(format "number %07d, Hello %s" 345 "test")
(format "Total: %07d" 345)
(subs "hellosergei" 2 7)

(require '[clojure.string :as str])
(str/join "--" [1 2 3 4])
(str/split "1, 2, 3, 4   " #",\s+")
(str/upper-case "main func")

(re-find #"a+" "aaabbbccc")
(re-matches #"aaa.*" "aaabbbccc")
(re-seq #"a+" "aaaaabbaaaa")

(str/replace "dog cat mouse" "cat" "horse")
(str/replace "dog cat mouse" #"dog|cat" str/upper-case)
(str/replace "dog cat mouse" #"dog|cat" #(apply str (reverse %)))
