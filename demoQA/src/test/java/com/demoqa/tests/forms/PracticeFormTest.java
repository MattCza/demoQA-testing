package com.demoqa.tests.forms;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = homePage.goToFormsCard().clickPracticeBoxItem();
        practiceFormPage.setFirstName("Matt");
        practiceFormPage.setLastName("Griffith");
        practiceFormPage.setMobileNumber("1234567890");
        practiceFormPage.setEmail("mg@gmail.com");
        practiceFormPage.setCurrentAddress("Warsaw \n Zlota 73/31");
        practiceFormPage.selectGenderMale();
        practiceFormPage.setDateOfBirth("1997", "March", "27");
        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");
        practiceFormPage.uploadPicture();
        practiceFormPage.selectHobbyReading();
        practiceFormPage.selectHobbySports();
        practiceFormPage.selectHobbyMusic();

        practiceFormPage.clickSubmitButton();
        practiceFormPage.clickCloseLargeModalButton();



        System.out.println("It is alive");
    }
}
