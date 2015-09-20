(ns timers.state
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [timers.lib.marauder :as marauder]))

(defonce state (atom {:programs []}))
(defonce current (atom {}))

;; -------------------------
;; Resources

(def timer
  (marauder/collection {:path [:timers]
                        :atom state
                        :current-atom current
                        :generator #(merge {:title "" :duration 0 :message ""}
                                           %)}))

(def program
  (marauder/collection {:path [:programs]
                        :atom state
                        :current-atom current
                        :generator #(hash-map :title "")}))

(defn selected-program [operation & rest]
  (apply swap! state operation [:selected-program] rest))
