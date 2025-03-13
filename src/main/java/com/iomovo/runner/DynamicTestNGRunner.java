package com.iomovo.runner;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DynamicTestNGRunner {
    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("IoMoVo Test Suite");

        // Load properties
        Properties properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }

        // Read parallel execution values
        String parallelMode = properties.getProperty("parallel.mode", "none");
        int threadCount = Integer.parseInt(properties.getProperty("thread.count", "1"));

        // Set parallel execution dynamically
        suite.setParallel(XmlSuite.ParallelMode.valueOf(parallelMode.toUpperCase()));
        suite.setThreadCount(threadCount);

        testNG.setXmlSuites(Collections.singletonList(suite));
        testNG.run();
    }
}
