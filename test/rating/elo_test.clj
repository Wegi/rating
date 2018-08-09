(ns rating.elo-test
  (:require [rating.elo :as elo]
            [clojure.test :refer [deftest is testing] ]))

(deftest test-rate
  (testing "Test whether the rate function calculates the new scores properly"
    (is (= [2808 2575] (elo/rate 2806 2577 1)))
    (is (= [2798 2585] (elo/rate 2806 2577 2)))
    (is (= [2803 2580] (elo/rate 2806 2577 0)))))
