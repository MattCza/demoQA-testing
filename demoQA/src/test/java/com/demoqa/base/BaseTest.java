package com.demoqa.base;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static com.demoqa.base.BasePage.delay;
import static com.demoqa.utilities.Utility.setUtilityDriver;

public class BaseTest {
    protected String DEMOQA_URL = "https://demoqa.com/";
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;


    @BeforeClass
    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.czajkowsk2\\Desktop\\Projects\\driver\\chromedriver-win64\\chromedriver.exe");
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

//    @AfterClass
//    public void tearDown() {
//        delay(3000);
//        driver.quit();
//    }


}
