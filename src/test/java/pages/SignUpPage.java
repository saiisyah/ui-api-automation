package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {

    @FindBy(id = "signin2")
    private WebElement signUpMenu;

    @FindBy(id = "sign-username")
    private WebElement inputUsername;

    @FindBy(id = "sign-password")
    private WebElement inputPassword;

    @FindBy(css = "#signInModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement clickButtonSignUp;

    public void clickSignUpMenu() {
        signUpMenu.click();
    }

    public void inputUsername(String email) {
        type(inputUsername, email);
    }

    public void inputPassword(String password) {
        type(inputPassword, password);
    }

    public void clickButtonSignUp() {
        clickButtonSignUp.click();
    }

    public void signup(String email, String password) {
        waitUntilVisible(inputUsername);
        inputUsername(email);
        inputPassword(password);
        clickButtonSignUp();
    }

    public String getAlertMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String message = alert.getText();

        alert.accept();

        return message;
    }
    
}
