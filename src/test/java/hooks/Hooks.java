package hooks;

import config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before("@web")
    public void setup() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Before scenario start");
        DriverFactory.initDriver();
        DriverFactory.getDriver().get("https://www.demoblaze.com/");
    }

    @Before("@api")
    public void setupAPI(){
        System.out.println("Init API test setup");
    }

    @After("@web")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "Failed Screenshot");
        }
        System.out.println("After scenario finished");
        DriverFactory.quitDriver();
    }

    @After("@api")
    public void tearDownApi() {
        System.out.println("API test finished");
    }
}
