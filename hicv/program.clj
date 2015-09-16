("<!DOCTYPE html>"
 [:html
  {:lang "en"}
  [:head
   [:meta {:charset "utf-8"}]
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
   [:div.top-bar
    [:div.one-col [:a.btn.btn-primary {:href "#"} [:span.fa.fa-plus]]]]
   [:ul.main-list
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Programa 1"]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Programa 2 con título más largo que dobla "]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Programa 3"]
      [:span.fa.fa-chevron-right]]]
    [:li
     " "
     [:a
      {:href "#"}
      [:span.title "Programa 4"]
      [:span.fa.fa-chevron-right]]]]]])
