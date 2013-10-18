(ns cljs-todo.todo
  (:use-macros
   [dommy.macros :only [node sel sel1]])
  (:require
   [dommy.core :as dommy]))


(defn add-todo!
  "Get the text value from #todo-input and add it as a new
  paragraph in #todos-div."
  []
  (let [todo-input (sel1 :#todo-input)
        todo-value (dommy/value todo-input)
        todos-div (sel1 :#todos-div)]
    (dommy/append! todos-div (node [:p todo-value]))
    ; clear the input
    (dommy/set-value! todo-input "")))

(defn enter-add-todo!
  "Add the todo when enter is pressed in #todo-input."
  [evt]
  (when (= 13 (.-keyCode evt))
    (add-todo!)))

; bind corresponding events
(dommy/listen! (sel1 :#todo-add-btn) :click add-todo!)
(dommy/listen! (sel1 :#todo-input) :keyup enter-add-todo!)
