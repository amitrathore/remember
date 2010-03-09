(ns org.rathore.amit.remember.string-store
  (:use org.rathore.amit.remember.core)
  (:use clojure.contrib.str-utils)
  (:import (org.jets3t.service.model S3Object)))

(defn store-in-bucket [bucket-name object-name data-strings]
  (let [bucket (get-bucket bucket-name)
        data (str-join "\n" data-strings)
        s3-object (S3Object. object-name data)]
    (put-object bucket s3-object)))