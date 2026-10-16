package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicPropertiesPage extends ElementsPage {
    private By visibleAfterButton = By.id("visibleAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public String getVisibleAfterButtonText() {
        return waitUntilVisible(visibleAfterButton).getText();
    }

}
