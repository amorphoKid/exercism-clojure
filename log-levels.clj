(ns log-levels.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn message
  [log-msg]
  (str/trim (nth (nth (re-seq #"\[([A-Z]+)\]:\s+(.+)" log-msg) 0) 2)) 
  )


(defn log-level
  [log-msg]
  (str/lower-case (str/trim (nth (nth (re-seq #"\[([A-Z]+)\]:\s+(.+)" log-msg) 0) 1))) 
  )

(defn reformat
  [s]
  (str/join [(message s) " (" (log-level s) ")"])
  )


  
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
