package com.demoqa.base;

import com.demoqa.driver.DriverManager;
import com.demoqa.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * One browser per test class. Each test opens the page it needs by URL (page.open()),
 * so tests do not depend on each other or on the home page navigation.
 */
@Listeners(TestListener.class)
public class BaseTest {

    @BeforeClass
    public void setUp(){
        DriverManager.initDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }

    protected WebDriver driver() {
        return DriverManager.getDriver();
    }

    protected String getResourcePath(String resourceName) {
        URL resource = getClass().getClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("Test resource not found on classpath: " + resourceName);
        }
        try {
            return Paths.get(resource.toURI()).toString();
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Invalid resource URI: " + resource, e);
        }
    }

}
