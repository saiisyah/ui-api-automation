package pages;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement waitUntilVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void type(WebElement element, String text){
        waitUntilVisible(element).clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element){
        return waitUntilVisible(element).getText();
    }
}
