(ns timers.page-utils
  (:require [timers.routes :as routes]
            [timers.lib.marauder :as marauder]))

(defn call-and-go [thunk route-thunk]
  (fn []
    (thunk)
    (routes/navigate! (route-thunk))))

(defn prevent-and-call [thunk]
  (fn [e]
    (.preventDefault e)
    (thunk)))

(defn form-updater [resource key]
  #(marauder/update-current! resource assoc key
                             (-> % .-target .-value)))
