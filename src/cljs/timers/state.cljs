(ns timers.state
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [timers.lib.marauder :as marauder]))

(defonce state (atom {:programs []}))
(defonce current (atom {}))
;; Ticker
(defonce clock (atom 0))

(defn now [] (.now js/Date))
(defonce clock-timer (atom (now)))
(js/clearInterval @clock-timer)
(reset! clock-timer (js/setInterval #(reset! clock (now))
                                    1000))


;; -------------------------
;; Utilities

(defn accessor [store path]
  (fn
    ([]
     (get-in @store path))
    ([value]
     (swap! store assoc-in path value))
    ([operation & rest]
     (apply swap! store operation path rest))))

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

(def play-start-timestamp
  (accessor state [:play-timer-timestamp]))

;; -------------------------
;; Models DSL

(defn transform-duration [x]
  (* 1000 x))

(defn timers-with-offset [timers started-stamp current-stamp]
  (map-indexed (fn [idx timer]
                 (let [offset (->> (take idx timers)
                                   (map :duration)
                                   (map transform-duration)
                                   (reduce +)
                                   (+ started-stamp))
                       duration-ms (transform-duration (:duration timer))
                       finished? (< (+ offset duration-ms) current-stamp)]
                   (merge timer {:offset offset
                                 :duration-ms duration-ms
                                 :finished? finished?})))
               timers))
