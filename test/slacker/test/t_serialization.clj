(ns slacker.test.t-serialization
  (:use slacker.serialization, midje.sweet)
  (:import [java.util Arrays]))

(tabular "serialization"
         (fact ?data => (deserialize :carb (serialize :carb ?data)))
         ?data
         [1 2 3]
         {:a 1 :b 2}
         #{1 2 3}
         "hello"
         :world
         87742)

(facts "json serialization"
 (tabular
  (fact ?data => (deserialize :json (serialize :json ?data)))
  ?data
  [1 2 3]
  {:a 1 :b 2}
  "hello"
  87742)
 (tabular
  (fact ?data => (deserialize :json (serialize :json ?data :bytes) :bytes))
  ?data
  [1 2 3]
  {:a 1 :b 2}
  "hello"
  87742)
 (tabular
  (fact ?data => (deserialize :json (serialize :json ?data :string) :string))
  ?data
  [1 2 3]
  {:a 1 :b 2}
  "hello"
  87742)
 "[1,2,3]" => (serialize :json [1 2 3] :string))

(facts "clojure serialization"
 (tabular (fact ?data => (deserialize :clj (serialize :clj ?data)))
  ?data
  [1 2 3]
  {:a 1 :b 2}
  #{1 2 3}
  "hello"
  87742)
  (tabular
   (fact ?data => (deserialize :clj (serialize :clj ?data :bytes) :bytes))
   ?data
   [1 2 3]
   {:a 1 :b 2}
   #{1 2 3}
   "hello"
   87742)
  (tabular
   (fact ?data => (deserialize :clj (serialize :clj ?data :string) :string))
   ?data
   [1 2 3]
   {:a 1 :b 2}
   #{1 2 3}
   "hello"
   87742)
  "[1 2 3]" => (serialize :clj [1 2 3] :string))

(tabular "compression"
         (fact ?data => (deserialize :deflate-carb
                                     (serialize :deflate-carb ?data)))
         ?data
         [1 2 3]
         {:a 1 :b 2}
         #{1 2 3}
         "hello"
         87742)
