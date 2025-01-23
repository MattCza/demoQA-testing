TO DO:  
clean up and refactor related code for improved readability and maintainability.  
# **Automated Testing of demoQA Website**



## Table of Contents
1. [Project Description](#project-description)
2. [Features](#features)
3. [Technologies and Tools Used](#technologies-and-tools-used)
4. [Project Structure](#project-structure)
5. [Test Cases](#test-cases)
   - [TextBox Test](#textbox-test)
   - [CheckBox Test](#checkbox-test)
   - [Dynamic Properties Test ](#dynamic-properties-test)
   - [WebTables Test](#webtables-test)
   - [Buttons Test](#buttons-test)
   - [Links Test](#Links-test)
   - [Practice Form Test](#Practice-Form-test)

  
## **Project Description**
This project focuses on automating the testing of the demoQA website using **Selenium** with **Java**.    
The goal is to ensure that various features of the website function correctly, providing a robust test suite that can be run regularly to catch any issues or regressions.   
The project leverages Selenium WebDriver and other testing tools to create and execute automated tests.   
  
Through this project, I aim to:
- **Learn and practice writing effective automated tests** using Selenium WebDriver.
- **Improve my skills in crafting locators** for element identification.
- **Gain hands-on experience with Java** and related testing frameworks.
- **Explore additional tools and technologies** required for successful test automation.



## Features

This project covers the following key areas of the demoQA website:

- **Form Testing**: Validating form submissions with different sets of data.
- **Button Click Testing**: Ensuring all buttons function as expected.
- **Data Validation**: Testing input fields and error messages for invalid data.
- **Dynamic Elements**: Verifying the behavior of elements that change dynamically based on user interaction.



## Technologies and Tools Used

The following technologies and tools are used in this project:  
1. **Java**: &nbsp;The main programming language for writing test scripts.
2. **Selenium WebDriver**: &nbsp;A tool for automating web browser interactions.
3. **TestNG**: &nbsp;A testing framework to structure, run, and report tests.
4. **Maven**: &nbsp;A build and dependency management tool.
5. **JUnit**: &nbsp;A framework for writing and running repeatable automated tests.
6. **WebDriverManager**: &nbsp;For managing browser drivers (like ChromeDriver) easily.
7. **IntelliJ IDEA**: &nbsp;The integrated development environment (IDE) used for writing and debugging code.



## Project Structure

Here's an overview of the project's structure:

```
demoQA-testing/
├── src/  
│   ├── main/  
│   │   └── java/
│   │       └── com.demoqa.base/  
│   │       └── com.demoqa.pages/  
│   │       └── com.demoqa.utility/  
│   └── test/  
│       └── java/  
│           └── com.demoqa.base/
│           └── com.demoqa.tests/  
├── pom.xml  
└── README.md  
```

src/main/java/com.demoqa.base/:  
define common methods and properties used across the project.  

src/main/java/com.demoqa.utility/:  
Includes helper classes and utilities.  

src/main/java/com.demoqa.pages/:  
Contains Page Object Model (POM) classes for different pages of the demoQA website.  
  
src/test/java/com.demoqa.tests/:  
Contains actual test classes that define test cases for various functionalities of the demoQA website.  
  
pom.xml:  
Maven configuration file listing dependencies and build settings.  



## Test Cases

This section highlights the automated test cases implemented for the demoQA website.  
Each test case is designed to verify specific functionalities of the web application, ensuring reliability and correctness.

### 1. TextBox Test  
  
**Objective:**  
Verify that the TextBox component on the demoQA website accurately displays the user input after form submission.

**Steps Covered:**
- Navigate to the Elements section
- Select the TextBox option
- Fill in the following fields:
  - Full Name
  - Email
  - Current Address
  - Permanent Address
- Submit the form
- Validate that the displayed output matches the input provided

**Assertions:**
- The full name displayed matches the entered full name.
- The email displayed matches the entered email.
- The current address displayed matches the entered current address.
- The permanent address displayed matches the entered permanent address.

**Test Result:**  
✔️ **Pass** – The TextBox component correctly handled and displayed user input.  

---  
  
### 2. CheckBox Test  
  
**Objective:**  
Verify that the Checkbox component on the demoQA website allows users to select multiple items and accurately reflects the selections.  
  
  
**Steps Covered:**  
- Navigate to the Elements section.  
- Select the CheckBox option.  
- Expand all checkbox items.  
- Select the following items:  
  - Public  
  - Excel File  
- Validate the selection state of the checkboxes.  

  
**Assertions:**  
- The "Excel File" checkbox is selected.  
- The "Word File" checkbox is not selected.  

  
**Test Result:**  
✔️ Pass – The Checkbox component correctly handled the selection and displayed the selected items as expected.  
Console should display the list of selected items:  
```Selected items: [public, excelFile]" ```  

---  

### 3. Dynamic Properties Test  
  
**Objective:**  
Verify the behavior of a dynamic element on the Dynamic Properties Page, specifically ensuring that the "Visible After" button becomes visible after a defined delay and validating its text content.

  
**Steps Covered:**  
- Navigate to the Dynamic Properties Page via the "Elements" card.
- Wait explicitly until the "Visible After" button becomes visible (5 seconds).
- Retrieve and print the text of the button after it appears.
- Validate that the retrieved text matches the expected value: "Visible After 5 Seconds".

  
**Assertions:**  
- The retrieved text of the "Visible After" button (actualText) is compared with the expected value (expectedText):
  - Expected Text: "Visible After 5 Seconds"
  - If the values do not match, an assertion error is thrown with a descriptive message.

**Test Result:**  
The test confirms the successful behavior of the dynamic element, verifying that:  
✔️ Pass – The button becomes visible after the expected delay.
✔️ Pass – The button text matches the expected value.  
  
---  

### 4. WebTables Test  
  
**Objective:**  
Verify the functionality of adding, editing, and deleting records in the WebTables section of the demoQA application.

  
**Steps Covered:**  
- Navigate to the Elements section.
- Click on the Web Tables option.
- Add a new employee record with the following details:
  - Name: Matt Smith
  - Email: ms@gmail.com
  - Age: 27
  - Salary: 10000
  - Department: Technology
- Verify that the new employee record appears in the table.
- Delete the added record.
- Edit the salary of an existing employee (Kierra).
- Submit the changes and validate the updated salary.

  
**Assertions:**  
- The newly added record is present in the table.
- The edited employee’s salary is updated correctly in the table.

**Test Result:**  
✔️ Pass – The Web Tables functionality correctly handles adding, editing, and deleting employee records.
  
---  
  
### 5. Buttons Test  
  
**Objective:**  
Verify that the Buttons component on the demoQA website responds correctly to different user interactions, such as double-click, right-click, and a single dynamic click.
  
  
**Steps Covered:**  
- Navigate to the Elements section.
- Select the Buttons option.
- Perform the following interactions:
  - Double-click the "Double Click Me" button.
  - Right-click the "Right Click Me" button.
  - Single-click the "Click Me" button.
- Validate that each button interaction is correctly handled and processed by the application.

  
**Assertions:**  
- Verify that the "Click Me" button responds correctly to a dynamic click.
- Verify that the "Double Click Me" button is properly clicked and recognized.
- Verify that the "Right Click Me" button is properly clicked and recognized.

**Test Result:**  
✔️ Pass – All button interactions were handled correctly, and the expected actions were verified.
  
---  
  
### 6. Links Test  
  
**Objective:**  
Verify that the Links component on the demoQA website correctly handles link interactions, including navigating to external links and responding to specific HTTP status codes.

  
**Steps Covered:**  
- Navigate to the Elements section.
- Select the Links option.
- Perform the following actions:
  - Click on the "Simple Link" and validate that a new tab is opened.
  - Close the newly opened tab and return to the main test window.
  - Click on the "Moved Permanently" link and validate the response message.
  - Click on the "Forbidden" link and validate the response message.

  
**Assertions:**  
- Verify that the "Simple Link" opens a new tab successfully.
- Verify that the "Moved Permanently" link returns a response containing "301" and "Moved Permanently."
- Verify that the "Forbidden" link returns a response containing "403" and "Forbidden."

**Test Result:**  
✔️ Pass – All link interactions and HTTP status code validations were successfully handled.  
  
---  
  
### 7. Practice Form Test  
  
**Objective:**  
Validate that the Practice Form on the demoQA website is correctly filled out and submitted, ensuring that all fields accept input and handle user interactions properly.

  
**Steps Covered:**  
- Navigate to the Forms section.
- Open the Practice Form.
- Populate the following fields with valid data:
  - First Name
  - Last Name
  - Email
  - Mobile Number
  - Date of Birth
  - Current Address
  - Select State and City from dropdowns
- Perform the following interactions:
  - Select gender radio button.
  - Select multiple hobbies by checking the corresponding checkboxes.
  - Upload a picture file to the form.
- Submit the form.
- Close the submission confirmation modal.
  
**Key Actions:**  
- Automated input into text fields.
- Interacted with dropdowns and radio buttons using Selenium utilities.
- Dynamically selected the correct date from a date picker.
- Verified smooth scrolling and JavaScript-based interactions for hobbies checkboxes and other elements.

  
**Test Result:**  
✔️ Pass – The Practice Form was successfully completed, submitted, and verified.
