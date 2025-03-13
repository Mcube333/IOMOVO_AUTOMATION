package com.iomovo.utilspackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    private static Map<Long, ExtentTest> testMap = new HashMap<>();
    private static final String REPORTS_FOLDER = System.getProperty("user.dir") + "/ExtentReports";
    private static final String SCREENSHOTS_FOLDER = System.getProperty("user.dir") + "/ScreenShots";

    private static String getCurrentDateTime() {
        return new SimpleDateFormat("ddMMMyyyy_HHmmss").format(new Date());
    }

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            File reportDir = new File(REPORTS_FOLDER);
            if (!reportDir.exists()) reportDir.mkdirs();
            
            String reportPath = REPORTS_FOLDER + "/ExtentReport_" + getCurrentDateTime() + ".html";
            extentReports = new ExtentReports(reportPath, true);
            
            File config = new File(System.getProperty("user.dir") + "/PropertyFiles/extent-config.xml");
            if (config.exists()) extentReports.loadConfig(config);
            
            extentReports.addSystemInfo("Environment", "QA")
                         .addSystemInfo("User", "Automation Tester");
        }
        return extentReports;
    }

    public static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getExtentReports().startTest(testName, desc);
        testMap.put(Thread.currentThread().getId(), test); // ✅ Store test instance in thread-local storage
        return test; // ✅ Return the created test instance
    }

    public static ExtentTest getCurrentTest() {
        ExtentTest test = testMap.get(Thread.currentThread().getId());
        if (test == null) {
            System.err.println("❌ Warning: No active ExtentTest found for thread: " + Thread.currentThread().getId());
        }
        return test;
    }

    public static void logTestStatus(WebDriver driver, boolean status, String testName) {
        ExtentTest test = getCurrentTest(); // ✅ Get active test instance

        if (test != null) {
            if (status) {
                test.log(LogStatus.PASS, testName + " - ✅ Test Passed"); // ✅ Ensure passed tests are logged
            } else {
                String screenshotPath = captureScreenshot(driver);
                test.log(LogStatus.FAIL, testName + " - ❌ Test Failed");

                if (screenshotPath != null) {
                    test.log(LogStatus.INFO, "📸 Screenshot: " + test.addScreenCapture(screenshotPath));
                }
            }
            endCurrentTest(); // ✅ Ensure test is marked as completed
        } else {
            System.err.println("⚠️ Warning: No active ExtentTest found for logging.");
        }
    }


    public static void endCurrentTest() {
        ExtentTest test = getCurrentTest();
        if (test != null) {
            getExtentReports().endTest(test); // ✅ Ensure test results are stored
        }
    }

    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush(); // ✅ Writes test results to the report
        }
    }

    public static String captureScreenshot(WebDriver driver) {
        String screenshotPath = SCREENSHOTS_FOLDER + "/Screenshot_" + getCurrentDateTime() + ".png";
        File screenshotDir = new File(SCREENSHOTS_FOLDER);
        if (!screenshotDir.exists()) screenshotDir.mkdirs();

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotPath));
            return screenshotPath;
        } catch (WebDriverException | IOException e) {
            System.err.println("❌ Error capturing screenshot: " + e.getMessage());
        }
        return null;
    }

}
