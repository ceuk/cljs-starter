(ns app.state.system.events
  (:require
   [re-frame.core :as re-frame]
   [app.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]))

(re-frame/reg-event-db ::initialize-db
                       (fn-traced [db]
                                  (let [db (db/init)]
                                    db)))

(re-frame/reg-event-db ::navigate-to
                       (fn-traced [db [_ active-page]]
                                  (assoc db :active-page active-page)))

