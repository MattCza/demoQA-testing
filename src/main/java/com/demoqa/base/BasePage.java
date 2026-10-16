package com.demoqa.base;

import com.demoqa.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Config.timeout());
    }

    // Waits for presence only: some inputs (e.g. styled checkboxes) are hidden and handled via JavaScript.
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected void set(By locator, String text) {
        WebElement element = waitUntilVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void type(By locator, String text) {
        waitUntilVisible(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Actions do not scroll the target into view in Firefox, so pointer actions scroll first.
    // 'instant' overrides the page's CSS smooth scrolling, which would move the element mid-action.
    private WebElement findInViewport(By locator) {
        WebElement webElement = find(locator);
        javaScript().executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", webElement);
        return webElement;
    }

    protected void doubleClick(By locator) {
        new Actions(driver).doubleClick(findInViewport(locator)).perform();
    }

    protected void rightClick(By locator) {
        new Actions(driver).contextClick(findInViewport(locator)).perform();
    }

    protected void selectByVisibleText(By locator, String text) {
        new Select(find(locator)).selectByVisibleText(text);
    }

    protected WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitUntilInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void scrollToElementJavaScript(By locator) {
        javaScript().executeScript("arguments[0].scrollIntoView();", find(locator));
    }

    protected void clickJavaScript(By locator) {
        javaScript().executeScript("arguments[0].click();", find(locator));
    }

    private JavascriptExecutor javaScript() {
        return (JavascriptExecutor) driver;
    }

}
