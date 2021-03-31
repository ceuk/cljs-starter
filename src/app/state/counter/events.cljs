(ns app.state.counter.events
  (:require
   [re-frame.core :as re-frame]
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

(re-frame/reg-event-db ::increment-counter
                       (fn-traced [db]
                                  (assoc db :counter (inc (get db :counter)))))

