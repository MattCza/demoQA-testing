# Automated Testing of demoQA Website

UI test automation framework for [demoqa.com](https://demoqa.com) built with **Java, Selenium WebDriver and TestNG**.
The suite covers form handling, dynamic elements, tables, links and site navigation, and is designed to run
reliably in sequence or in parallel, with a visible or headless browser.

## Table of Contents
1. [Tech Stack](#tech-stack)
2. [Running the Tests](#running-the-tests)
3. [Configuration](#configuration)
4. [Framework Design](#framework-design)
5. [Project Structure](#project-structure)
6. [Test Coverage](#test-coverage)
7. [Failure Diagnostics](#failure-diagnostics)
8. [Known Issues](#known-issues)
9. [Upcoming Work](#upcoming-work)

## Tech Stack

| Tool | Purpose |
|------|---------|
| Java 21 | Language |
| Selenium WebDriver 4 | Browser automation; Selenium Manager downloads the matching browser driver |
| TestNG 7 | Test runner, data providers, listeners, parallel execution |
| Maven | Build and dependency management |
| SLF4J + Logback | Logging (with thread names, useful for parallel runs) |

## Running the Tests

Prerequisites: JDK 21, Maven 3.9+, Firefox or Chrome.

```bash
mvn test                                        # whole suite (testng.xml), Firefox with a visible window
mvn test -Dheadless=true                        # no browser window, e.g. for CI
mvn test -Dbrowser=chrome -Dheadless=true       # Chrome instead of Firefox
mvn test -Dtest=LinksTest                       # a single test class
```

In IntelliJ IDEA you can also right-click `testng.xml` → **Run**.

## Configuration

Defaults live in [`src/main/resources/config.properties`](src/main/resources/config.properties).
Any value can be overridden with a system property of the same name (`-Dkey=value`), so the suite can run
in a different environment without code changes.

| Key | Default | Description |
|-----|---------|-------------|
| `browser` | `firefox` | `firefox` or `chrome` |
| `headless` | `false` | Run without a visible browser window (window size fixed at 1920×1080) |
| `baseUrl` | `https://demoqa.com` | Application under test |
| `timeoutSeconds` | `10` | Explicit wait timeout used by page objects |

## Framework Design

- **Page Object Model** – each page encapsulates its locators (`private By`) and exposes user-level actions.
  Tests contain no locators or Selenium calls.
- **Driver lifecycle** – `DriverFactory` creates the browser from configuration; `DriverManager` keeps one
  `WebDriver` per thread (`ThreadLocal`), so test classes can run in parallel without sharing a browser.
  The driver is passed to page objects through their constructors – there is no static driver.
- **Synchronisation** – `BasePage` wraps every interaction in an explicit wait (presence, visibility or
  clickability). There are no `Thread.sleep` calls; asynchronous UI changes (e.g. API link responses,
  new tabs, delayed buttons) are awaited on their actual condition.
- **Independent tests** – every test opens its page directly by URL (`new TextBoxPage(driver()).open()`) and
  works on its own data, so tests can run in any order. UI navigation (home cards, side menu) is covered
  separately by `NavigationTest`.
- **Data-driven tests** – TestNG data providers for API link responses, navigation targets and form input.
- **Diagnostics** – a TestNG listener logs every test and captures evidence on failure (see below).

## Project Structure

```
demoQA-testing/
├── pom.xml
├── testng.xml                        # suite: Navigation, Elements, Forms
└── src/
    ├── main/
    │   ├── java/com/demoqa/
    │   │   ├── base/BasePage.java    # driver, explicit waits, common actions
    │   │   ├── config/Config.java    # config.properties + -D overrides
    │   │   ├── driver/               # DriverFactory, DriverManager (ThreadLocal)
    │   │   └── pages/                # page objects grouped like the site sections
    │   └── resources/config.properties
    └── test/
        ├── java/com/demoqa/
        │   ├── base/BaseTest.java    # browser per test class, listener registration
        │   ├── listeners/TestListener.java
        │   └── tests/                # elements/, forms/, navigation/
        └── resources/                # logback-test.xml, upload test file
```

## Test Coverage

35 test cases in 8 classes:

| Area | Test class | Scenarios |
|------|------------|-----------|
| Navigation | `NavigationTest` | Every home card and Elements/Forms menu item opens the right page (13 cases) |
| Text Box | `TextBoxTest` | Submitted data is shown in the output, incl. Polish characters (2 data sets) |
| Check Box | `CheckBoxTest` | Selected items are listed in the result; selecting a folder selects its children and marks the parent as partially checked |
| Web Tables | `WebTablesTest` | Add a record (all columns verified), delete a record, edit a salary – each on its own record |
| Buttons | `ButtonsTest` | Double, right and single click each show their message; a single click is not treated as a double or right click |
| Links | `LinksTest` | Simple link opens the home page in a new tab; all 7 API links report the correct status code and text |
| Dynamic Properties | `DynamicPropertiesTest` | Delayed button becomes visible; disabled button becomes enabled |
| Practice Form | `PracticeFormTest` | Complete form submission (text fields, radio, date picker, hobbies, file upload, state/city) verified in the confirmation modal |

## Failure Diagnostics

When a test fails, `TestListener` saves to `target/failure-artifacts/`:
- a screenshot (`<TestClass>.<method>_<timestamp>.png`),
- the page source (`.html`),

and logs the URL at the moment of failure. Links to both files are added to the TestNG report
(`target/surefire-reports/emailable-report.html`).

Every test start, pass, failure and skip is logged with its duration and thread name.

## Known Issues

- **demoqa.com defect:** the *Close* button of the Practice Form confirmation modal does not close it
  (Escape does). `PracticeFormTest` closes the modal with Escape; the defect itself is documented in
  `PracticeFormPage.clickCloseLargeModalButton()`.
- demoqa.com shows third-party ads that change between page loads and can appear in screenshots.
- With a Chrome version newer than the Selenium release, Selenium logs a CDP version warning. It does not
  affect the tests, which do not use Chrome DevTools.

## Upcoming Work

- CI pipeline (GitHub Actions) running the suite headless and publishing reports and failure artifacts
- API tests for the demoqa Book Store API with REST Assured (authentication, authorisation, validation errors)
- Negative UI tests (form validation)
- End-to-end scenarios combining API setup with UI verification
- Test groups (smoke/regression) and parallel execution as the default
