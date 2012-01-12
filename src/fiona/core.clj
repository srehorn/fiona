(ns fiona.core)

(require '[clj-http.client :as client])
(require '[cheshire.core :as json])

;; would be (json/parse-string (blah blah))
(defn x []
  (client/get "http://lrtest02.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json}))

(defn xx []
  (json/parse-string (:body (client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" {:insecure? true} ))))


(defn body []
  (json/parse-string (:body (client/get "http://lrtest02.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json} ))))

(defn body2 []
  (first (json/parse-string (:body (client/get "http://lrtest02.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json} )))))

(defn body3 []
  (second (second (json/parse-string (:body (client/get "http://lrtest02.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json} ))))))

;; fails with javax.net peer not authenticated
;; this is an https problem
;;
;; (defn prod []
;;  (client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" {:insecure true}))

;; where z is result of running xx
;; (first (first (second (first (first (second (first z)))))))     
;; ["update_timestamp" "2011-10-28T17:43:35.801844Z"]







