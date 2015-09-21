(ns timers.pages.timer
  (:require [timers.state :refer [program timer] :as state]
            [timers.lib.marauder :as marauder]
            [timers.page-utils :as utils]
            [timers.components.elements :as elements]
            [timers.routes :as routes]))

(defn format-time [n]
  (take-last 2 (str "00" n)))

(defn timer-finished []
  [:div
   [:div.progress-area {:style {"height" "0"}}]
   [:div.text
    [:div.text-content
     [:h2 "-FINISHED-"]
     [:h1.time "--:--"]]]
   [:a.close {:href "#"} [:span.fa.fa-close]]])

(defn timer-screen [start now current-timer]
  (let [remaining-ms (- (+ (:offset current-timer)
                           (:duration-ms current-timer))
                        now)
        remaining-s (mod (.floor js/Math (/ remaining-ms 1000)) 60)
        remaining-m (.floor js/Math (/ remaining-ms 60000))
        percent-left (/ remaining-ms (:duration-ms current-timer) 0.01)
        percent-done (- 100 percent-left)]
    [:div
     [:div.progress-area {:style {"height" (str percent-done "%")}}]
     [:div.text
      [:div.text-content
       [:h2 (:title current-timer)]
       [:h1.time (format-time remaining-m) ":" (format-time remaining-s)]]]
     [:a.close {:href "#"} [:span.fa.fa-close]]]))


(defn page [program-id]
  (state/play-start-timestamp (.now js/Date))
  (fn []
    (let [start-timestamp (state/play-start-timestamp)
          current-timestamp @state/clock
          program (marauder/get-by program :id
                                   (js/parseInt program-id 10))
          timers (marauder/find-by timer :program-id program-id)
          timers-with-offset (state/timers-with-offset timers
                                                       start-timestamp
                                                       current-timestamp)
          [current-t next-t & rest] (remove :finished? timers-with-offset)]
      [:div.content
       (if (nil? current-t)
         (timer-finished)
         (timer-screen start-timestamp current-timestamp current-t))
       (if-not (nil? next-t)
         [:div.next [:h2 "Next: " (:title next-t)]]
         [:div.next [:h2 "-FINISH-" ]])])))
