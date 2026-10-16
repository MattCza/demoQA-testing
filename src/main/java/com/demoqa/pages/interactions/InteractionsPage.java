package com.demoqa.pages.interactions;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends HomePage {

    public static final String PATH = "/interaction";

    public InteractionsPage(WebDriver driver) {
        super(driver);
    }

    public InteractionsPage open() {
        openPath(PATH);
        return this;
    }
}
