(ns annalyn-infiltration.core
  (:gen-class))

(defn can-fast-attack?
  [knight-awake?]
  (not knight-awake?)
  )

(defn can-spy?
  [knight-awake? archer-awake? prisoner-awake?]
  (or knight-awake? archer-awake? prisoner-awake?)
  )

(defn can-signal-prisoner?
  [archer-awake? prisoner-awake?]
  (and (not archer-awake?) prisoner-awake?)
  )

(defn can-free-prisoner?
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
 (or (and dog-present? (not archer-awake?)) (and (not knight-awake?) (not archer-awake?) prisoner-awake?)) )




 
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
