(ns deep-sea-adventure.subs.core
  (:require [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]

            [deep-sea-adventure.subs.bootstrap]))

(rf-notifier/register-subscriptions)
(rf-request/register-subscriptions)
(rf-routing/register-subscriptions)
