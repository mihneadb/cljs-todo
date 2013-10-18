(ns cljs-todo.todo
  (:use-macros
   [dommy.macros :only [node sel sel1]])
  (:require
   [dommy.core :as dommy]))


(dommy/append! (sel1 :#todos-div) (node [:p "Make cljs todo app"]))
