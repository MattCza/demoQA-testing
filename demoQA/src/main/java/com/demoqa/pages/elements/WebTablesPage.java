package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class WebTablesPage extends ElementsPage{

    private By addButton = By.id("addNewRecordButton");
    private By registrationFirstName = By.id("firstName");
    private By registrationLastName = By.id("lastName");
    private By registrationuserEmail = By.id("userEmail");
    private By registrationAgeField = By.id("age");
    private By registrationSalary = By.id("salary");
    private By registrationDepartment = By.id("department");
    private By registrationSubmitButton = By.id("submit");


    public void clickAddButton(){
        click(addButton);
    }

    public boolean isRecordPresent(String email) {
        By recordLocator = By.xpath("//div[text()='" + email + "']");
        return isElementPresent(recordLocator);
    }

    private boolean isElementPresent(By locator) {
        try {
            find(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickEditButton(String email){
        By editButton = By.xpath("//div[text()='"+ email +"']//following::span[@title='Edit']");
        click(editButton);
    }

    public void deleteTableRecord(String email) {
        By deleteRecord = By.xpath("//div[text()='"+ email +"']//following::span[@title='Delete']");
        click(deleteRecord);
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
    }


    public String getTableFirstName(String email) {
        By firstNameField = By.xpath("//div[text()='" + email + "']/preceding::div[3]");
        return find(firstNameField).getText();
    }

    public String getTableSalary(String email) {
        By firstNameField = By.xpath("//div[text()='" + email + "']/following::div[1]");
        return find(firstNameField).getText();
    }

    public String getTableLastName(String email) {
        By lastNameField = By.xpath("//div[text()='" + email + "']/preceding::div[2]");
        return find(lastNameField).getText();
    }

    public String getTableAge(String email) {
        By ageField = By.xpath("//div[text()='" + email + "']/preceding::div[1]");
        return find(ageField).getText();
    }






}
