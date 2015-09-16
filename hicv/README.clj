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
   [:h1 "Notas generales"]
   [:p
    "Este proyecto esta montado usando HARP. Para lanzar el servidor:"]
   [:pre [:code "harp server\n"]]
   [:p "Y para compilar un build"]
   [:pre [:code "harp compile\n"]]]])
