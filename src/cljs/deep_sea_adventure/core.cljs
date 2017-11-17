(ns deep-sea-adventure.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]

            [deep-sea-adventure.containers.main :refer [main]]
            [deep-sea-adventure.events.core]
            [deep-sea-adventure.subs.core]))

(defn mount-root []
  (reagent/render [main]
                  (js/document.getElementById "app")))

(defn init []
  (re-frame/dispatch [:bootstrap/start])
  (mount-root))
