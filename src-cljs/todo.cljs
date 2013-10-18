(ns cljs-todo.todo
  (:use-macros
   [dommy.macros :only [node sel sel1]])
  (:require
   [dommy.core :as dommy]))


(defn add-todo!
  []
  (dommy/append! (sel1 :#todos-div) (node [:p "Make cljs todo app"])))


(dommy/listen! (sel1 :#todo-add-btn) :click add-todo!)
