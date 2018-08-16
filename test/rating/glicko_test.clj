(ns rating.glicko-test
  (:require [rating.glicko :as glicko]
            [clojure.test :refer [testing is deftest]]))


(deftest test-valid-input
  (testing "Test whether the validation is done properly"
    (is (nil? (glicko/rate {})))
    (is (nil? (glicko/rate {:games []
                            :dingos []})))
    (is (nil? (glicko/rate {:players {}
                            :what? []})))
    (is (nil? (glicko/rate {:players {}
                            :games []})))
    (is (nil? (glicko/rate {:players [] ;;tbd
                            })))))
