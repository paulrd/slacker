(ns slacker.utils
  (:use [slacker.common])
  (:use [slacker.client :only [defn-remote]])
  (:use [slacker.client.common :only [introspect]])
  (:use [clojure.string :only [split]]))

(defmacro defn-remote-batch [sc & fnames]
  `(do ~@(map (fn [f] `(defn-remote ~sc ~f)) fnames)))

(defn get-all-funcs [sc]
  (let [result (introspect sc :functions)]
    (split result #",")))

(defn defn-remote-all [sc]
  (doseq [fname (get-all-funcs sc)]
    (defn-remote sc (symbol *ns* fname))))


