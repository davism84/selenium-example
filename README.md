##Selenium Test Scripts##

**How to run test**

There are two maven profiles (-P)
* **local-dev** - development environment (or local Windows) which points to URL http://localhost/RiskViewer
* **upmc-prod** - considered the production environment (on UPMC machine) which points to URL http://localhost:8080/RiskViewer

Params to test against different browsers (-Dbrowser)
* ie
* chrome
* firefox    *(Not working with current version of FireFox)*


**Usage**

* `mvn -P local-dev -Dbrowser=ie integration-test`

* `mvn -P upmc-prod -Dbrowser=chrome integration-test`

the test will begin automatically

**Running on the UPMC machine**
in DOS shell 

* `cd E:\ohdsi-webapps\DBMI-CCA-pharmacist-risk-viewer\testing\selenium`
* `mvn -P upmc-prod -Dbrowser=ie integration-test`

**this will test IE*

---

**Code organization**

all test inherit from a base class called TestBase.  This class contains only the beforeClass and afterClass methods for initializing the drivers, etc.  See test located in the **src/main/java/edu/pitt/dbmi**

***Test Suite***

You can run multiple tests by adding a new test class to the **testng.xml** file.

    <test name="BasicTests">
        <classes>
        <class name="edu.pitt.dbmi.FS_RAViewer_HP"/>

---
***NOTES:***
a resource directory exist which contain platform-specific executable drivers, i.e., Windows.  In the future, these test may be restructured to download the appropriate drivers, but for now this will work as is.

**local-dev**, since the Selenium test only run on Windows at the moment, you will need a secure shell to the NoMachine development instance , i.e., Putty with port forwarding established for ports 80 and 8081.


