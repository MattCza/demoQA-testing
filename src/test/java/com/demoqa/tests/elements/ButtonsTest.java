package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void buttonsTest() {
        ButtonsPage buttonsPage = homePage.goToElementsCard().clickButtonsItem();
        buttonsPage.doubleClickButton();
        buttonsPage.rightClickButton();
        buttonsPage.clickButton();

        Assert.assertTrue(buttonsPage.isClickMeButtonDisplayed(),
                "\nDynamic click button is not clicked properly \n");
        Assert.assertTrue(buttonsPage.isDoubleClickMeButtonDisplayed(),
                "\nDouble click button is not clicked properly \n");
        Assert.assertTrue(buttonsPage.isRightClickMeButtonDisplayed(),
                "\nRight Click button is not clicked properly \n");
    }
}
