(ns fiona.test.core
  (:use [fiona.core])
  (:use expectations)
  ;; (:use [clojure.test])
)

;; (deftest get-something
;;  (is (= 200 (:status (x)))))

(expect nil? nil)


;; you can do it this way, but yuck
;; (expect (filter (fn [x] (= "Grade 2" x)) (doc-data)) "Grade 2")

(expect (some #{"Grade 2"} (doc-data)) "Grade 2")

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
