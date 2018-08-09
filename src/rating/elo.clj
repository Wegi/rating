(ns rating.elo)

(defn- transact-player
  ([rating expected won]
   (transact-player rating expected won 10))
  ([rating expected won k-value]
   (Math/round (+ rating
                  (* 10
                     (- won expected))))))

(defn rate
  "Expects the current ratings of two players and an indicator who won and returns the new ratings of both players in order. This uses a default k value of 10 if none is provided."

  ([rating-one rating-two winner]
   (rate rating-one rating-two winner 10))

  ([rating-one rating-two winner k-value]
   (let [expected-one (/ 1
                         (inc (Math/pow 10
                                        (/ (- rating-two rating-one) 400))))
         expected-two (- 1 expected-one)]
     (case winner
       1 [(transact-player rating-one expected-one 1 k-value)
          (transact-player rating-two expected-two 0 k-value)]
       2 [(transact-player rating-one expected-one 0 k-value)
          (transact-player rating-two expected-two 1 k-value)]
       0 [(transact-player rating-one expected-one 0.5 k-value)
          (transact-player rating-two expected-two 0.5 k-value)]))))
