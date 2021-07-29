# ThinkbridgeAssesment
Thinkbridge Compatibility Assessment Test

Neccessary Tools : Eclipse, Maven, TestNG

File Details :

In src/main/java :
  1. config.properties - Contains URL and Browser
  2. TestBase Class - Contains initialization code and launching browser and URL
  3. SignUpPage Class - Contains xpaths and methods for sign up page
  4. VerifyEmail Class - Contains xpaths and methods for verification of received email
  5. Keywords Class - Contains methods for entering text, clicking on element and verifying text
  6. TestUtils Class - Contains methods for waits
  7. TestListners Class - Contains Listeners for onTestStart, onTestSuccess and onTestFailure
 
In src/test/java :
  1. TestLaunching Class - It is a Test Class

Executable file :
  1. ExecutableXML.xml - Used to initiate the execution


Testdata Changes :
Test data can be changed in ExecutableXML.xml file (Name, Organization and EmailID is passed as testdata)


Browser Changes :
If you want to change the browser, 
1. Go to config.properties
2. Change the browser name to firefox or IE


Execution :
1. Open ExecutableXML.xml
2. Rightclick >> Run As >> TestNG Suite

