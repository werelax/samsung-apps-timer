(ns timers.pages.timer
  )

(defn page []
  [:div.content
   [:div.progress-area {:style {"height" "100%"}}]
   [:div.text
    [:div.text-content [:h2 "Presentación 1"] [:h1.time "00:25"]]]
   [:a.close {:href "#"} [:span.fa.fa-close]]
   [:div.next [:h2 "Next: Presentación 2"]]])
