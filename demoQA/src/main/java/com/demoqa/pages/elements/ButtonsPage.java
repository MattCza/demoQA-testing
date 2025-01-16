package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class ButtonsPage extends ElementsPage{

    private By doubleClickMeButton = By.id("doubleClickBtn");
    private By rightClickMeButton = By.id("rightClickBtn");
    private By clickMeButton = By.xpath("//button[text()='Click Me']");

    private By doubleClickMeButtonDisplayed = By.id("doubleClickMessage");
    private By rightClickMeButtonDisplayed = By.id("rightClickMessage");
    private By clickMeButtonDisplayed = By.id("dynamicClickMessage");

    public void doubleClickButton(){
        doubleClick(doubleClickMeButton);
    }

    public void rightClickButton() {
        rightClick(rightClickMeButton);
    }

    public void clickButton(){
        click(clickMeButton);
    }

    public boolean isDoubleClickMeButtonDisplayed() {
        return find(doubleClickMeButtonDisplayed).isDisplayed();
    }

    public boolean isRightClickMeButtonDisplayed() {
        return find(rightClickMeButtonDisplayed).isDisplayed();
    }

    public boolean isClickMeButtonDisplayed() {
        return find(clickMeButtonDisplayed).isDisplayed();
    }

}
