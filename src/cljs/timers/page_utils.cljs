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

(defn form-updater
  ([resource key] (form-updater resource key identity))
  ([resource key transformer]
   #(marauder/update-current! resource assoc key
                              (transformer (-> % .-target .-value)))))
