package com.demoqa.base;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static com.demoqa.utilities.Utility.setUtilityDriver;

public class BaseTest {
    protected String DEMOQA_URL = "https://demoqa.com/";
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;


    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(DEMOQA_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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
