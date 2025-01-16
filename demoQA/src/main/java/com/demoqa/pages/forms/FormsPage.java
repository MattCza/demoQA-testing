package com.demoqa.pages.forms;

import com.demoqa.pages.HomePage;
import org.openqa.selenium.By;

import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;

public class FormsPage extends HomePage {
    private By practiceFromItem = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    public PracticeFormPage clickPracticeBoxItem() {
        scrollToElementJavaScript(practiceFromItem);
        click(practiceFromItem);
        return new PracticeFormPage();
    }

}
