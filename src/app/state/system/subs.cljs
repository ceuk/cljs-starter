(ns app.state.system.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-page
 #(get % :active-page))
