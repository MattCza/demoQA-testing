package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.TextBoxPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TextBoxTest extends BaseTest {

    @DataProvider
    public Object[][] validInput() {
        return new Object[][]{
                {"Mark Griffith", "MG@gmail.com", "Testing current address", "This is permanent address"},
                {"Łukasz Żółć", "lukasz.zolc@example.pl", "ul. Złota 73/31, Warszawa", "Kraków, Rynek Główny 1"},
        };
    }

    @Test(dataProvider = "validInput")
    public void submittedDataIsShownInOutput(String fullName, String email, String currentAddress, String permanentAddress) {
        TextBoxPage textBoxPage = new TextBoxPage(driver()).open();
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField(email);
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField(permanentAddress);
        textBoxPage.clickSubmitButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(textBoxPage.getNameResult(), fullName, "Name");
        softAssert.assertEquals(textBoxPage.getEmailResult(), email, "Email");
        softAssert.assertEquals(textBoxPage.getCurrentAddressResult(), currentAddress, "Current address");
        softAssert.assertEquals(textBoxPage.getPermanentAddressResult(), permanentAddress, "Permanent address");
        softAssert.assertAll();
    }
}
