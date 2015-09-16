(ns timers.pages.edit-timer
  )

(defn page []
  [:div
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
      [:input {:name "min", :type "number"}]]]]])
