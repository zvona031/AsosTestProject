# AsosTestProject Overview
This repository contains Selenium functionality tests for the https://www.asos.com web page. You can see the details about everx test at the bottom of this file.

## Required Tools
Tools required to run the tests on your machine:
1. [Google Chrome](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQiA7OnxBRCNARIsAIW53B9v6xVcdsb5nB1wYX6aZ7wYRUfQBWy_aEOnxCn6THwr95KeXnBP_qkaAo6JEALw_wcB&gclsrc=aw.ds)
2. [Java Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) 
3. [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/#section=mac)
4. [Chrome Driver](https://chromedriver.chromium.org/downloads)
5. [Maven](https://maven.apache.org/download.cgi)
6. [Git](https://git-scm.com/downloads)

## Environment Setup

### 1. Google Chrome installation
   1. Download Google Chrome from the [link](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQiA7OnxBRCNARIsAIW53B9v6xVcdsb5nB1wYX6aZ7wYRUfQBWy_aEOnxCn6THwr95KeXnBP_qkaAo6JEALw_wcB&gclsrc=aw.ds)
   2. Run the downloaded file and complete the simple installation process.
   3. Check the [version](https://help.zenplanner.com/hc/en-us/articles/204253654-How-to-Find-Your-Internet-Browser-Version-Number-Google-Chrome) of the installed Google Chrome. (You will need it at the Chrome Driver installation)

### 2. IntelliJ Community Edition installation
   1. Download the IntelliJ installation .dmg file from the [link](https://www.jetbrains.com/idea/download/#section=mac).
   2. Run the downloaded .dmg file and follow the installation instructions.
   3. After installation, run IntelliJ and enable auto import in the popup message.
 
 ### 3. Java Development Kit installation
   1. Download the JDK .dmg file from the [link](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
   2. [Click here](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) and follow the tutorial to install the downloaded .dmg file.
 
### 4. Chrome Driver installation
   1. Dowload the Chrome Driver from the [link](https://chromedriver.chromium.org/downloads)( Version of the Google Chrome you have installed and the Chrome Driver you will download must be the same!!!!)
   2. Open the terminal in the folder you saved Chrome Driver. 
   3. Type `mv chromedriver /usr/local/bin` in the terminal to move Chrome Driver to a new location.
  
### 5. Maven installation
   1. Download .tar.gz file from the [link](https://maven.apache.org/download.cgi)
   2. Open the terminal in the folder you saved Maven.
   3. Remove the .tar.gz archive with the following command `rm apache-maven*bin.tar.gz`
   4. Type `mv apache-maven* /usr/local/bin/apache-maven` to move Maven to new location.
  
### 6. Repository download
   1. Download and install [Git](https://git-scm.com/downloads)
   2. Open terminal and enter the following command 
      `git clone https://github.com/zvona031/AsosTestProject.git`
   
### Project configuration
   * Open the project in IntelliJ.
   * Enable auto-import when the popup comes.
   * Go to File -> Project Structure -> Project and set the Project SDK there. ( Mine is 13)
   * Set the Project Language Level same as the Project SDK version. 

### Running tests
   * To run all the tests at once, right click on the testng.xml file and click Run. 
   * To generate test reports, open terminal in the project folder, and type `mvn test`
   * You can find the reports in your project folder under /targer/surefire-reports in index.html file.
   
## Tests description

### GoToCheckoutTest
This class contains 2 tests. Both of them go to men fashion at Asos.com. Then they submit search each on different procuct. After that, they enter the wanted product by clicking on it. Next is size selection (size of the hoodie/shoes). When the wanted size is selected, product is added to the bag. Then the bag is opened and the checkout button is clicked. This is the end of the test because if we want to proceed, we must enter information about the real account.
### PagePreferencesTest
This test opens the preferences of the page. First we click on the country flag image in the top right. Preferences menu appears. Next we change the country to Zimbabwe, and the currency to GBP. Then  we click update preferences. We can see that the flag image is changed to Zimbabwe flag.
### RegisterTest
This test contains 2 tests. One is registering with mail, and other is registering with facebook. Facebook registering test is a bit more complicated than mail, because the popup window for entering facebook username and password opens. Registration stops on the last step because on the facebook registration, we must enter real account data, and on the mail registration, we must solve the captcha test before actually registrating new account.
### SavingProductsTest
This test is a combination of 3 tests. First one finds the desired shoes on the page. Then it saves them in the saved items list. Other one checks if the shoes are added correctly to the saved items list. The last one removes the shoes from the saved items list.
   
