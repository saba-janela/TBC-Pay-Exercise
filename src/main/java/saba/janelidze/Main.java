package saba.janelidze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void main(String[] args) throws Exception {
        Startup.startup();

        Testing.testing();

        Cleanup.cleanup();
    }
}
