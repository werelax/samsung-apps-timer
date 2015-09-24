(ns timers.components.elements
  (:require [timers.routes :as routes]
            [timers.page-utils :as utils]))

(defn top-bar [content]
  [:div.top-bar content])

(defn plus-button [href]
  [:div.one-col
   [:a.btn.btn-primary {:href href}
    [:span.fa.fa-plus]]])

(defn button [{title :title action :action color :color icon :icon href :href
               style :style :or {color :primary :href "#" style {}}}]
  [:a.btn {:href href
           :class (str "btn-" (name color))
           :style style
           :on-click (when action
                       (utils/prevent-and-call action))}
   " "
   (if icon
     [:span.fa {:class icon} title]
     [:span title])])

(defn two-button-bar [left right]
  [:div.two-cols
   (button left)
   (button right)])

(defn accept-cancel-buttons [ok-fn cancel-fn]
  (two-button-bar {:title "" :action cancel-fn
                   :color :terciary :icon "fa-close"}
                  {:title "" :action ok-fn
                   :color :secondary :icon "fa-check"}))
