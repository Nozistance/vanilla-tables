(ns build
  (:require [clojure.tools.build.api :as b]))

(def ^:private class-dir "target/classes")

(def ^:private jar-file "target/vanilla-tables.jar")

(defn uber [_]
  (let [basis (b/create-basis {:project "deps.edn"})]
    (b/delete {:path "target"})
    (b/compile-clj {:basis basis :src-dirs ["src"]
                    :class-dir class-dir
                    :ns-compile '[vanilla-tables.core]})
    (b/uber {:class-dir class-dir :uber-file jar-file
             :basis basis :main 'vanilla-tables.core})))
