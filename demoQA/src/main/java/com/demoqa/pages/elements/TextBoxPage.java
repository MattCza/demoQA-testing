package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;
import static com.demoqa.utilities.Utility.getText;

public class TextBoxPage extends ElementsPage {
    private By fullNameField = By.id("userName");
    private By emailField = By.xpath("//input[@placeholder='name@example.com']");
    private By currentAddressField = By.xpath("//textarea[@id='currentAddress']");
    private By permanentAddressField = By.id("permanentAddress");

    private By submitButton = By.id("submit");

    private By nameResult = By.xpath("//p[@id='name']");
    private By emailResult = By.xpath("//p[@id='email']");
    private By currentAddressResult = By.xpath("//p[@id='currentAddress']");
    private By permanentAddressResult = By.xpath("//p[@id='permanentAddress']");

    public void setFullNameField(String fullName) {
        find(fullNameField).sendKeys(fullName);
    }

    public void setEmailField(String email) {
        find(emailField).sendKeys(email);
    }

    public void setCurrentAddressField(String currentAddress) {
        find(currentAddressField).sendKeys(currentAddress);
    }

    public void setPermanentAddressField(String permanentAddress) {
        find(permanentAddressField).sendKeys(permanentAddress);
    }

    public void clickSubmitButton() {
        scrollToElementJavaScript(submitButton);
        click(submitButton);
    }

    public String getNameResult() {
        return getText(nameResult);
    }

    public String getEmailResult() {
        return getText(emailResult);
    }

    public String getCurrentAddressResult() {
        return getText(currentAddressResult);
    }

    public String getPermanentAddressResult() {
        return getText(permanentAddressResult);
    }


}
