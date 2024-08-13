package saba.janelidze;

import static saba.janelidze.Startup.driver;

public class Cleanup {
    public static void cleanup(){
        driver.quit();
    }
}
