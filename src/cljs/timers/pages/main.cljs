(ns timers.pages.main
  (:require [timers.state :as state]
            [timers.lib.marauder :as marauder]
            [timers.components.elements :as elements]
            [timers.components.listing :as listing]
            [timers.routes :as routes]))

(defn page [_]
  [:div
   (elements/top-bar
    (elements/plus-button (routes/new-program-path)))
   (listing/listing #(marauder/get-all state/program)
                    :title
                    #(routes/program-path {:program-id (:id %)}))])
