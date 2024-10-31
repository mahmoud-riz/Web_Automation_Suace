package runner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.prductPage;
import utils.Product;
import utils.Setup;
import utils.Utility;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage extends Setup {
    CartPage cartPage;
    LoginPage loginPage;

    prductPage pro;
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
    public void checkAllProductsDisplayed() {
        pro = new prductPage(driver);
        pro.validateAllItemsDisplayed();

    }


    @Test(priority = 2)
    public void sortProducts() {
        pro = new prductPage(driver);
        pro.sort_lh();
    }


}
