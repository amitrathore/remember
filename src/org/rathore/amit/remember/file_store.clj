(ns org.rathore.amit.remember.file-store
  (:use org.rathore.amit.remember.core)
  (:import (org.jets3t.service.model S3Object)))

(defn store-file-in-bucket [bucket-name object-name filename]
  (let [bucket (get-bucket bucket-name)
        data (java.io.File. filename)
        s3-object (S3Object. bucket data)]
    (put-object bucket s3-object)))
