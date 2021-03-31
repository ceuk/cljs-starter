(ns app.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-page
 #(get % :active-page))

(re-frame/reg-sub
 ::counter
 #(get % :counter))

