(ns elyses-destructured-enchantments.core
  (:gen-class))

(defn first-card
  [deck]
  (let [[n-1-card & other-cards]  deck]
       n-1-card )
  )


(defn second-card
  [deck]
  (let [[n-1-card n-2-card & other-cards]  deck]
       n-2-card )
  )

(defn swap-top-two-cards
  [deck]
  (let [[n-1-card n-2-card & other-cards]  deck]
       (conj (conj other-cards n-1-card) n-2-card))
  )

(defn discard-top-card
  [deck]
  (let [[n-1-card & other-cards]  deck]
       [n-1-card other-cards])
  )
(def face-cards ["jack" "queen" "king"])

(defn insert-face-cards
  [deck]
  (cond
    (= 0 (count deck)) face-cards
    :else (let [[n-1-card  & other-cards]  deck]
          (conj (concat face-cards other-cards) n-1-card))
        )
    )



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
