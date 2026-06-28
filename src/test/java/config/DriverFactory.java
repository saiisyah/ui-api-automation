package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        ChromeOptions options = new ChromeOptions();

        String headlessProp = System.getProperty("headless", "false");

        if (headlessProp.equals("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver.set(new ChromeDriver(options));

        if (!headlessProp.equals("true")) {
            driver.get().manage().window().maximize();
        }

    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}