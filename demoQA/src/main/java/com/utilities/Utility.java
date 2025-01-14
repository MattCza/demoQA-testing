package com.utilities;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver webDriver;

    public static void setUtilityDriver() {
        webDriver = BasePage.driver;
    }

    public static String getText(By locator) {
        return webDriver.findElement(locator).getText();
    }


}
