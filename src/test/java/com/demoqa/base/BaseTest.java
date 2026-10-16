package com.demoqa.base;

import com.demoqa.config.Config;
import com.demoqa.driver.DriverManager;
import com.demoqa.listeners.TestListener;
import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Listeners(TestListener.class)
public class BaseTest {
    protected HomePage homePage;


    @BeforeClass
    public void setUp(){
        DriverManager.initDriver();
    }

    @BeforeMethod
    public void loadApplication() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Config.baseUrl() + "/");
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
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
