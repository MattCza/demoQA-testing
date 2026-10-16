package com.demoqa.driver;

import com.demoqa.config.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DriverFactory {

    private static final Logger LOG = LoggerFactory.getLogger(DriverFactory.class);

    // Headless browsers have no screen to maximise to, so they get a fixed desktop-sized window.
    private static final Dimension HEADLESS_WINDOW_SIZE = new Dimension(1920, 1080);

    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        boolean headless = Config.headless();
        LOG.info("Starting {} (headless: {})", Config.browser(), headless);
        WebDriver driver = switch (Config.browser()) {
            case "firefox" -> createFirefox(headless);
            case "chrome" -> createChrome(headless);
            default -> throw new IllegalArgumentException(
                    "Unsupported browser '" + Config.browser() + "'; supported: firefox, chrome");
        };

        if (headless) {
            driver.manage().window().setSize(HEADLESS_WINDOW_SIZE);
        } else {
            driver.manage().window().maximize();
        }
        return driver;
    }

    private static WebDriver createFirefox(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createChrome(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }

}
