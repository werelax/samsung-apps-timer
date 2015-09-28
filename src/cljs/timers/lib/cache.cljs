(ns timers.lib.cache
  (:require [cljs.reader :as edn]))

;;--------------------
;; cache interface
(defn lstore-set! [k v]
  (-> js/window .-localStorage (.setItem k v)))

(defn lstore-get [k]
  (-> js/window .-localStorage (.getItem k)))

(def cache-key "atom-cache")

(defn get-atom []
  (if-let [stored-atom (lstore-get cache-key)]
    (edn/read-string stored-atom)
    {}))

(defn save-atom! [atom-state]
  (lstore-set! cache-key (prn-str atom-state)))
