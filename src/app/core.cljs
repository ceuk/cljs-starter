(ns app.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [app.config :as config]
            [app.views :as views]
            [app.events :as events]
            [app.routes :as routes]
            [router.core :as router]))

(defn dev-setup! []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root! []
  (let [mount-div (.getElementById js/document "app")]
    (re-frame/clear-subscription-cache!)
    (reagent/render [views/render] mount-div)))

(defn ^:export main! []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup!)
  (router/init!)
  (mount-root!))

(defn reload! []
  (router/reload!)
  (reagent/force-update-all))
