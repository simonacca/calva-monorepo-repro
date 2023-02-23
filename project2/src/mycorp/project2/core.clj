(ns mycorp.project2.core
  (:require [mycorp.lib1.core]))

(defn myfunk []
  (mycorp.lib1.core/myfunk)
  (prn "Hi from project1"))


(comment
  (myfunk))