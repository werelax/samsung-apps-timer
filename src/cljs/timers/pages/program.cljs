(ns timers.pages.program
  (:require [timers.state :refer [program] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.components.listing :as listing]
            [timers.routes :as routes]))

(defn page [program-id]
  (let [timers (marauder/find-by state/timer
                                 :program-id program-id)]
    [:div
     (elements/top-bar
      (elements/two-button-bar
       {:title "EDIT"
        :href (routes/edit-program-path {:program-id program-id})
        :color :terciary}
       {:title "NEW TIMER"
        :href (routes/new-timer-path {:program-id program-id})
        :color :secondary}))
     (listing/listing (constantly timers)
                      :title
                      #(routes/edit-timer-path {:program-id program-id
                                                :timer-id (:id %)}))
     (if (empty? timers)
       [:h3 {:style {:text-align "center"}} "Add some timers."]
       (elements/button {:title " START!"
                         :color :primary
                         :icon "fa-play"
                         :style {"width" "100%"}
                         :href (routes/start-program-path {:program-id program-id})
                         }))]))
