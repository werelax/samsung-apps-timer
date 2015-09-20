(ns timers.pages.program
  (:require [timers.state :refer [program] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.components.listing :as listing]
            [timers.routes :as routes]))

(defn page [program-id]
  [:div
   (elements/top-bar
    (elements/two-button-bar
     {:title "ADD"
      :href (routes/new-timer-path {:program-id program-id})
      :color :primary}
     {:title "START"
      :href (routes/start-program-path {:program-id program-id})
      :color :secondary}))
   (listing/listing #(marauder/find-by state/timer
                                       :program-id program-id)
                    :title
                    #(routes/edit-timer-path {:program-id program-id
                                              :timer-id (:id %)}))])
