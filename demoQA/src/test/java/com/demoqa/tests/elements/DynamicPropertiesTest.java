package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.DynamicPropertiesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void dynamicPropertiesTest() {
        DynamicPropertiesPage dynamicPropertiesPage = homePage.goToElementsCard().clickDynamicPropertiesItem();

        String actualText = dynamicPropertiesPage.getVisibleAfterButtonText();
        String expectedText = "Visible After 5 Seconds";

        Assert.assertEquals(actualText, expectedText,
                "\n Actual & Expected Text Do Not Match \n");
    }
}
