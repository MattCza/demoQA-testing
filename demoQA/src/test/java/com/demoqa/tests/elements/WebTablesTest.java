package com.demoqa.tests.elements;

import com.demoqa.base.BaseTest;
import com.demoqa.pages.elements.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqa.base.BasePage.delay;

public class WebTablesTest extends BaseTest {

    @Test
    public void webTablesTest(){
        String email = "ms@gmail.com";
        String emailToEdit = "kierra@example.com";
        String expectedSalary = "6000";

        WebTablesPage webTablesPage = homePage.goToElementsCard().clickWebTablesItem();
        webTablesPage.clickAddButton();
        webTablesPage.addEmployee("Matt", "Smith", email, "27", "10000", "Technology");

        delay(1234);
        Assert.assertTrue(webTablesPage.isRecordPresent(email));
        webTablesPage.deleteTableRecord(email);

        webTablesPage.clickEditButton(emailToEdit);
        webTablesPage.setSalary(expectedSalary);
        webTablesPage.clickSubmitButton();
        String actualSalary = webTablesPage.getTableSalary(emailToEdit);

        Assert.assertEquals(actualSalary, expectedSalary,
                "\n Actual Salary Does not equals Expected salary! \n");

    }
}
