(ns org.rathore.amit.remember.authentication
  (:import (org.jets3t.service.security AWSCredentials)))

(defn s3-creds [access-key secret-key]
  (AWSCredentials. access-key secret-key))

