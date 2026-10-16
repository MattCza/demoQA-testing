package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest extends BaseTest {

    @Test
    public void selectedLeafItemsAreListedInResult() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver()).open();
        checkBoxPage.expandNodes("Home", "Documents", "Office", "Downloads");

        checkBoxPage.selectItem("Public");
        checkBoxPage.selectItem("Excel File.doc");

        Assert.assertTrue(checkBoxPage.isItemChecked("Public"), "Public is NOT selected");
        Assert.assertTrue(checkBoxPage.isItemChecked("Excel File.doc"), "Excel File is NOT selected");
        Assert.assertFalse(checkBoxPage.isItemChecked("Word File.doc"), "Word File should NOT be selected");
        Assert.assertEquals(checkBoxPage.getSelectedItems(), List.of("public", "excelFile"),
                "Result panel does not list exactly the selected items");
    }

    @Test
    public void selectingFolderSelectsAllItsChildren() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver()).open();
        checkBoxPage.expandNodes("Home", "Downloads");

        checkBoxPage.selectItem("Downloads");

        Assert.assertTrue(checkBoxPage.isItemChecked("Word File.doc"), "Word File was not selected with its folder");
        Assert.assertTrue(checkBoxPage.isItemChecked("Excel File.doc"), "Excel File was not selected with its folder");
        Assert.assertTrue(checkBoxPage.isItemPartiallyChecked("Home"),
                "Home should be partially checked when only one of its folders is selected");
        Assert.assertEquals(checkBoxPage.getSelectedItems(), List.of("downloads", "wordFile", "excelFile"),
                "Result panel does not list the folder and its children");
    }
}
