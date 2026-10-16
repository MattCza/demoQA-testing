package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicPropertiesPage extends ElementsPage {
    public static final String PATH = "/dynamic-properties";

    private By visibleAfterButton = By.id("visibleAfter");
    private By enableAfterButton = By.id("enableAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public DynamicPropertiesPage open() {
        openPath(PATH);
        return this;
    }

    public String getVisibleAfterButtonText() {
        return waitUntilVisible(visibleAfterButton).getText();
    }

    public boolean isEnableAfterButtonEnabled() {
        return find(enableAfterButton).isEnabled();
    }

    public void waitUntilEnableAfterButtonIsEnabled() {
        wait.until(ExpectedConditions.elementToBeClickable(enableAfterButton));
    }

}
