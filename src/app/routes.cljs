(ns app.routes
  (:require [re-frame.core :as re-frame]
            [secretary.core :as secretary :refer-macros [defroute]]
            [app.events :as events]))

(defn app-routes []
  (defroute "/" []
    (re-frame/dispatch [::events/navigate-to :home-page]))
  (defroute "*" []
    (re-frame/dispatch [::events/navigate-to :not-found])))
