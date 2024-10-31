package pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import utils.Product;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class prductPage {


    @FindBy(className = "inventory_list")
    List<WebElement> Items;


    @FindBy (className = "product_sort_container")
    WebElement sortDropdown;


    @FindBy(xpath = "//select[@class='product_sort_container']/option[3]")
    WebElement sortLH;

    @FindBy (className= "inventory_item_price")
    List<WebElement> Price;
    @FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[6]/div[3]/div")
    WebElement HighPrice;

    @FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/div")
    WebElement LowPrice;



    public prductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void validateAllItemsDisplayed() {
        for (WebElement item : Items) {
            Assert.assertTrue(item.isDisplayed(), "Item is not displayed: " + item.getText());
        }
    }




    public void sort_lh() {
        sortDropdown.click();
        sortLH.click();

        Assert.assertEquals(Price.get(0).getText(), "$7.99");
        Assert.assertEquals(Price.get(5).getText(), "$49.99");
    }



}
