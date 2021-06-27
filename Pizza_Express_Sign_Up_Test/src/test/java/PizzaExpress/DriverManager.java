package PizzaExpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver driver;

    public static void startDriver() {
        System.setProperty("webdriver.chrome.driver","C:/SeleniumDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void destroyDriver() {
        driver.quit();
    }

}
