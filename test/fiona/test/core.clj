(ns fiona.test.core
  (:use [fiona.core])
  (:use expectations)
)

(def sample
     "<oai_dc:dc xmlns:oai_dc=\"http://www.openarchives.org/OAI/2.0/oai_dc/\" xmlns:dc=\"http://purl.org/dc/elements/1.1/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.openarchives.org/OAI/2.0/\" xsi:schemaLocation=\"http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd\"><dc:creator>J. Koenig</dc:creator><dc:date>2010-01-13T15:52:10Z</dc:date><dc:date>2010-01-13T15:52:10Z</dc:date><dc:date>2010-01-13T15:52:10Z</dc:date><dc:identifier>CCTL0028</dc:identifier><dc:identifier>CCTL0028</dc:identifier><dc:identifier>http://open.jorum.ac.uk:80/xmlui/handle/123456789/369</dc:identifier><dc:description>A learning object that covers rearranging equations by: * adding to/ subtracting from both sides, * multiply/divide both sides, * replace a term by another equal term, * square/square root both sides, * expand out, * simplify (factorise)</dc:description><dc:format>application/x-shockwave-flash</dc:format><dc:language>en</dc:language><dc:language>en</dc:language><dc:language>en</dc:language><dc:rights>Attribution-Share Alike 2.0 UK: England &amp; Wales</dc:rights><dc:rights>http://creativecommons.org/licenses/by-sa/2.0/uk/</dc:rights><dc:subject>equations</dc:subject><dc:subject>rearrange</dc:subject><dc:subject>term</dc:subject><dc:subject>multiply both sides</dc:subject><dc:subject>maths</dc:subject><dc:subject>medics</dc:subject><dc:subject>Biological Sciences</dc:subject><dc:subject>Medicine and Dentistry</dc:subject><dc:subject>Medicine and Dentistry</dc:subject><dc:subject>Veterinary Sciences</dc:subject><dc:title>Rearrange Equations</dc:title></oai_dc:dc>"
)

(expect nil? nil)

;; you can do it this way, but yuck
;; (expect (filter (fn [x] (= "Grade 2" x)) (doc-data)) "Grade 2")

(expect (some #{"Grade 2"} (doc-data)) "Grade 2")

(expect "resource_data" ((get-doc "CCTL0028") "doc_type"))

;; (println (subjects (parse-str sample)))

(expect "medics" (in (subjects (parse-str sample))))

;; (given [key] (expect key (in (keys (get-os-jmxbean))))
;;       :Arch :FreeSwapSpaceSize)

;; (given [x] (expect x (in (keys (my-parse tmp))))
;;       :content)
;; (given [x] (expect x (in (keys (parse-str tmp)))) :content)


;; expect that you get a block of xml from "resource_data" key location of the document
;; this is a bunch of dc tags, you might as well just dump the whole thing like that rather
;; than doing some new mapping? 

;;(deftest check-this
;;  (let [resp (x)]
;;    (println (:body resp) "**********" )
;;    )
;;  )

;; (deftest check-xx
;;  (println  (xx)))

;;(deftest check-doc-data
;;  (is (in? "Acids and Bases" (doc-data)))
;; (println (doc-data))
;;  )

;;(deftest check-this-too
;;  (let [resp (body3)]
;;    (println (first resp))
;;    (println (second resp))
;;    )
;;  )

;; (deftest test-prod-node
;;   (let [resp (prod)]
;;    (println (resp))
;;    )
;;  )


		 
       
;; (deftest replace-me ;; FIXME: write
;;  (is false "No tests have been written."))
