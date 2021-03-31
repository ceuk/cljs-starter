(ns app.views
  (:require [re-frame.core :as re-frame]
            [app.subs :as subs]
            [app.hello :refer [hello]]
            [app.styles.pageNotFound :as notFoundStyles]))

(def shadow-cljs-logo
  "https://raw.githubusercontent.com/thheller/shadow-cljs/master/src/main/shadow/cljs/devtools/server/web/resources/img/shadow-cljs.png")

(defn link [href text]
  [:a {:href href}
   text])

(defn home-page []
  [:div
   [:header
    [:img {:src shadow-cljs-logo}]]
   [:h1 "Welcome to app!"]
   [:main
    [:p "This template is a combination of multiple technologies mainly based around re-frame and PostCSS.
        In case you need it, you can find documentations below to help you getting started."]
    [:div
     [link "https://github.com/day8/re-frame" "re-frame"]
     [link "https://reagent-project.github.io/" "reagent"]
     [link "https://clojurescript.org/" "ClojureScript"]
     [link "https://shadow-cljs.github.io/docs/UsersGuide.html" "Shadow CLJS"]
     [link "https://github.com/ghivert/modular-styles" "Modular Styles"]
     [link "https://postcss.org/" "PostCSS"]]]])

(defn not-found []
  [:div {:class notFoundStyles/root} "404 — Page not found"])

(defn select-active-page []
  (let [active-page (re-frame/subscribe [::subs/active-page])]
    (case @active-page
      :home-page [hello]
      [not-found])))

(defn render []
  [:div
   [select-active-page]])
