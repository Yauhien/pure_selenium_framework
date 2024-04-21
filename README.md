# Pure selenium UI Framework

##Framework stack

* Java 11 or higher
* Selenium webdriver
* Maven (Build automation tool)
* Cucumber (BDD test tool)
* JUnit (Unit testing framework and runner)
* Spring (Application and IoC framework)
* Log4j (Loggin tool)

## Prerequisites
You need to have following installed:

* [Java latest](https://www.openlogic.com/openjdk-downloads)
* [Chrome Browser latest](https://www.google.com/chrome/)
* [Firefox](https://www.mozilla.org/en-US/firefox/new/)
* [Apache Maven](https://maven.apache.org/download.cgi)

## Test configurations
Framework properties can be found in application.properties.

Chrome webdriver is selected by default. Additionally firefox browser support was added.
To run Firefox webdriver do the followting change - browser.type:firefox 

## Run

From terminal
- to run all the tests for the regression

mvn clean test -Dcucumber.options="--tags @all"

- to run a separate test

mvn clean test -Dcucumber.options="--tags @wip"

In order to run the tests in headless mode - TestConfig option "//options.addArguments("--headless");" should be uncommened
 
 ## Results
 
 Test results report can be found here "target/cucumber-pretty/index.html" 

