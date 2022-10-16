package DriverConfig;

import org.openqa.selenium.WebDriver;

public class BaseClass {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

}
