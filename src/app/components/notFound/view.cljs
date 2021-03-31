(ns app.components.notFound.view
  (:require
   [app.styles.pageNotFound :as notFoundStyles]))

(defn notFound []
  [:div {:class notFoundStyles/root} "404 — Page not found"])

