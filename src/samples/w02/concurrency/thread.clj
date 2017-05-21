(ns samples.w02.concurrency.thread)

(.run (Thread. #(println "Hello Thread!")))
