(ns cars-assemble.core
  (:gen-class))

;;learnings:
;;- how to switch case in closure (or should I use a map/vec instead?=
;; numbers float to int (round/floor/type cast to int)
;; use local vars in functions (is that this "let" ?)

(defn production-rate
  [speed]
  (let [cars-per-hour (* speed 221)
        rate [0.0 1.0 1.0 1.0 1.0 0.9 0.9 0.9 0.9 0.8 0.77]
        ]
    (* cars-per-hour (nth rate speed))
    )
  )

(defn working-items
  [speed]
  (int (/ (production-rate speed) 60))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
