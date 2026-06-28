package pages;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{

    @FindBy(id = "signin2")
    public WebElement buttonSignin;

    @FindBy(id = "login2")
    public WebElement buttonLogin;

    public IndexPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickSignUpButton() {

        buttonSignin.click();
    }

    public void clickLoginButton() {

        buttonLogin.click();
    }

}
