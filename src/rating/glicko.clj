(ns rating.glicko
  (:require [clojure.spec.alpha :as spec]))

(spec/def ::id keyword?)
(spec/def ::rating integer?)
(spec/def ::rd number?)
;; Players should be a list of maps
;; games should be a list of ??
(spec/def ::players (spec/keys :req-un [::id ::rating ::rd]))
(spec/def ::games (spec/coll-of map?))
(spec/def ::rate-input (spec/keys :req-un [::players ::games]))

(defn rate
  "Rate games that transpired during the same rating period. Input is expected to be a hashmap which conforms to `::glicko.rate-input` spec.
  Returns a hashmap which conforms to `::glicko.players` and represents the new values for all players which were input."
  [{:keys [games players] :as input}]
  (when-not (= ::spec/invalid
               (spec/conform ::rate-input input))
    players))
