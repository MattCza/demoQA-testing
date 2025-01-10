package com.demoqa.base;

import com.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected String DEMOQA_URL = "https://demoqa.com/";
    protected WebDriver driver;
    protected BasePage basePage;


    @BeforeClass
    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.czajkowsk2\\Desktop\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
//        driver.quit();
    }


}
