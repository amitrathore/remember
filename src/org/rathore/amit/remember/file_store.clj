(ns org.rathore.amit.remember.file-store
  (:use org.rathore.amit.remember.core)
  (:import (org.jets3t.service.model S3Object))
  (:import (org.jets3t.service.acl AccessControlList)))

(defn store-file-in-bucket [bucket-name  filename]
  (let [bucket (get-bucket bucket-name)
        data (java.io.File. filename)
        s3-object (S3Object. bucket data)
	acl AccessControlList/REST_CANNED_PUBLIC_READ]
    (.setAcl s3-object acl)
    (put-object bucket s3-object)))
