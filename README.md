# Why we use Selenium TestNG for Automation?
Selenium is a popular open-source tool for automating web browser interactions, enabling developers and testers to efficiently test web applications across multiple browsers and platforms.
With its set of APIs, Selenium simplifies interaction with web elements, making it ideal for automating UI tests.

TestNG is a flexible Java testing framework that extends beyond JUnit, supporting unit, integration, and end-to-end testing.
It offers advanced features like parallel execution, data-driven testing, and detailed reporting. Combined with Selenium, TestNG helps build robust, scalable test automation frameworks.

# Technology used:
1- Selenium Webdriver .

2- TestNG Framework.

3- Java.

4- Gradle .
   
5- Intellij .

6- Allure.



Hit the following command into the terminal: gradle clean test.

For generating Allure Report use these commands: allure generate allure-results --clean -o allure-report and allure serve allure-results .


# Why Gradle over Maven ? 
By choosing Gradle, you'll benefit from huge performance improvements compared to Apache Maven 
Gradle implements a wide range of strategies to make your builds faster 
the Gradle Daemon is a long-lived process that keeps build information “hot” in memory.



# Scenerio:
Login to site: https://www.saucedemo.com/v1/

Add a few items to the cart

Insert the Checkout Information

Confirm the Order

Do Logout

# Test case check list based on the Scenerio:

Customer login with Invalid credentials.

Customer Login with valid credentials.

Adding few items to the cart

Inserting Checkout information

Confirm the Order

Logout the user

check on the Item when adding and removing from it
 
check on that all products displayed correctly



# How to run this project
1- Go to the build.gradle file, then scroll to the Test section and run it.

2- Wait until all tests complete. The program will re main active until you finish it by typing "yes" in the console.



# Automation Output >>>> 


https://github.com/user-attachments/assets/d6b98a22-93d2-49f8-af6d-fa7829914f82




