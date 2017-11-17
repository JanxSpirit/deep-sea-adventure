(ns deep-sea-adventure.subs.bootstrap
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :bootstrap/finished?
 (fn [{:keys [router]}]
   (and (:initialized router))))

(re-frame/reg-sub
 :dsa/players
 (fn [db v]
   (keys (:dsa/players db))))

(re-frame/reg-sub
 :dsa/current-player-name
 (fn [db v]
   (:dsa/current-player-name db)))

(re-frame/reg-sub
 :dsa/game-started
 (fn [db v]
   (:dsa/game-started db)))
