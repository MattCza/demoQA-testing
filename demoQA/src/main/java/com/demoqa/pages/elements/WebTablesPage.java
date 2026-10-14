package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import static com.demoqa.utilities.Utility.explicitWaitUntilInvisible;

public class WebTablesPage extends ElementsPage{

    private By addButton = By.id("addNewRecordButton");
    private By registrationModal = By.id("registration-form-modal");
    private By registrationFirstName = By.id("firstName");
    private By registrationLastName = By.id("lastName");
    private By registrationuserEmail = By.id("userEmail");
    private By registrationAgeField = By.id("age");
    private By registrationSalary = By.id("salary");
    private By registrationDepartment = By.id("department");
    private By registrationSubmitButton = By.id("submit");

    // Table columns: 1 First Name, 2 Last Name, 3 Age, 4 Email, 5 Salary, 6 Department, 7 Action
    private String rowXpath(String email) {
        return "//tbody/tr[td[4][text()='" + email + "']]";
    }

    private By cell(String email, int column) {
        return By.xpath(rowXpath(email) + "/td[" + column + "]");
    }


    public void clickAddButton(){
        click(addButton);
    }

    public boolean isRecordPresent(String email) {
        return !driver.findElements(By.xpath(rowXpath(email))).isEmpty();
    }

    public void clickEditButton(String email){
        click(By.xpath(rowXpath(email) + "//span[@title='Edit']"));
    }

    public void deleteTableRecord(String email) {
        click(By.xpath(rowXpath(email) + "//span[@title='Delete']"));
    }

    public void setFirstName(String firstName) {
        set(registrationFirstName, firstName);
    }

    public void setLastName(String lastName){
        set(registrationLastName, lastName);
    }

    public void setEmail(String email) {
        set(registrationuserEmail, email);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void setSalary(String salary) {
        set(registrationSalary, salary);
    }

    public void setDepartment(String department) {
        set(registrationDepartment, department);
    }

    public void addEmployee(String firstName, String lastName, String email, String age, String salary, String department){
        set(registrationFirstName, firstName);
        set(registrationLastName, lastName);
        set(registrationuserEmail, email);
        set(registrationAgeField, age);
        set(registrationSalary, salary);
        set(registrationDepartment, department);
        clickSubmitButton();
    }

    public void clickSubmitButton() {
        click(registrationSubmitButton);
        explicitWaitUntilInvisible(5, registrationModal);
    }


    public String getTableFirstName(String email) {
        return find(cell(email, 1)).getText();
    }

    public String getTableLastName(String email) {
        return find(cell(email, 2)).getText();
    }

    public String getTableAge(String email) {
        return find(cell(email, 3)).getText();
    }

    public String getTableSalary(String email) {
        return find(cell(email, 5)).getText();
    }

}
