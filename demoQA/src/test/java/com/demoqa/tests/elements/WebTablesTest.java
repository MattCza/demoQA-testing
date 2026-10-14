package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {

    @Test
    public void webTablesTest(){
        String email = "ms@gmail.com";
        String emailToEdit = "kierra@example.com";
        String expectedSalary = "6000";

        WebTablesPage webTablesPage = homePage.goToElementsCard().clickWebTablesItem();
        webTablesPage.clickAddButton();
        webTablesPage.addEmployee("Matt", "Smith", email, "27", "10000", "Technology");

        Assert.assertTrue(webTablesPage.isRecordPresent(email),
                "\n Added record is not present in the table \n");
        webTablesPage.deleteTableRecord(email);
        Assert.assertFalse(webTablesPage.isRecordPresent(email),
                "\n Deleted record is still present in the table \n");

        webTablesPage.clickEditButton(emailToEdit);
        webTablesPage.setSalary(expectedSalary);
        webTablesPage.clickSubmitButton();
        String actualSalary = webTablesPage.getTableSalary(emailToEdit);

        Assert.assertEquals(actualSalary, expectedSalary,
                "\n Actual Salary Does not equals Expected salary! \n");

    }
}
