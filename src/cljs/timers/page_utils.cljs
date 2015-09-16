(ns timers.page-utils
  (:require [timers.routes :as routes]))

(defn call-and-go [thunk route-thunk]
  (fn []
    (thunk)
    (routes/navigate! (route-thunk))))

(defn prevent-and-call [thunk]
  (fn [e]
    (.preventDefault e)
    (thunk)))
