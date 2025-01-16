package com.demoqa.tests.forms;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = homePage.goToFormsCard().clickPracticeBoxItem();
        practiceFormPage.fillUpForm("Matt", "Smith", "ms@gmail.com", "1234567890", "comp", "Warsaw");
        System.out.println("It is alive");
    }
}
