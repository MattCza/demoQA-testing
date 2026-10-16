package com.demoqa.listeners;

import com.demoqa.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Logs test and on failure saves a ss, page and the URL to target/failure-artifacts and links them in the TestNG report.
public class TestListener implements ITestListener {

    private static final Logger LOG = LoggerFactory.getLogger(TestListener.class);
    private static final Path ARTIFACTS_DIR = Paths.get("target", "failure-artifacts");
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS");

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("START {}", testName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("PASS  {} ({} ms)", testName(result), duration(result));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.warn("SKIP  {}", testName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.error("FAIL  {} ({} ms): {}", testName(result), duration(result), result.getThrowable().toString());

        if (DriverManager.hasDriver()) {
            saveDiagnostics(DriverManager.getDriver(), result);
        }
    }

    private void saveDiagnostics(WebDriver driver, ITestResult result) {
        String baseName = testName(result) + "_" + LocalDateTime.now().format(TIMESTAMP);
        try {
            Files.createDirectories(ARTIFACTS_DIR);
            LOG.error("      URL at failure: {}", driver.getCurrentUrl());

            Path screenshot = ARTIFACTS_DIR.resolve(baseName + ".png");
            Files.write(screenshot, ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));

            Path pageSource = ARTIFACTS_DIR.resolve(baseName + ".html");
            Files.writeString(pageSource, driver.getPageSource(), StandardCharsets.UTF_8);

            LOG.error("      Screenshot: {}", screenshot.toAbsolutePath());
            LOG.error("      Page source: {}", pageSource.toAbsolutePath());
            Reporter.setCurrentTestResult(result);
            Reporter.log("URL at failure: " + driver.getCurrentUrl());
            Reporter.log("<a href='" + screenshot.toUri() + "'>Screenshot</a> | "
                    + "<a href='" + pageSource.toUri() + "'>Page source</a>");
        } catch (IOException | RuntimeException e) {
            LOG.warn("Could not save failure diagnostics for {}", testName(result), e);
        }
    }

    private static String testName(ITestResult result) {
        return result.getTestClass().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();
    }

    private static long duration(ITestResult result) {
        return result.getEndMillis() - result.getStartMillis();
    }

}