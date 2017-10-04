(ns problem4.core
  (require [clojure.string :as str]))

(defn exp 
  "Raises 10 to the nth power"
  [n]
  (reduce * (repeat n 10)))

(defn is-palin
  "Returns true if value passed is a palindrone"
  [x]
  (let [digits (str/split (str x) #"")]
  (= digits (reverse digits))))

(defn digit-count 
  "Returns the number of digits in a number"
  [num]
  (count (str/split (str num))))

(defn palin-product
  "Finds palindrome product of x number of digits"
  [x]
  (def max-palin (atom 0))
  (loop [factor1 (- (exp x) 1)
         factor2 (- (exp x) 1)]
    (let [product (* factor1 factor2)]
        (if (and (is-palin product) (> product @max-palin))
          (do 
            (reset! max-palin product)
            (if (>= (- factor2 1) (exp (- x 1)))
              (recur factor1 (- factor2 1))
              (if (>= (- factor1 1) (exp (- x 1)))
                (recur (- factor1 1) (- factor1 1)))))
          (if (>= (- factor2 1) (exp (- x 1)))
            (recur factor1 (- factor2 1))
            (if (>= (- factor1 1) (exp (- x 1)))
              (recur (- factor1 1) (- factor1 1)))))))
  @max-palin)
