(ns mycorp.project1.core
  (:require [mycorp.lib2.core]))

(defn myfunk []
  (mycorp.lib2.core/myfunk)
  (prn "Hi from project1"))


(comment
  (myfunk))