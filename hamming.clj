(ns hamming.core
  (:gen-class))

(defn same-length?
  [seq-1 seq-2]
  (= (count seq-1) (count seq-2))
  )

(defn count-non-matching-pairs_old
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

(defn non-matching-pair?
  [pair]
  (not (= (first pair) (second pair)))
  )

(defn count-non-matching-pairs
  [seq-pairs]
  (count (filter non-matching-pair? seq-pairs))
  )

(defn hamming
  [seq-1 seq-2]
  (if (same-length? seq-1 seq-2)
    (let [seq-pairs (into [] (map vector seq-1 seq-2))]
      (count-non-matching-pairs seq-pairs))
    (throw (ex-info "Non matching length of arguments"
                    {:len-1 (count seq-1)
                     :len-2 (count seq-2)})))
  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def seq-1 ["A" "G" "T" "C"])
  (def seq-2 ["A" "G" "G" "C"])
  (def seq-1a ["A" "G" "T" "C"])
  (def seq-3 ["A" "A" "Y" "C"])
  (def seq-4 ["A" "G" "C"])
  
  (println (hamming seq-1 seq-1a))
  (println (hamming seq-1 seq-2))
  (println (hamming seq-1 seq-3))
  (try
    (println (hamming seq-1 seq-4))
    (catch Exception e (println (str "error: " (.getMessage e))))
    )
  )
