package com.demoqa.pages.alerts_frame_windows;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class AlertsFrameWindowsPage extends HomePage {

    public static final String PATH = "/alertsWindows";

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsFrameWindowsPage open() {
        openPath(PATH);
        return this;
    }
}