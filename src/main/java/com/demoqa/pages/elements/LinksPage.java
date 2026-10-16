package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LinksPage extends ElementsPage {

    public static final String PATH = "/links";

    private By simpleLink = By.id("simpleLink");
    private By response = By.id("linkResponse");
    private By responseValues = By.cssSelector("#linkResponse b");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public LinksPage open() {
        openPath(PATH);
        return this;
    }

    public String openSimpleLinkAndGetNewTabUrl() {
        String originalWindow = driver.getWindowHandle();
        scrollToElementJavaScript(simpleLink);
        click(simpleLink);

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String newWindow = driver.getWindowHandles().stream()
                .filter(handle -> !handle.equals(originalWindow))
                .findFirst()
                .orElseThrow();
        driver.switchTo().window(newWindow);

        wait.until(d -> !"about:blank".equals(d.getCurrentUrl()));
        String newTabUrl = driver.getCurrentUrl();

        driver.close();
        driver.switchTo().window(originalWindow);
        return newTabUrl;
    }

    public int getOpenWindowCount() {
        return driver.getWindowHandles().size();
    }

    public void clickApiLink(String linkId) {
        clickAndWaitForNewResponse(By.id(linkId));
    }

    public int getResponseStatusCode() {
        return Integer.parseInt(find(responseValues).getText().trim());
    }

    public String getResponseStatusText() {
        return driver.findElements(responseValues).get(1).getText().trim();
    }


    private void clickAndWaitForNewResponse(By link) {
        String previousResponse = currentResponseText();
        scrollToElementJavaScript(link);
        click(link);
        wait.until(d -> {
            String text = currentResponseText();
            return !text.isEmpty() && !text.equals(previousResponse);
        });
    }

    private String currentResponseText() {
        List<WebElement> responses = driver.findElements(response);
        return responses.isEmpty() ? "" : responses.getFirst().getText();
    }
}
