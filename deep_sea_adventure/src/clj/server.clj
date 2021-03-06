(ns server
  (:require [ring.util.response :refer [file-response]]))

(defn not-found-handler
  [_]
  (assoc-in
   (file-response "resources/dev_index.html")
   [:headers "Content-Type"]
   "text/html;charset=utf8"))
