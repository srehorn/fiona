(ns fiona.core)

(require '[clj-http.client :as client])
(require '[cheshire.core :as json])

;; would be (json/parse-string (blah blah))
(defn x []
  (client/get "http://lrtest02.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json}))

(defn doc-data []
  (let [raw ((client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" 
			 {:insecure? true} {:accept :json}) :body)]
    ;; the parsed body is a map with documents and a resumption token
    (def docs (first ((json/parse-string raw) "documents")))
    ;; v is a vector, maybe with many
    ;; (def v (first (pb "documents")))
    ;; keys shows "document" and "doc_ID"
    ;; (keys docs)
    ;; keys gets the keys for the doc
    (keys (first (docs "document")))
    ((first (docs "document")) "keys")
    )
  )




(defn xx []
  (json/parse-string ((client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" {:insecure? true}) :body)))

;; "1508763b13004676ac83a23bed47c39c"
;; also fails on json parse? Is it just the sandbox server? 
(defn get-doc [docid]
  (json/parse-string ( (client/get (format "http://sandbox.learningregistry.org/obtain?request_ID=%s&by_doc_ID=true" docid) {:accept :json :insecure? true}) :body) ))

;; this doc id appears to fail due to the json parser and character encoding
;;(defn body []
;;  (json/parse-string ((client/get "http://sandbox.learningregistry.org/obtain?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json :insecure? true}) :body) ))

;; this doc id appears to fail due to the json parser and character encoding
;;(defn body2 []
;;  (first (json/parse-string (:body (client/get "http://sandbox.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json} )))))

;;(defn body3 []
;;  (second (second (json/parse-string (:body (client/get "http://sandbox.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json} ))))))

;; fails with javax.net peer not authenticated
;; this is an https problem
;;
;; (defn prod []
;;  (client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" {:insecure true}))

;; where z is result of running xx
;; (first (first (second (first (first (second (first z)))))))     
;; ["update_timestamp" "2011-10-28T17:43:35.801844Z"]







