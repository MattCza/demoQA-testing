package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void testTextBox() {
        String fullName = "Mark Griffith";
        String email = "MG@gmail.com";
        String currentAddress = "Testing current address";
        String permanentAddress = "This is permanent address";

        TextBoxPage textBoxPage = homePage.goToElementsCard().clickTextBoxItem();
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);

        textBoxPage.clickSubmitButton();

        String actualFullName = textBoxPage.getNameResult().substring(5);
        String actualEmail = textBoxPage.getEmailResult().substring(6);
        String actualCurrentAddress = textBoxPage.getCurrentAddressResult().substring(17);
        String actualPermanentAddress = textBoxPage.getPermanentAddressResult().substring(20);


        Assert.assertEquals(actualFullName, fullName,
                "\n Actual Full Name field response is different form provided: " + fullName);

        Assert.assertEquals(actualEmail, email,
                "\n Actual Email response is different form provided: " + email);

        Assert.assertEquals(actualCurrentAddress, currentAddress,
                "\n Actual Current Address response is different form provided: " + currentAddress);

        Assert.assertEquals(actualPermanentAddress, permanentAddress,
                "\n Actual Permanent Address response is different form provided: " + permanentAddress);
    }
}
