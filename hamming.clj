(ns hamming.core
  (:gen-class))

(defn same-length?
  [seq-1 seq-2]
  (= (count seq-1) (count seq-2))
  )

(defn count-matching-pairs
  [seq-pairs]
    (loop [n-matches 0
           pairs seq-pairs]
      (if (= 0 (count pairs))
        n-matches
        (let [cur-pair (last pairs)
             remaining-pairs (pop pairs)]
             (if (= (first cur-pair) (second cur-pair))
               (recur (inc n-matches) remaining-pairs)
               (recur n-matches remaining-pairs))
             ))
      )
    
  )

(defn hamming
  [seq-1 seq-2]
  (if (same-length? seq-1 seq-2)
    (let [seq-pairs (into [] (map vector seq-1 seq-2))]
      (count-matching-pairs seq-pairs))
    (throw (ex-info "Non matching length of arguments"
                    {:len-1 (count seq-1)
                     :len-2 (count seq-2)})))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
