(defproject fiona "0.0.1-SNAPSHOT"
  :description "This is a collection of utilities to pull and parse LR data to turtle"
  :dependencies [[org.clojure/clojure "1.3.0"]
		 [clj-http "0.2.7"]
		 [data.zip "0.0.1-SNAPSHOT"]
		 [data.xml "0.0.3-SNAPSHOT"]
		 [cheshire "2.2.0"]
		 ]
  :dev-dependencies [[lein-expectations "0.0.1"]
		     [expectations "1.3.3"]
		     [lein-autoexpect "0.0.2"]
		     ]
  ;; try clj-http 0.3.2
  )
