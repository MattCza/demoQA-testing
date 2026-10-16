package com.demoqa.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablesPage extends ElementsPage{
    public static final String PATH = "/webtables";

    private By addButton = By.id("addNewRecordButton");
    private By registrationModal = By.id("registration-form-modal");
    private By registrationFirstName = By.id("firstName");
    private By registrationLastName = By.id("lastName");
    private By registrationUserEmail = By.id("userEmail");
    private By registrationAgeField = By.id("age");
    private By registrationSalary = By.id("salary");
    private By registrationDepartment = By.id("department");
    private By registrationSubmitButton = By.id("submit");

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage open() {
        openPath(PATH);
        return this;
    }
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
        setText(registrationFirstName, firstName);
    }

    public void setLastName(String lastName){
        setText(registrationLastName, lastName);
    }

    public void setEmail(String email) {
        setText(registrationUserEmail, email);
    }

    public void setAge(String age) {
        setText(registrationAgeField, age);
    }

    public void setSalary(String salary) {
        setText(registrationSalary, salary);
    }

    public void setDepartment(String department) {
        setText(registrationDepartment, department);
    }

    public void addEmployee(String firstName, String lastName, String email, String age, String salary, String department){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAge(age);
        setSalary(salary);
        setDepartment(department);
        clickSubmitButton();
    }

    public void clickSubmitButton() {
        click(registrationSubmitButton);
        waitUntilInvisible(registrationModal);
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

    public String getTableDepartment(String email) {
        return find(cell(email, 6)).getText();
    }

}
