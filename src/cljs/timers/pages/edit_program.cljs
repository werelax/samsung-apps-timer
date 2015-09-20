(ns timers.pages.edit-program
  (:require [timers.state :refer [program] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.routes :as routes]))

(defn page [id]
  (marauder/set-current! program (if id
                                   (marauder/get-by program :id id)
                                   (marauder/bake-new program)))
  (fn []
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
        [:label {:for "title"} "Nombre"]
        [:input {:name "title" :type "text"
                 :value (get (marauder/get-current program) :title)
                 :on-change (utils/form-updater program :title)}]]]]]))
