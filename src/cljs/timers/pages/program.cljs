(ns timers.pages.program
  )

(defn page []
  [:div
   [:div.top-bar
    [:div.two-cols
     [:a.btn.btn-primary {:href "#/000-pr-id/new"} " " [:span "ADD"]]
     [:a.btn.btn-secondary {:href "#/000-pr-id/start"} " " [:span "START"]]]]
   [:ul.main-list
    [:li
     " "
     [:a
      {:href "#/000-pr-id/000-timer-id"}
      [:span.title "Presentación 1"]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Presentación 2"]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Presentación 3"]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Presentación 4"]
      [:span.fa.fa-chevron-right]]]]])
