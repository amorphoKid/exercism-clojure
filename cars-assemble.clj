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


(defn production-rate-alt
  [speed]
  (cond
    (== speed 0) 0
    (and (>= speed 1) (< speed 5)) (* 221 speed)
    (and (>= speed 5) (< speed 9)) (* 0.9 (* 221 speed))
    (and (>= speed 9) (< speed 10)) (* 0.8 (* 221 speed))
    (and (>= speed 10) (< speed 11)) (* 0.77 (* 221 speed))
    :else -1
    ) 
  )

(defn working-items
  [speed]
  (int (/ (production-rate speed) 60))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (working-items 6)))
