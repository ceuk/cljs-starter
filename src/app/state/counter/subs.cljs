(ns app.state.counter.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::counter
 #(get % :counter))

