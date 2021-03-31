(ns app.components.hello.view
  (:require [re-frame.core :refer [subscribe dispatch]]
            [app.state.counter.subs :as subs]
            [app.state.counter.events :as events]
            [reagent.core :as r]))

(defn click-counter [click-count]
  [:div
   "The atom " [:code "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me!"
            :on-click #(dispatch [::events/increment-counter])}]])

(defn hello []
  [:<>
   (let [count (subscribe [::subs/counter])]
     [:p "Hello, learn_reframe is running!"]
     [:p "Here's an example of using a component with state:"]
     [click-counter count])])
