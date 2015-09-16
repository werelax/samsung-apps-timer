("<!DOCTYPE html>"
 [:html
  {:lang "en"}
  [:head
   [:meta
    {:content "width=device-width, initial-scale=1.0",
     :name "viewport"}]
   [:meta {:content "yes", :name "apple-mobile-web-app-capable"}]
   [:title "Timers"]
   [:link {:href "assets/css/main.css", :rel "stylesheet"}]
   [:link {:href "assets/css/font-awesome.min.css", :rel "stylesheet"}]
   [:link
    {:type "text/css",
     :rel "stylesheet",
     :href "http://fonts.googleapis.com/css?family=Lato:300,400,700"}]]
  [:body
   [:div.content
    [:div.progress-area {:style "height: 100%"}]
    [:div.text
     [:div.text-content [:h2 "Presentación 1"] [:h1.time "00:25"]]]
    [:a.close {:href "#"} [:span.fa.fa-close]]
    [:div.next [:h2 "Next: Presentación 2"]]]]])
