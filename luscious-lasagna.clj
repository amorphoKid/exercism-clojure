(ns lasagna.core
  (:gen-class))
(def expected-time 40) 

(defn remaining-time
  [current-time]
  (max 0 (- expected-time current-time))
  ) 

(defn preparation-time
  [layers]
  (* 2 layers))

(defn total-time
  [current-time layer]
  (+ current-time (preparation-time layer))
       )
  

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println expected-time)
  (println (remaining-time 10))
  (println (preparation-time 4))
  (println (total-time 20 4))
  )
