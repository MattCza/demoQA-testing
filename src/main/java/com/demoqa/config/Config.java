package com.demoqa.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Test run settings from config.properties; a system property with the same key (-Dkey=value) takes precedence.
 */
public final class Config {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = load();

    private Config() {
    }

    public static String browser() {
        return get("browser").toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public static String baseUrl() {
        return get("baseUrl").replaceAll("/+$", "");
    }

    public static Duration timeout() {
        return Duration.ofSeconds(Long.parseLong(get("timeoutSeconds")));
    }

    private static String get(String key) {
        String value = System.getProperty(key, PROPERTIES.getProperty(key));
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing configuration value '" + key + "' in " + CONFIG_FILE);
        }
        return value.trim();
    }

    private static Properties load() {
        Properties properties = new Properties();
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new IllegalStateException(CONFIG_FILE + " not found on classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException("Cannot read " + CONFIG_FILE, e);
        }
        return properties;
    }

}
