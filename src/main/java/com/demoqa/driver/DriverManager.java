package com.demoqa.driver;

import org.openqa.selenium.WebDriver;

// Holds one WebDriver per thread - no browser share in parallel
public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void initDriver() {
        if (DRIVER.get() != null) {
            throw new IllegalStateException("WebDriver is already initialised for thread " + Thread.currentThread().getName());
        }
        DRIVER.set(DriverFactory.createDriver());
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("No WebDriver for thread " + Thread.currentThread().getName()
                    + "; call DriverManager.initDriver() first");
        }
        return driver;
    }

    public static boolean hasDriver() {
        return DRIVER.get() != null;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DRIVER.remove();
            }
        }
    }

}
