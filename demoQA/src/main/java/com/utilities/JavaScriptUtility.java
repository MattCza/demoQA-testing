package com.utilities;

import com.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    public static void scrollToElementJavaScript(By locator) {
        WebElement webElement = webDriver.findElement(locator);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) webDriver).executeScript(script, webElement);
    }

}
