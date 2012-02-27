
(ns fiona.core
  (require '[clj-http.client :as client])
  (require '[cheshire.core :as json])
  (use 'clojure.data.xml)
)

;;
;; there was some kind of strange encoding in here that wasn't visible in emacs (maybe introduced by fancy copy-paste in mac?)
;; go figure
;;
(defn geth [docid]
  (let [url (format "http://sandbox.learningregistry.org/obtain?request_id=%s&by_doc_id=true" docid)]
    (client/get url {:accept :json} {:insecure? true} ) )
  )


(defn get-doc [docid]
  (let [doc (json/parse-string ((geth docid) :body))]
    (first ((first (doc "documents")) "document"))
    )
  )

(defn get-resource [d]
  (d "resource_data"))

(def tmp 
     "<oai_dc:dc xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.openarchives.org/OAI/2.0/\" xsi:schemaLocation=\"http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd\"><dc:creator>J. Koenig</dc:creator><dc:date>2010-01-13T15:52:10Z</dc:date><dc:date>2010-01-13T15:52:10Z</dc:date><dc:date>2010-01-13T15:52:10Z</dc:date><dc:identifier>CCTL0028</dc:identifier><dc:identifier>CCTL0028</dc:identifier><dc:identifier>http://open.jorum.ac.uk:80/xmlui/handle/123456789/369</dc:identifier><dc:description>A learning object that covers rearranging equations by: * adding to/ subtracting from both sides, * multiply/divide both sides, * replace a term by another equal term, * square/square root both sides, * expand out, * simplify (factorise)</dc:description><dc:format>application/x-shockwave-flash</dc:format><dc:language>en</dc:language><dc:language>en</dc:language><dc:language>en</dc:language><dc:rights>Attribution-Share Alike 2.0 UK: England &amp; Wales</dc:rights><dc:rights>http://creativecommons.org/licenses/by-sa/2.0/uk/</dc:rights><dc:subject>equations</dc:subject><dc:subject>rearrange</dc:subject><dc:subject>term</dc:subject><dc:subject>multiply both sides</dc:subject><dc:subject>maths</dc:subject><dc:subject>medics</dc:subject><dc:subject>Biological Sciences</dc:subject><dc:subject>Medicine and Dentistry</dc:subject><dc:subject>Medicine and Dentistry</dc:subject><dc:subject>Veterinary Sciences</dc:subject><dc:title>Rearrange Equations</dc:title></oai_dc:dc>"
)

(defn get-struct-map [xml]
  (let [stream (java.io.ByteArrayInputStream. (.getBytes (.trim xml)))]
    (xml/parse stream)))

;; see this article to use a zipper: http://techbehindtech.com/2010/06/25/parsing-xml-in-clojure/

;; http://sandbox.learningregistry.org/obtain?request_id=CCTL0028&by_doc_id=true
;; clojure.java.io/reader 
;; "1508763b13004676ac83a23bed47c39c"
;; also fails on json parse? Is it just the sandbox server? 

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







;; would be (json/parse-string (blah blah))
(defn x []
  (client/get "http://sandbox.learningregistry.org/harvest/getrecord?request_ID=20bf0aa66ae54f92b67d06e6fa944625&by_doc_ID=true" {:accept :json}))

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


;; http://sandbox.learningregistry.org/obtain?ids_only=true
;; includes resumption token 
;; (defn xx []
;;   (json/parse-string ((client/get "https://node01.public.learningregistry.net/obtain?by_doc_ID=true&request_id=46e312f386e149de99d6c4cf32a4f268" {:insecure? true}) :body)))

