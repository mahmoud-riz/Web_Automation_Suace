package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(className = "form_input")
    List<WebElement> inputField;
    @FindBy(className = "btn_action")
    List<WebElement> button;

    @FindBy(tagName = "button")
    List<WebElement> BurgerMenu;

    @FindBy(className = "bm-item")
    List<WebElement> logout;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void doLogin(String userName, String Password){
        inputField.get(0).sendKeys(userName);
        inputField.get(1).sendKeys(Password);
        button.get(0).click();
    }

    public void clearField(){
        inputField.get(0).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        inputField.get(1).sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);

    }

    public void doLogout(){
        BurgerMenu.get(1).click();
        logout.get(2).click();
    }
}

