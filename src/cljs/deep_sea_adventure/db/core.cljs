(ns deep-sea-adventure.db.core
  (:require [cljs.spec.alpha :as s]
            [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]))

(def default-db
  {:notifier rf-notifier/initial-state
   :request rf-request/initial-state
   :router rf-routing/initial-state
   :dsa/players {}
   :dsa/board []
   :dsa/current-player-name ""
   :dsa/game-started false
   :dsa/air-supply 25
   })

(s/def ::db (s/keys :req-un [:re-frame-notifier.core/notifier
                             :re-frame-request.core/request
                             :re-frame-routing.core/router
                             :dsa/players
                             :dsa/board
                             :dsa/air-supply
                             :dsa/game-started
                             :dsa/current-player-name]))
