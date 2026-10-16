package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public TextBoxPage(WebDriver driver) {
        super(driver);
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
