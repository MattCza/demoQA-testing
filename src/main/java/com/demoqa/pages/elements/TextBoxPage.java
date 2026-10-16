package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends ElementsPage {
    public static final String PATH = "/text-box";

    private By fullNameField = By.id("userName");
    private By emailField = By.xpath("//input[@placeholder='name@example.com']");
    private By currentAddressField = By.xpath("//textarea[@id='currentAddress']");
    private By permanentAddressField = By.id("permanentAddress");

    private By submitButton = By.id("submit");

    private By nameResult = By.xpath("//p[@id='name']");
    private By emailResult = By.xpath("//p[@id='email']");
    private By currentAddressResult = By.xpath("//p[@id='currentAddress']");
    private By permanentAddressResult = By.xpath("//p[@id='permanentAddress']");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage open() {
        openPath(PATH);
        return this;
    }

    public void setFullNameField(String fullName) {
        type(fullNameField, fullName);
    }

    public void setEmailField(String email) {
        type(emailField, email);
    }

    public void setCurrentAddressField(String currentAddress) {
        type(currentAddressField, currentAddress);
    }

    public void setPermanentAddressField(String permanentAddress) {
        type(permanentAddressField, permanentAddress);
    }

    public void clickSubmitButton() {
        scrollToElementJavaScript(submitButton);
        click(submitButton);
    }

    public String getNameResult() {
        return outputValue(nameResult);
    }

    public String getEmailResult() {
        return outputValue(emailResult);
    }

    public String getCurrentAddressResult() {
        return outputValue(currentAddressResult);
    }

    public String getPermanentAddressResult() {
        return outputValue(permanentAddressResult);
    }

    // Output lines look like "Name:John" or "Current Address :Street 1" - return the part after the label
    private String outputValue(By outputLine) {
        String text = waitUntilVisible(outputLine).getText();
        int separator = text.indexOf(':');
        if (separator < 0) {
            throw new IllegalStateException("Unexpected output format: '" + text + "'");
        }
        return text.substring(separator + 1).trim();
    }

}
