(ns timers.routes
  (:require [secretary.core :as secretary :include-macros true]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.session :as session])
  (:import goog.History))

;; -------------------------
;; Routes
(secretary/set-config! :prefix "#")

(secretary/defroute main-path "/" []
  (session/put! :current-page {:name :main}))

(secretary/defroute new-program-path "/new" []
  (session/put! :current-page {:name :edit-program
                               :params [nil]}))

(secretary/defroute program-path "/:program-id" [program-id]
  (session/put! :current-page {:name :program
                               :params [program-id]}))

(secretary/defroute new-timer-path "/:program-id/new" [program-id]
  (session/put! :current-page {:name :edit-timer
                               :params [program-id nil]}))

(secretary/defroute "/:program-id/edit" [program-id]
  (session/put! :current-page {:name :edit-program
                               :params [program-id]}))

(secretary/defroute start-program-path "/:program-id/start" [program-id timer-id]
  (session/put! :current-page {:name :timer
                               :params [program-id timer-id]}))

(secretary/defroute edit-timer-path "/:program-id/:timer-id" [program-id timer-id]
  (session/put! :current-page {:name :edit-timer
                               :params [program-id timer-id]}))

;; -------------------------
;; Utils
(defn navigate! [url]
  (set! (.-hash js/location) url))

;; -------------------------
;; History
;; must be called after routes have been defined
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))
