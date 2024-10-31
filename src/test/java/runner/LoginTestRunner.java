package runner;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Setup;
import utils.Utility;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    @Test(priority = 1, description = "Login with Invalid credentials")

    public void doInvalidLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONObject userObject = Utility.loadJSONFile("./src/test/resources/User.json");
        String userName= (String) userObject.get("userName");
        loginPage.doLogin(userName,"asdF1234");

        // Assertion
        String actualResult= driver.findElement(By.tagName("h3")).getText();
        String expectedResult="Epic sadface: Username and password do not match any user in this service";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test(priority = 2, description = "Login with Valid credentials")
    public void doLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        String userName, password;
        JSONObject userObject = Utility.loadJSONFile("./src/test/resources/User.json");
        if (System.getProperty("username") != null && System.getProperty("password") != null) {
            userName = System.getProperty("username");
            password = System.getProperty("password");
        } else {
            userName = (String) userObject.get("userName");
            password = (String) userObject.get("password");
        }

        loginPage.clearField();
        loginPage.doLogin(userName, password);

        // Assertion
        try {
            String actualResult = driver.findElement(By.className("product_label")).getText();
            String expectedResult = "Products";
            Assert.assertEquals(actualResult, expectedResult);
        } catch (Exception e) {
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Source: " + driver.getPageSource());
            throw e;
        }
    }
    @Test(priority = 3)
    public void doLogout(){
        loginPage= new LoginPage(driver);
        loginPage.doLogout();

        // Assertion
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html");
    }

    }



