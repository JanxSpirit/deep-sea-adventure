(ns deep-sea-adventure.events.bootstrap
  (:require [re-frame.core :as re-frame]

            [deep-sea-adventure.db.core :refer [default-db]]
            [deep-sea-adventure.interceptors.core :refer [app-interceptors]]))

(defn initialize-player [name]
  {:pos 0
   :loot []
   :name name})

(defn reset-board []
  (let [cards-per-group 6
        card-groups (map
                     #(Math/round (+ 0.5 (/ % cards-per-group)))
                     (range 24.0))
        card-values (map
                     #((take-one (range (* 2 %) (+ (* 2 %) cards-per-group))))
                     card-groups)]
    (map (fn [a b] [a b]) card-groups card-values)))

(re-frame/reg-event-fx
 :bootstrap/start
 [app-interceptors]
 (fn [_ _]
   {:db default-db
    :dev-tools-init nil
    :pushy-init nil}))

(re-frame/reg-event-db
 :dsa/update-current-player-name
 (fn [db [_ value]]
   (assoc db :dsa/current-player-name value)))

(re-frame/reg-event-db
 :dsa/save-player
 (fn [db [_ value]]
   (-> db
       (assoc-in [:dsa/players (:dsa/current-player-name db)] (initialize-player (:dsa/current-player-name db)))
       (assoc :dsa/current-player-name ""))))

(re-frame/reg-event-db
 :dsa/start-game
 (fn [db [_ value]]
   (-> db
       (assoc :dsa/game-started true)
       (asoc :dsa/air-supply 25)
       (assoc :dsa/board (reset-board)))
   ))

(re-frame/reg-event-db
 :dsa/stop-game
 (fn [db [_ value]]
   (assoc db :dsa/game-started false)))
