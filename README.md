IN PROGRESS
# **Automated Testing of demoQA Website**



## Table of Contents
1. [Project Description](#project-description)
2. [Features](#features)
3. [Technologies and Tools Used](#technologies-and-tools-used)
4. [Project Structure](#project-structure)



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
│   │       └── com.demoqa.pages/  
│   └── test/  
│       └── java/  
│           └── com.demoqa.tests/  
├── pom.xml  
└── README.md  
```

src/main/java/com.demoqa.pages/: Contains Page Object Model (POM) classes for different pages of the demoQA website.  
  
src/test/java/com.demoqa.tests/: Contains the test classes.  
  
pom.xml: Maven configuration file listing dependencies and build settings.  
