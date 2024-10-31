package runner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import utils.Setup;
import utils.Utility;

import java.io.IOException;
import java.time.Duration;

public class CartTestRunner extends Setup {
    CartPage cartPage;
    LoginPage loginPage;
    @BeforeTest
    public void doLogin() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        JSONObject userObject = Utility.loadJSONFile("./src/test/resources/User.json");
        String userName= (String) userObject.get("userName");
        String password= (String) userObject.get("password");
        loginPage.clearField();
        loginPage.doLogin(userName,password);
    }
    @Test(priority = 1)
    public void addTOCart() throws InterruptedException, IOException, ParseException {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        //Thread.sleep(500);
        cartPage=new CartPage(driver);
        // Add a product to the shopping cart and verify that the cart is updated.
        cartPage.addItem();
        cartPage.IsUpdated_AfterAdd();
        // Remove a product from the shopping cart and verify that the cart is updated.
        cartPage.RemoveItem();

    }

   @Test(priority = 2)
    public void Checkout() throws InterruptedException, IOException, ParseException {
       cartPage.checkout();
       String actualText=driver.findElement(By.className("complete-header")).getText();
       String expectedResult="THANK YOU FOR YOUR ORDER";
       Assert.assertTrue(actualText.contains(expectedResult));
       cartPage.backToMenu();

    }









}
