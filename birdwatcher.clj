(ns bird-watcher.core
  (:gen-class))

(def last-week [0 2 5 3 7 8 4])

(def birds-per-day [2 5 0 7 4 1])

(def always-a-bird [1 2 3 4 5 6 7])

(defn today
  [birds]
  (last birds)
  )

(defn rev_vec
  [vec]
  (into [] (rseq vec)))

(defn inc-bird
  [birds]
  (update-in birds [(- (count birds) 1)] inc)
  )

(defn inc-bird_alt
  [birds]
  (let [[today & other-days] (rev_vec birds)] (rev_vec (into [] (conj other-days (+ today 1)))) 
        ))

(defn day-without-birds?
  [birds]
  (= 0 (reduce * birds))
  )

(defn n-days-count
  [birds n]
  (reduce + (subvec birds 0 n)) 
  )

(defn busy-days
  [birds]
  (reduce (fn [sum num-birds] (+ sum (if (> num-birds 4) 1 0))) 0 birds)
  )

(defn odd-week?
  [birds]
  (= birds [1 0 1 0 1 0 1])
      )


(defn -main
  "demonstrating the functions above"
  [& args]
  (println (today birds-per-day))
  (println (inc-bird birds-per-day))
  (println (day-without-birds? birds-per-day))
  (println (n-days-count birds-per-day 4))
  (println (busy-days birds-per-day))
  (println (odd-week? [1 0 1 0 1 0 1]))
  )
