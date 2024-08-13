package saba.janelidze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Startup {

    static WebDriver driver;
    static WebDriverWait wait;

    public static void startup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saba.Janelidze\\Downloads\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tbcpay.ge");
    }
}
