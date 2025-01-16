package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBox() {
        CheckBoxPage checkBoxPage = homePage.goToElementsCard().clickCheckBoxItem();
        checkBoxPage.clickExpendAllButton();

        checkBoxPage.clickPublicItem();
        checkBoxPage.clickExcelFile();

        Assert.assertTrue(checkBoxPage.isExcelFileSelected(),
                "Excel File is NOT selected!");

        Assert.assertFalse(checkBoxPage.isWordFileSelected(),
                "Word File is NOT selected!");

        System.out.println("Selected items: " + checkBoxPage.getSelectedItems());
    }


}
