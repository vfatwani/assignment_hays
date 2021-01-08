Automated test case using Page object model design technique.
Spec folder- IHSMarkitAutomationTask.spec (contains 9 scenarios/the test cases positive and negative cases)
src-test-java-web_automation-common-Base (contains all the methods like getText(),clickElement(),sendKeys()..etc and the wait methods.
src-test-java-web_automation-Pages-IHSLoginPage (contains all the webelements of the webpage and also contains Page methods which perform operations on those WebElements.)
src-test-java-web_automation-util.driver-Driver (conatins @BeforeSuite and @AfterSuite hooks)
src-test-java-web_automation-util.driver-DriverFactory (type of browser we want to select bydefault it's chrome)
src-test-java-web_automation_stepImplementation-IHSLoginStepImplementation (contains all the test steps and assert)
project Assignment-env-default.properties - is used for configuration( conatins the web url and browswer value).
Steps to run from IntelliJ IDE-
Naviagtion to spec- folder -  select the spec file - click on Run button
Steps to run from terminal-
Open Terminal- Navigate to Assignment path- run comman "gauge run specs"
Once all the test cases are executed we can see the status at end -
Specifications:	1 executed	1 passed	0 failed	0 skipped
Scenarios:	9 executed	9 passed	0 failed	0 skipped
