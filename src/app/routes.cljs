(ns app.routes
  (:require [re-frame.core :as re-frame]
            [app.state.system.subs :as subs]
            [app.state.system.events :as events]
            [secretary.core :as secretary :refer-macros [defroute]]
            [app.components.hello.view :refer [hello]]
            [app.components.notFound.view :refer [notFound]]))

;; Define routes
(defn app-routes []
  (defroute "/" []
    (re-frame/dispatch [::events/navigate-to :home-page]))
  (defroute "*" []
    (re-frame/dispatch [::events/navigate-to :not-found])))

;; Map routes to views
(defn select-active-page []
  (let [active-page (re-frame/subscribe [::subs/active-page])]
    (case @active-page
      :home-page [hello]
      [notFound])))

(defn render []
  [:div
   [select-active-page]])
