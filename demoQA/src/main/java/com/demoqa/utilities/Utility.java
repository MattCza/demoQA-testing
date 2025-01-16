package com.demoqa.utilities;

import com.demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Utility {

    public static WebDriver webDriver;

    public static void setUtilityDriver() {
        webDriver = BasePage.driver;
    }

    public static String getText(By locator) {
        return webDriver.findElement(locator).getText();
    }

    public static void explicitWaitUntilVisible(int seconds, By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void fluentWaitUntilVisible(int seconds, By locator) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }




}
