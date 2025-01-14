package com.demoqa.elements;

import com.demoqa.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void testTextBox() {
        String fullName = "Mark Griffith";
        String currentAddress = "Testing current address";

        TextBoxPage textBoxPage = homePage.goToElementsCard().clickTextBoxItem();
        textBoxPage.setFullNameField(fullName);
        textBoxPage.setEmailField("MG@gmail.com");
        textBoxPage.setCurrentAddressField(currentAddress);
        textBoxPage.setPermanentAddressField("Now: permanent address");

        textBoxPage.clickSubmitButton();

        String actualCurrentAddress = textBoxPage.getCurrentAddressResult().substring(17);

        Assert.assertEquals(actualCurrentAddress, currentAddress,
                "\n Actual response is different form: " + currentAddress);
    }
}
