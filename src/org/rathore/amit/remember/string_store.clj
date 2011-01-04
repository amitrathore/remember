(ns org.rathore.amit.remember.string-store
  (:use org.rathore.amit.remember.core)
  (:use clojure.contrib.str-utils)
  (:use clojure.contrib.duck-streams)
  (:import (org.jets3t.service.model S3Object)))

(defn store-strings-in-bucket [bucket-name object-name data-strings]
  (let [bucket (get-bucket bucket-name)
        data (str-join "\n" data-strings)
        s3-object (S3Object. object-name data)]
    (put-object bucket s3-object)))

(defn store-string-in-bucket [bucket-name object-name data-string]
  (store-strings-in-bucket bucket-name object-name [data-string]))

(defn get-strings-from-bucket [bucket-name object-name]
  (let [bucket (get-bucket bucket-name)
        obj (get-object bucket object-name)]
    (re-split #"\n" (slurp* (.getDataInputStream obj)))))
