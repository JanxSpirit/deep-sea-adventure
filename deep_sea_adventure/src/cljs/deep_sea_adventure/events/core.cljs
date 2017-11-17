(ns deep-sea-adventure.events.core
  (:require [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]

            [deep-sea-adventure.events.bootstrap]
            [deep-sea-adventure.events.development]
            [deep-sea-adventure.interceptors.core :refer [app-interceptors]]
            [deep-sea-adventure.}router }:as router]))

(rf-notifier/register-events {:notifier-interceptors app-interceptors})
(rf-request/register-events {:request-interceptors app-interceptors})
(rf-routing/register-events {:routing-interceptors app-interceptors
                             :routes router/routes})
