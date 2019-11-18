# WAES Heroes UI Framework

##Framework stack

* Java 1.8
* Selenium webdriver
* Maven (Build automation tool)
* Cucumber (BDD test tool)
* JUnit (Unit testing framework and runner)
* Spring (Application and IoC framework)
* Log4j (Loggin tool)

## Prerequisites
You need to have following installed:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Chrome Browser version 78](https://www.google.ru/intl/ru/chrome/?brand=CHBD&gclid=Cj0KCQiAk7TuBRDQARIsAMRrfUap-KmwPytbf2WHhHReKbNfbb2MfZalybYnzj-ZkyWLHiFj6tGvVtAaAuQEEALw_wcB&gclsrc=aw.ds)_
* [Firefox](https://www.mozilla.org/ru/firefox/new/)
* [Selenium Webdriver version 78](https://chromedriver.storage.googleapis.com/index.html?path=78.0.3904.70/)
* [Apache Maven](https://maven.apache.org/)

#Test configurations
Framework properties can be found in application.properties.

Chrome webdriver is selected by default. Additionally firefox browser support was added.
To run Firefox webdriver do the followting change - browser.type:firefox 

## Run

From terminal
- to run all the tests for the regression

mvn clean test -Dcucumber.options="--tags @all"

- to run a separate test

mvn clean test -Dcucumber.options="--tags @wip"

!Note to run the tests in headleass mode,
 To run the tests in headless mode - TestConfig option "//options.addArguments("--headless");" should be uncommened
 
 ##Results
 
 Test results report can be found here "target/cucumber-pretty/index.html" 

