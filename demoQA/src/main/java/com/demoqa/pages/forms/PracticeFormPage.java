package com.demoqa.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.demoqa.utilities.JavaScriptUtility.clickJavaScript;
import static com.demoqa.utilities.JavaScriptUtility.scrollToElementJavaScript;
import static com.demoqa.utilities.Utility.explicitWaitUntilVisible;

public class PracticeFormPage extends FormsPage {
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderMaleField = By.id("gender-radio-1");
    private By mobileNumberField = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By subjectsField = By.id("subjectsContainer");
    private By sportsHobbyCheckbox = By.id("hobbies-checkbox-1");
    private By readingHobbyCheckbox = By.id("hobbies-checkbox-2");
    private By musicHobbyCheckbox = By.id("hobbies-checkbox-3");
    private By uploadPictureInput = By.id("uploadPicture");
    private By currentAddressField = By.id("currentAddress");
    private By stateDropDown = By.id("state");
    private By cityDropDown = By.id("city");

    private By submitButton = By.id("submit");



    public void fillUpForm(String firstName, String lastName, String email, String phoneNumber, String subjectPartialText, String currentAddress) {
        find(firstNameField).sendKeys(firstName);
        find(lastNameField).sendKeys(lastName);
        find(emailField).sendKeys(email);
        scrollToElementJavaScript(genderMaleField);
        clickJavaScript(genderMaleField);
        find(mobileNumberField).sendKeys(phoneNumber);
        selectFromAutoComplete(subjectPartialText);
        find(sportsHobbyCheckbox).click();
        find(readingHobbyCheckbox).click();
        find(musicHobbyCheckbox).click();
        find(currentAddressField).sendKeys(currentAddress);

    }

    public void selectFromAutoComplete(String partialText) {
//        WebElement inputField = find(subjectsField);
//        inputField.sendKeys(partialText);
//        explicitWaitUntilVisible(5, subjectsField);
//        inputField.sendKeys(Keys.ENTER);

        WebElement input = find(subjectsField);

        // Użycie JavaScript do ustawienia wartości w polu tekstowym
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + partialText + "';", input);

        // Wywołanie zdarzenia input, aby symulować interakcję użytkownika
        js.executeScript("arguments[0].dispatchEvent(new Event('input'))", input);

//        // Czekaj aż lista sugestii się pojawi
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.attributeContains(input, "aria-expanded", "true"));

        // Wywołanie zdarzenia klawisza Enter
        js.executeScript("arguments[0].dispatchEvent(new KeyboardEvent('keydown', {key: 'Enter'}))", input);
    }
}
