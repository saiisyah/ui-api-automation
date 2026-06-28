package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Alert;


public class LoginPage extends BasePage {

    @FindBy(id = "loginusername")
    private WebElement inputUsername;

    @FindBy(id = "loginpassword")
    private WebElement inputPassword;

    @FindBy(css = "#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
    private WebElement clickButtonLogin;

    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;


    public void inputUsername(String email){
        type(inputUsername, email);
    }

    public void inputPassword(String password){
        type(inputPassword,password);
    }

    public void clickButtonLogin(){

        clickButtonLogin.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login(String email, String password){
        waitUntilVisible(inputUsername);
        inputUsername(email);
        inputPassword(password);
        clickButtonLogin();
    }

    public String getWelcomText(){
        return welcomeUser.getText();
    }

    public boolean isOnLoginPage(){
        return driver.getCurrentUrl().contains("https://www.demoblaze.com/");
    }

    public boolean isDashboardDisplayed() {

        return welcomeUser.isDisplayed();
    }

    public String getAlertMessage() {
        Alert alert = driver.switchTo().alert();

        String message = alert.getText();

        alert.accept();

        return message;

    }


}
