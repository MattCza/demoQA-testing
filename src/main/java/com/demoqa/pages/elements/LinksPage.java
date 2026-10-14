package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import java.util.Set;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class LinksPage extends ElementsPage {
    private By simpleLink = By.id("simpleLink");
    private By movedLink = By.id("moved");
    private By forbiddenLink = By.id("forbidden");
    private By responseLink = By.id("linkResponse");

    public void clickSimpleLink() {
        scrollToElementJavaScript(simpleLink);
        click(simpleLink);
    }

    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public void closeWindow() {
        String originalWindow = getOriginalWindow();
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
        scrollToElementJavaScript(movedLink);
        click(movedLink);
    }
    public void clickForbiddenResponseLink(){
        scrollToElementJavaScript(forbiddenLink);
        click(forbiddenLink);
    }

    public String getResponse() {
        delay(1000);
        return find(responseLink).getText();
    }
}
