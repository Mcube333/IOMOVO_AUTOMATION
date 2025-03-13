package com.iomovo.utilspackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader:
 * - Reads configuration properties from the "config.properties" file.
 * - Provides a method to access loaded properties.
 */
public class ConfigReader {
    private Properties properties;

    /**
     * Constructor:
     * - Loads the "config.properties" file from the resources directory.
     * - Initializes a Properties object with key-value pairs.
     */
    public ConfigReader() {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("❌ Error loading configuration file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gets the loaded properties.
     *
     * @return Properties object containing key-value pairs from the config file.
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Retrieves a specific property value by key.
     *
     * @param key The property key.
     * @return The corresponding property value, or null if the key is not found.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
