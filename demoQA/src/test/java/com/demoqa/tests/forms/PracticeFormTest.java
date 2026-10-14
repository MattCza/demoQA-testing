package com.demoqa.tests.forms;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeFormTest extends BaseTest {

    @Test
    public void practiceFormTest() {
        PracticeFormPage practiceFormPage = homePage.goToFormsCard().clickPracticeBoxItem();
        practiceFormPage.setFirstName("Matt");
        practiceFormPage.setLastName("Griffith");
        practiceFormPage.setMobileNumber("1234567890");
        practiceFormPage.setEmail("mg@gmail.com");
        practiceFormPage.setCurrentAddress("Warsaw, Zlota 73/31");
        practiceFormPage.selectGenderMale();
        practiceFormPage.setDateOfBirth("1997", "March", "27");
        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");
        practiceFormPage.uploadPicture();
        practiceFormPage.selectHobbyReading();
        practiceFormPage.selectHobbySports();
        practiceFormPage.selectHobbyMusic();

        practiceFormPage.clickSubmitButton();

        Assert.assertEquals(practiceFormPage.getSubmissionModalTitle(), "Thanks for submitting the form",
                "\n Submission confirmation modal is not displayed \n");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Student Name"), "Matt Griffith");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Student Email"), "mg@gmail.com");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Gender"), "Male");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Mobile"), "1234567890");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Date of Birth"), "27 March,1997");
        String hobbies = practiceFormPage.getSubmittedValue("Hobbies");
        softAssert.assertTrue(hobbies.contains("Sports") && hobbies.contains("Reading") && hobbies.contains("Music"),
                "Hobbies should contain Sports, Reading and Music but were: " + hobbies);
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Picture"), "tree.jpg");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("Address"), "Warsaw, Zlota 73/31");
        softAssert.assertEquals(practiceFormPage.getSubmittedValue("State and City"), "NCR Delhi");

        practiceFormPage.closeSubmissionModalWithEscape();
        softAssert.assertAll();
    }
}
