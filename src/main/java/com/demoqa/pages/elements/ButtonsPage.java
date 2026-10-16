package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsPage extends ElementsPage{
    public static final String PATH = "/buttons";

    private By doubleClickMeButton = By.id("doubleClickBtn");
    private By rightClickMeButton = By.id("rightClickBtn");
    private By clickMeButton = By.xpath("//button[text()='Click Me']");

    private By doubleClickMessage = By.id("doubleClickMessage");
    private By rightClickMessage = By.id("rightClickMessage");
    private By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public ButtonsPage open() {
        openPath(PATH);
        return this;
    }

    public void doubleClickButton(){
        doubleClick(doubleClickMeButton);
    }

    public void rightClickButton() {
        rightClick(rightClickMeButton);
    }

    public void clickButton(){
        click(clickMeButton);
    }

    public String getDoubleClickMessage() {
        return waitUntilVisible(doubleClickMessage).getText();
    }

    public String getRightClickMessage() {
        return waitUntilVisible(rightClickMessage).getText();
    }

    public String getDynamicClickMessage() {
        return waitUntilVisible(dynamicClickMessage).getText();
    }

    public boolean isDoubleClickMessageDisplayed() {
        return !driver.findElements(doubleClickMessage).isEmpty();
    }

    public boolean isRightClickMessageDisplayed() {
        return !driver.findElements(rightClickMessage).isEmpty();
    }

}
