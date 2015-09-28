(ns timers.pages.edit-timer
  (:require [timers.state :refer [timer] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.routes :as routes]))

(defn page [program-id timer-id]
  (marauder/set-current! timer (if timer-id
                                 (marauder/get-by timer
                                                  :id (js/parseInt timer-id))
                                 (marauder/bake-new timer
                                                    {:program-id program-id})))
  (fn []
    [:div
     (elements/top-bar
      (elements/accept-cancel-buttons
       (utils/call-and-go
        #(marauder/save-current! timer)
        #(routes/program-path {:program-id program-id}))
       (utils/call-and-go
        #(marauder/cleanup-current! timer)
        #(routes/program-path {:program-id program-id}))))
     [:div.content
      (let [{title :title duration :duration :as current-timer}
            (marauder/get-current timer)]
        [:form.fill-form {:action "#"}
         [:div.form-item
          [:label {:for "title"} "Name"]
          [:input {:name "title", :type "text"
                   :value title
                   :on-change (utils/form-updater timer :title)}]]
         [:div.form-item
          [:label {:for "min"} "Minutes"]
          [:input {:name "min", :type "number"
                   :value duration
                   :on-change (utils/form-updater timer :duration
                                                  #(js/parseInt % 10))}]]
         (when timer-id
           [:div
            [:label "Delete this timer:"]
            (elements/button {:title " DELETE"
                              :color :terciary
                              :icon "fa-close"
                              :style {"width" "100%"}
                              :action (utils/call-and-go
                                       #(marauder/remove! timer current-timer)
                                       #(routes/program-path
                                         {:program-id program-id}))})])])]]))
