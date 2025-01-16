package com.demoqa.base;

import org.openqa.selenium.By;
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

    protected void doubleClick(By locator) {
        WebElement webElement = find(locator);
        new Actions(driver).doubleClick(webElement).perform();
    }

    protected void rightClick(By locator) {
        WebElement webElement = find(locator);
        new Actions(driver).contextClick(webElement).perform();
    }

    protected void setText(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
    }

}
