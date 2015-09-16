(ns timers.components.elements
  (:require [timers.routes :as routes]
            [timers.page-utils :as utils]))

(defn top-bar [content]
  [:div.top-bar content])

(defn plus-button [href]
  [:div.one-col
   [:a.btn.btn-primary {:href href}
    [:span.fa.fa-plus]]])

(defn accept-cancel-buttons [ok-fn cancel-fn]
  [:div.two-cols
   [:a.btn.btn-terciary {:href "#" :on-click (utils/prevent-and-call cancel-fn)}
    " " [:span.fa.fa-close]]
   [:a.btn.btn-secondary {:href "#" :on-click (utils/prevent-and-call ok-fn)}
    " " [:span.fa.fa-check]]])
