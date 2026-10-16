package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.UUID;

/**
 * The table is kept in page memory only and resets on every page load,
 * so each test opens the page fresh and works on its own record.
 */
public class WebTablesTest extends BaseTest {

    @Test
    public void addedRecordAppearsInTable() {
        String email = "matt.smith." + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        WebTablesPage webTablesPage = new WebTablesPage(driver()).open();
        webTablesPage.clickAddButton();
        webTablesPage.addEmployee("Matt", "Smith", email, "27", "10000", "Technology");

        Assert.assertTrue(webTablesPage.isRecordPresent(email), "Added record is not present in the table");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(webTablesPage.getTableFirstName(email), "Matt", "First name");
        softAssert.assertEquals(webTablesPage.getTableLastName(email), "Smith", "Last name");
        softAssert.assertEquals(webTablesPage.getTableAge(email), "27", "Age");
        softAssert.assertEquals(webTablesPage.getTableSalary(email), "10000", "Salary");
        softAssert.assertEquals(webTablesPage.getTableDepartment(email), "Technology", "Department");
        softAssert.assertAll();
    }

    @Test
    public void deletedRecordDisappearsFromTable() {
        String email = "alden@example.com";

        WebTablesPage webTablesPage = new WebTablesPage(driver()).open();
        Assert.assertTrue(webTablesPage.isRecordPresent(email), "Precondition: seed record is missing");

        webTablesPage.deleteTableRecord(email);

        Assert.assertFalse(webTablesPage.isRecordPresent(email), "Deleted record is still present in the table");
    }

    @Test
    public void editedSalaryIsShownInTable() {
        String email = "kierra@example.com";
        String newSalary = "6000";

        WebTablesPage webTablesPage = new WebTablesPage(driver()).open();
        webTablesPage.clickEditButton(email);
        webTablesPage.setSalary(newSalary);
        webTablesPage.clickSubmitButton();

        Assert.assertEquals(webTablesPage.getTableSalary(email), newSalary, "Salary was not updated");
    }
}
