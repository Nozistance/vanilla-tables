(ns vanilla-tables.data
  "The mark and the files of a set of tables."
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io])
  (:import (java.io File)))

(set! *warn-on-reflection* true)

(def game "26.2")

(def layout 11)

(def tables
  ["packets" "registries" "blocks" "datapack" "tags" "items"
   "light" "fire" "drops" "entity-drops" "recipes" "sounds"
   "features" "potions" "effects" "enchantments"
   "dimension-types" "biomes" "shapes"
   "outlines" "sturdy" "flags"])

(defn stamp
  "Returns the mark a set of tables carries."
  []
  {:game game :layout layout})

(defn missing
  "Returns the files of a full set that dir does not hold."
  [dir]
  (into []
        (comp (map #(str % ".edn"))
              (remove #(File/.isFile (io/file dir %))))
        (conj tables "stamp")))

(defn stamp-of
  "Returns the mark of the tables in dir, or nil when it has none."
  [dir]
  (try (edn/read-string (slurp (io/file dir "stamp.edn")))
       (catch Exception _ nil)))
