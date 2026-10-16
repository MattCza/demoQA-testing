package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void doubleClickShowsDoubleClickMessage() {
        ButtonsPage buttonsPage = new ButtonsPage(driver()).open();
        buttonsPage.doubleClickButton();

        Assert.assertEquals(buttonsPage.getDoubleClickMessage(), "You have done a double click");
    }

    @Test
    public void rightClickShowsRightClickMessage() {
        ButtonsPage buttonsPage = new ButtonsPage(driver()).open();
        buttonsPage.rightClickButton();

        Assert.assertEquals(buttonsPage.getRightClickMessage(), "You have done a right click");
    }

    @Test
    public void singleClickShowsDynamicClickMessage() {
        ButtonsPage buttonsPage = new ButtonsPage(driver()).open();
        buttonsPage.clickButton();

        Assert.assertEquals(buttonsPage.getDynamicClickMessage(), "You have done a dynamic click");
    }

    @Test
    public void singleClickIsNotTreatedAsDoubleOrRightClick() {
        ButtonsPage buttonsPage = new ButtonsPage(driver()).open();
        buttonsPage.clickButton();
        // Waiting for the dynamic click message guarantees the click has been handled before checking absence
        buttonsPage.getDynamicClickMessage();

        Assert.assertFalse(buttonsPage.isDoubleClickMessageDisplayed(), "Single click was treated as a double click");
        Assert.assertFalse(buttonsPage.isRightClickMessageDisplayed(), "Single click was treated as a right click");
    }
}
