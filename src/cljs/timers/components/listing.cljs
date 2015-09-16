(ns timers.components.listing
  )

(defn listing-item [href title key]
  [:li {:key key}
   [:a {:href href}
    [:span.title title]
    [:span.fa.fa-chevron-right]]])

(defn listing [get-seq title link]
  [:ul.main-list
   (doall (keep-indexed #(listing-item (link %2) (title %2) %1)
                        (get-seq)))])
