(ns timers.state
  (:require [reagent.core :as reagent :refer [atom]]
            [reagent.session :as session]
            [timers.lib.marauder :as marauder]))

(defonce state (atom {:programs []}))
(defonce current (atom {}))

;; -------------------------
;; Utils

(defonce uid
  (let [i (atom 0)]
    #(swap! i inc)))

(defn get-id [] {:id (uid)})

;; -------------------------
;; Programs

(def program
  (marauder/resource {:path [:programs]
                      :atom state
                      :current-atom current
                      :generator #(hash-map :title "")}))

;; NOTE: MOST of this shit here is QUITE GENERIC,
;; like some kind of in-atom resource. Could be very well
;; factored into some kind of mutant liberator?

(defn get-programs []
  (get @state :programs []))

(defn create-program []
  )

(defn find-program [id]
  (first (filter #(= (:id %) id)
                 (get-programs))))

(defn program-set-current [id]
  (let [program (find-program id)]
    (swap! current assoc :program program)))

(defn program-bake-new []
  (swap! current assoc :program (create-program)))

(defn program-save-current []
  (let [current (get @current :program)
        current-id (:id current)
        program (find-program current-id)
        update-func (if (= current-id :new)
                      #(conj % (merge current (get-id)))
                      #(replace {program current} %))]
    (swap! state update-in [:programs] update-func)
    (println current @state)))

(defn program-cleanup-current []
  (swap! current dissoc :program))

(defn program-get-current-name []
  (get-in @current [:program :title]))

(defn program-set-current-name! [e]
  (let [value (.. e -target -value)]
    (swap! current assoc-in [:program :title] value)))
