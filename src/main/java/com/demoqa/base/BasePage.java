package com.demoqa.base;

import com.demoqa.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Config.timeout());
    }

    protected void openPath(String path) {
        driver.get(Config.baseUrl() + path);
    }

    public String getCurrentPath() {
        return URI.create(driver.getCurrentUrl()).getPath();
    }

    public String waitForPath(String expectedPath) {
        try {
            wait.until(d -> expectedPath.equals(getCurrentPath()));
        } catch (TimeoutException e) {
            // fall through: the caller asserts on the returned path
        }
        return getCurrentPath();
    }

    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected void setText(By locator, String text) {
        WebElement element = waitUntilVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void appendText(By locator, String text) {
        waitUntilVisible(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private WebElement findInViewport(By locator) {
        WebElement webElement = waitUntilVisible(locator);
        scrollIntoView(webElement);
        waitUntilPositionIsStable(webElement);
        return webElement;
    }


    // 'instant' overrides smooth scrolling, which could move the element mid-action
    // 'center' keeps it clear of the sticky header and footer
    private void scrollIntoView(WebElement webElement) {
        javaScript().executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'instant'});", webElement);
    }

    // Layout can shift after rendering
    private void waitUntilPositionIsStable(WebElement webElement) {
        Rectangle[] previous = {webElement.getRect()};
        new WebDriverWait(driver, Config.timeout(), Duration.ofMillis(150)).until(d -> {
            Rectangle current = webElement.getRect();
            boolean stable = current.equals(previous[0]);
            previous[0] = current;
            return stable;
        });
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
        scrollIntoView(find(locator));
    }

    protected void clickJavaScript(By locator) {
        javaScript().executeScript("arguments[0].click();", find(locator));
    }

    private JavascriptExecutor javaScript() {
        return (JavascriptExecutor) driver;
    }

}