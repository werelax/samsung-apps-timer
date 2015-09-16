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
   [:div.top-bar
    [:div.two-cols
     [:a.btn.btn-terciary {:href "#"} " " [:span.fa.fa-close]]
     [:a.btn.btn-secondary {:href "#"} " " [:span.fa.fa-check]]]]
   [:div.content
    [:form.fill-form
     {:action "#"}
     [:div.form-item
      [:label {:for "title"} "Nombre"]
      [:input {:name "title", :type "text"}]]
     [:div.form-item
      [:label {:for "min"} "Minutos"]
      [:input {:name "min", :type "number"}]]]]]])
