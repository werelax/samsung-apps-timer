(ns timers.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]
              [timers.routes :as routes]
              ;; app pages
              [timers.pages.main :as main]
              [timers.pages.program :as program]
              [timers.pages.timer :as timer]
              [timers.pages.edit-program :as edit-program]
              [timers.pages.edit-timer :as edit-timer]))

;; -------------------------
;; Route-page Map
(def names-to-pages
  {:main main/page
   :edit-program edit-program/page
   :program program/page
   :edit-timer edit-timer/page
   :timer timer/page})

;; -------------------------
;; Views
(defn current-page []
  (let [{:keys [name params] :or {params []}} (session/get :current-page)
        page (names-to-pages name)]
    `[~page ~@params]))

;; -------------------------
;; Initialize app
(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (routes/hook-browser-navigation!)
  (mount-root))
