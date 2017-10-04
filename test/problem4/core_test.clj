(ns problem4.core-test
  (:require [clojure.test :refer :all]
            [problem4.core :refer :all]))

(deftest a-test
  (testing "Should return 9009"
    (is (= 9009 (palin-product 2)))))
