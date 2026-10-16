package com.demoqa.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PracticeFormPage extends FormsPage {

    public static final String PATH = "/automation-practice-form";

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderMaleField = By.id("gender-radio-1");
    private By mobileNumberField = By.id("userNumber");

    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By monthSelectDropDown = By.className("react-datepicker__month-select");
    private By yearSelectDropDown = By.className("react-datepicker__year-select");

    private By sportsHobbyCheckbox = By.id("hobbies-checkbox-1");
    private By readingHobbyCheckbox = By.id("hobbies-checkbox-2");
    private By musicHobbyCheckbox = By.id("hobbies-checkbox-3");
    private By uploadPictureInput = By.id("uploadPicture");
    private By currentAddressField = By.id("currentAddress");
    private By stateDropDown = By.id("react-select-3-input");
    private By cityDropDown = By.id("react-select-4-input");

    private By submitButton = By.id("submit");
    private By closeLargeModalButton = By.id("closeLargeModal");
    private By submissionModalTitle = By.id("example-modal-sizes-title-lg");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage open() {
        openPath(PATH);
        return this;
    }

    public void setFirstName(String firstName) {
        appendText(firstNameField, firstName);
    }

    public void setLastName(String lastName) {
        appendText(lastNameField, lastName);
    }

    public void setEmail(String email) {
        appendText(emailField, email);
    }

    public void selectGenderMale() {
        if (!find(genderMaleField).isSelected()) {
            clickJavaScript(genderMaleField);
        }
    }

    public void setMobileNumber(String mobileNumber) {
        appendText(mobileNumberField, mobileNumber);
    }

    public void setDateOfBirth(String year, String month, String day) {
        click(dateOfBirthInput);

        selectByVisibleText(monthSelectDropDown, month);
        selectByVisibleText(yearSelectDropDown, year);

        click(By.xpath("//div[contains(@class,'react-datepicker__day ') and not(contains(@class,'--outside-month'))]"
                + "[text()='" + Integer.parseInt(day) + "']"));
    }

    public void selectHobbySports() {
        scrollToElementJavaScript(sportsHobbyCheckbox);
        if (!find(sportsHobbyCheckbox).isSelected()) {
            clickJavaScript(sportsHobbyCheckbox);
        }
    }

    public void selectHobbyReading() {
        if (!find(readingHobbyCheckbox).isSelected()) {
            clickJavaScript(readingHobbyCheckbox);
        }
    }

    public void selectHobbyMusic() {
        if (!find(musicHobbyCheckbox).isSelected()) {
            clickJavaScript(musicHobbyCheckbox);
        }
    }

    public void uploadPicture(String absoluteFilePath) {
        find(uploadPictureInput).sendKeys(absoluteFilePath);
    }

    public void setCurrentAddress(String address) {
        appendText(currentAddressField, address);
    }

    public void selectState(String state) {
        WebElement stateInput = find(stateDropDown);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
    }

    public void selectCity(String city) {
        WebElement cityInput = find(cityDropDown);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public String getSubmissionModalTitle() {
        waitUntilVisible(submissionModalTitle);
        return find(submissionModalTitle).getText();
    }

    public String getSubmittedValue(String label) {
        return find(By.xpath("//div[@class='modal-body']//td[text()='" + label + "']/following-sibling::td")).getText();
    }

    public void closeSubmissionModalWithEscape() {
        new Actions(driver).sendKeys(Keys.ESCAPE).perform();
        waitUntilInvisible(submissionModalTitle);
    }

    public void clickCloseLargeModalButton() {
        click(closeLargeModalButton);
        waitUntilInvisible(submissionModalTitle);
    }


}
