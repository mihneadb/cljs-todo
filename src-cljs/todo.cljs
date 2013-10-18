(ns cljs-todo.todo
  (:use-macros
   [dommy.macros :only [node sel sel1]])
  (:require
   [dommy.core :as dommy]))


(defn add-todo!
  []
  (let [todo-input (sel1 :#todo-input)
        todo-value (dommy/value todo-input)
        todos-div (sel1 :#todos-div)]
    (dommy/append! todos-div (node [:p todo-value]))
    (dommy/set-value! todo-input "")))

(defn enter-add-todo!
  [evt]
  (when (= 13 (.-keyCode evt))
    (add-todo!)))


(dommy/listen! (sel1 :#todo-add-btn) :click add-todo!)
(dommy/listen! (sel1 :#todo-input) :keyup enter-add-todo!)
