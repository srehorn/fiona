(ns fiona.test.core
  (:use [fiona.core])
  (:use expectations)
)

(expect nil? nil)

;; you can do it this way, but yuck
;; (expect (filter (fn [x] (= "Grade 2" x)) (doc-data)) "Grade 2")

(expect (some #{"Grade 2"} (doc-data)) "Grade 2")

(expect "resource_data" ((get-doc "CCTL0028") "doc_type"))

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
