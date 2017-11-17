(ns deep-sea-adventure.containers.main

  (:require [re-frame.core :as re-frame]
            [deep-sea-adventure.router :refer [router]]))

(defn main
  "Outer most container of the application"
  []
  (let [is-bootstrapped (re-frame/subscribe [:bootstrap/finished?])]
    (fn []
      [:div
       (if @is-bootstrapped
         [router]
         [:h1 "Loading..."])])))
