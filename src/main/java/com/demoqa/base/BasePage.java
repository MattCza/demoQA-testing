package com.demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    // Actions do not scroll the target into view in Firefox, so pointer actions scroll first.
    // 'instant' overrides the page's CSS smooth scrolling, which would move the element mid-action.
    private WebElement findInViewport(By locator) {
        WebElement webElement = find(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", webElement);
        return webElement;
    }

    protected void doubleClick(By locator) {
        new Actions(driver).doubleClick(findInViewport(locator)).perform();
    }

    protected void rightClick(By locator) {
        new Actions(driver).contextClick(findInViewport(locator)).perform();
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

}
