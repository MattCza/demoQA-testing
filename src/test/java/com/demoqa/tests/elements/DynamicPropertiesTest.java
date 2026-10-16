package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.DynamicPropertiesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends BaseTest {

    @Test
    public void delayedButtonBecomesVisible() {
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver()).open();

        Assert.assertEquals(dynamicPropertiesPage.getVisibleAfterButtonText(), "Visible After 5 Seconds",
                "Delayed button did not appear with the expected text");
    }

    @Test
    public void delayedButtonBecomesEnabled() {
        DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage(driver()).open();
        Assert.assertFalse(dynamicPropertiesPage.isEnableAfterButtonEnabled(),
                "Button should be disabled right after the page loads");

        dynamicPropertiesPage.waitUntilEnableAfterButtonIsEnabled();

        Assert.assertTrue(dynamicPropertiesPage.isEnableAfterButtonEnabled(), "Button did not become enabled");
    }
}
