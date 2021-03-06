(defproject cawala/slacker "0.10.0"
  :description "Transparent, non-invasive RPC by clojure and for clojure.
                This fork adds TLS support, server-shutdown."
  :url "http://github.com/paulrd/slacker"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cawala/link "0.5.0"]
                 [info.sunng/carbonite "0.2.3"]
                 [cheshire "4.0.3"]
                 [slingshot "0.10.3"]
                 [org.clojure/java.jmx "0.2.0"]
                 [org.clojure/tools.logging "0.2.4"]]
  :profiles {:dev {:resource-paths ["examples"]
                   :dependencies [[codox "0.6.1"] [midje "1.6-SNAPSHOT"]]}}
  :plugins [[lein-exec "0.3.0"]]
  :aliases {"run-example-server" ["run" "-m" "slacker.example.server"]
            "run-example-client" ["run" "-m" "slacker.example.client"]})
