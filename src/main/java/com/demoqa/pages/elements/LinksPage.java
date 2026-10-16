package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class LinksPage extends ElementsPage {
    private By simpleLink = By.id("simpleLink");
    private By movedLink = By.id("moved");
    private By forbiddenLink = By.id("forbidden");
    private By responseLink = By.id("linkResponse");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void clickSimpleLink() {
        scrollToElementJavaScript(simpleLink);
        click(simpleLink);
    }

    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public void closeWindow() {
        String originalWindow = getOriginalWindow();
        // Without this wait a not-yet-opened tab would make the loop find nothing and close the original window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.close();
        driver.switchTo().window(originalWindow);
    }

    public void clickMovedResponseLink(){
        clickAndWaitForNewResponse(movedLink);
    }

    public void clickForbiddenResponseLink(){
        clickAndWaitForNewResponse(forbiddenLink);
    }

    public String getResponse() {
        return getText(responseLink);
    }

    // The response is fetched asynchronously and replaces the previous one in place, so wait for the text to change.
    // Clicking the same link twice in a row yields an identical text and would time out.
    private void clickAndWaitForNewResponse(By link) {
        String previousResponse = currentResponseText();
        scrollToElementJavaScript(link);
        click(link);
        wait.until(d -> {
            String response = currentResponseText();
            return !response.isEmpty() && !response.equals(previousResponse);
        });
    }

    private String currentResponseText() {
        List<WebElement> response = driver.findElements(responseLink);
        return response.isEmpty() ? "" : response.get(0).getText();
    }
}
