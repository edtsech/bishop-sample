;;
;; A sample Bishop application.
;;
(ns com.tnrglobal.bishopsample.core
  (:gen-class)
  (:use [ring.adapter.jetty]
        [ring.middleware.params]
        [clojure.tools.logging])
  (:require [com.tnrglobal.bishop.core :as bishop]
            [com.tnrglobal.bishopsample.service :as service]))

(def handler
  (-> (bishop/handler #'service/routes) ; we want reloading to work for routes
      wrap-params))

(defn main
  "Exposes the main function for bootstrapping the application."
  [& args]
  (info "Hello from Bishop Sample!")
  (run-jetty handler {:port 3000}))

(defn -main
  [& args]
  (main args))