package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testCheckBox() {
        CheckBoxPage checkBoxPage = homePage.goToElementsCard().clickCheckBoxItem();
        checkBoxPage.expandNodes("Home", "Documents", "Office", "Downloads");

        checkBoxPage.selectItem("Public");
        checkBoxPage.selectItem("Excel File.doc");

        Assert.assertTrue(checkBoxPage.isItemChecked("Public"),
                "Public is NOT selected!");
        Assert.assertTrue(checkBoxPage.isItemChecked("Excel File.doc"),
                "Excel File is NOT selected!");
        Assert.assertFalse(checkBoxPage.isItemChecked("Word File.doc"),
                "Word File should NOT be selected!");

        Assert.assertEquals(checkBoxPage.getSelectedItems(), List.of("public", "excelFile"),
                "Result panel does not list exactly the selected items");
    }


}
