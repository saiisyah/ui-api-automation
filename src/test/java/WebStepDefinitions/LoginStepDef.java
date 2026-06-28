package WebStepDefinitions;

import config.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.IndexPage;
import pages.LoginPage;


public class LoginStepDef {

    WebDriver driver;

    LoginPage loginPage;

    private String actualAlertMessage;

    public LoginStepDef() {

        loginPage = new LoginPage();
    }

    @Given("user is already on login page")
    public void userIsAlreadyOnLoginPage() {
        IndexPage indexPage = new IndexPage();
        indexPage.clickLoginButton();
    }

    @And("user input login email {string}")
    public void userInputLoginEmail(String email) {

        loginPage.inputUsername(email);
    }

    @And("user input valid password {string}")
    public void userInputValidPassword(String password) {

        loginPage.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {

        loginPage.clickButtonLogin();
    }

    @Then("login is successful")
    public void loginIsSuccessful() throws InterruptedException {

        System.out.println(loginPage.getWelcomText());

        Assertions.assertTrue(loginPage.isDashboardDisplayed());
    }

    @And("user input registered username {string}")
    public void userInputRegisteredUsername(String email) {
        loginPage.inputUsername(email);
    }

    @And("user input invalid password {string}")
    public void userInputInvalidPassword(String password) {

        loginPage.inputPassword(password);
    }

    @Then("login is failed")
    public void loginIsFailed() {

        actualAlertMessage = loginPage.getAlertMessage();

        Assertions.assertNotNull(actualAlertMessage);
    }

    @And("user see message {string}")
    public void userSeeMessage(String expectedMessage) {

        Assertions.assertEquals(expectedMessage, actualAlertMessage);
    }
}
