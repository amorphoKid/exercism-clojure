(ns hello-world.core
  (:gen-class))
(defn foo
  [x]
  (println "Hallo Welt")
  1)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (foo 1))
  )
