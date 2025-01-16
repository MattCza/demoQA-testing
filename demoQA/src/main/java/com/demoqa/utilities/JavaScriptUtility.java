package com.demoqa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility extends Utility {

    public static void scrollToElementJavaScript(By locator) {
        WebElement webElement = webDriver.findElement(locator);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) webDriver).executeScript(script, webElement);
    }

    public static void clickJavaScript(By locator) {
        WebElement element = webDriver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("arguments[0].click();", element);
    }

}
