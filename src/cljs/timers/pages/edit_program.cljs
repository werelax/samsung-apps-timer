(ns timers.pages.edit-program
  (:require [timers.state :refer [program] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.routes :as routes]))

(defn page [id]
  (marauder/set-current! program (if id
                                   (marauder/get-by program :id
                                                    (js/parseInt id))
                                   (marauder/bake-new program)))
  (fn []
    (let [current-program (marauder/get-current program)]
      [:div
     (elements/top-bar
      (elements/accept-cancel-buttons
       (utils/call-and-go
        #(marauder/save-current! program)
        routes/main-path)
       (utils/call-and-go
        #(marauder/cleanup-current! program)
        routes/main-path)))
     [:div.content
      [:form.fill-form
       {:on-submit #(.preventDefault %)}
       [:div.form-item
        [:label {:for "title"} "Name"]
        [:input {:name "title" :type "text"
                 :value (get current-program :title)
                 :on-change (utils/form-updater program :title)}]]

       (when id
         [:div
          [:label "Delete this program:"]
          (elements/button {:title " DELETE"
                            :color :terciary
                            :icon "fa-close"
                            :style {"width" "100%"}
                            :action (utils/call-and-go
                                     #(marauder/remove! program current-program)
                                     #(routes/main-path))})])]]])))
