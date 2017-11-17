(ns deep-sea-adventure.containers.home

  (:require [re-frame.core :as re-frame]))

(defn li-player [player]
  [:li {:key player} player])

(defn on-key-press [evt]
  (fn [e]
    (if (= 13 (.-charCode e))
      (re-frame/dispatch [evt])
      (.-preventDefault e))))

(defn on-change [evt]
  (fn [e]
    (re-frame/dispatch [evt (-> e .-target .-value)])))

(defn home []
  (let [players (re-frame/subscribe [:dsa/players])
        current-player-name (re-frame/subscribe [:dsa/current-player-name])
        game-started (re-frame/subscribe [:dsa/game-started])]
    [:div [:h1 "Deep Sea Adventure"] 
     [:div [:p "Players:"]
      [:ul (map li-player @players)]]
     [:input
      {:type "text"
       :value @current-player-name
       :on-key-press (on-key-press :dsa/save-player)
       :on-change (on-change :dsa/update-current-player-name)}]
     [:button {
               :on-click 
               (fn [e] (re-frame/dispatch [(if @game-started :dsa/stop-game :dsa/start-game)]))}
      (if @game-started "Stop Game" "Start Game")]]))


