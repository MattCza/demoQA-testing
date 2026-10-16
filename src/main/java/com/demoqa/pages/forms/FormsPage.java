package com.demoqa.pages.forms;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormsPage extends HomePage {
    private By practiceFromItem = By.cssSelector("a[href='/automation-practice-form']");

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage clickPracticeBoxItem() {
        scrollToElementJavaScript(practiceFromItem);
        click(practiceFromItem);
        return new PracticeFormPage(driver);
    }

}
