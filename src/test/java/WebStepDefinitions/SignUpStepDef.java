package WebStepDefinitions;

import config.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.IndexPage;
import pages.SignUpPage;


public class SignUpStepDef {

    WebDriver driver;

    SignUpPage signUpPage;

    private String actualAlertMessage;

    public SignUpStepDef() {

        signUpPage = new SignUpPage();

    }

    @Given("user is already on Dashboard")
    public void userIsAlreadyOnDashboard() {

        DriverFactory.getDriver().get("https://www.demoblaze.com/");
    }

    @And("user click Sign up menu")
    public void userClickSignUpMenu() {
        IndexPage indexPage = new IndexPage();
        indexPage.clickSignUpButton();
    }

    @And("user input valid email")
    public void userInputValidEmail() {
        String email = "user" + System.currentTimeMillis() + "@mail.com";
        signUpPage.inputUsername(email);
    }

    @And("user input sign up password {string}")
    public void userInputSignUpPassword(String password) {
        signUpPage.inputPassword(password);
    }

    @When("user click the signup button")
    public void userClickTheSignupButton() {
        signUpPage.clickButtonSignUp();
    }

    @Then("Sign up successful.")
    public void signupIsSuccessful() {
        String alertMessage = signUpPage.getAlertMessage();
        Assertions.assertEquals("Sign up successful.", alertMessage);
    }

    @And("user input registered email {string}")
    public void userInputRegisteredEmail(String email) {
        signUpPage.inputUsername(email);

    }

    @Then("user cannot SignUp")
    public void userCannotSignUp() {
        actualAlertMessage = signUpPage.getAlertMessage();
        Assertions.assertNotNull(actualAlertMessage);
    }

    @And("user see sign up message {string}")
    public void userSeeSignUpMessage(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, actualAlertMessage);
    }

}
