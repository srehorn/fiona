(ns fiona.test.core
  (:use [fiona.core])
  (:use [clojure.test]))

(deftest get-something
  (is (= 200 (:status (x)))))

;;(deftest check-this
;;  (let [resp (x)]
;;    (println (:body resp) "**********" )
;;    )
;;  )

;; (deftest check-xx
;;  (println  (xx)))

(deftest check-doc-data
  (println (doc-data)))

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
