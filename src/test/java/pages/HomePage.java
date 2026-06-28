package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By whitePhone = By.cssSelector("#tbodyid > div:nth-child(5) > div > div > h4 > a");

    public String getProductName(){
        return driver.findElement(whitePhone).getText();
    }
 }
