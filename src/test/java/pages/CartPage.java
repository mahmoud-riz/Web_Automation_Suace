package pages;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Utility;

import java.io.IOException;
import java.util.List;

public class CartPage {

    @FindBy(className = "btn_inventory")
    List<WebElement> addToCart;
    @FindBy(className = "svg-inline--fa")
    WebElement cartIcon;
    @FindBy(className = "checkout_button")
    WebElement checkoutButton;
    @FindBy(className = "form_input")
    List<WebElement> formInput;
    @FindBy(className = "btn_primary")
    WebElement btnContinue;
    @FindBy(className = "btn_action")
    WebElement btnFinish;


    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    WebElement item1;

    @FindBy (xpath = "//*[@id=\"item_1_title_link\"]/div")
    WebElement item2;

    @FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button")
    WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"menu_button_container\"]/div/div[3]/div/button")
    WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    WebElement menuPage;

    WebDriver driver;

    public CartPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    public void addItem() throws InterruptedException {
        addToCart.get(0).click();
        addToCart.get(1).click();
        cartIcon.click();

    }

    public void checkout() throws IOException, ParseException, InterruptedException {
        Faker faker= new Faker();
        String fName=faker.name().firstName();
        String lName=faker.name().lastName();
        String postalCode=faker.address().zipCode();


        checkoutButton.click();
        formInput.get(0).sendKeys(fName);
        formInput.get(1).sendKeys(lName);
        formInput.get(2).sendKeys(postalCode);
        Thread.sleep(500);
        Utility.addJsonArray(fName,lName,postalCode);
        Thread.sleep(300);
        btnContinue.click();
        btnFinish.click();
    }


    public  void IsUpdated_AfterAdd()
    {

        String ItemName = item1.getText();
        Assert.assertEquals("Sauce Labs Backpack",ItemName);
    }



    public  void IsUpdated_AfterRemove()
    {
        String ItemName = item1.getText();
        Assert.assertNotEquals("Sauce Labs Backpack",ItemName);
    }

    public void backToMenu()
    {
       menuButton.click();
       menuPage.click();

    }
    public void  RemoveItem ()
    {
        removeButton.click();
    }




    }

