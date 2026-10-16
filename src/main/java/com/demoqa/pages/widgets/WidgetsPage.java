package com.demoqa.pages.widgets;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class WidgetsPage extends HomePage {
    public static final String PATH = "/widgets";

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public WidgetsPage open() {
        openPath(PATH);
        return this;
    }
}
