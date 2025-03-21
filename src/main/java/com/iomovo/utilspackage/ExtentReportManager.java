package com.iomovo.utilspackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();
    private static final String REPORTS_FOLDER = System.getProperty("user.dir") + "/ExtentReports";
    private static final String SCREENSHOTS_FOLDER = System.getProperty("user.dir") + "/ScreenShots";

    private static String getCurrentDateTime() {
        return new SimpleDateFormat("ddMMMyyyy_HHmmss").format(new Date());
    }

    /**
     * Returns the singleton instance of ExtentReports.
     */
    public static synchronized ExtentReports getExtentReports() {
        if (extentReports == null) {
            File reportDir = new File(REPORTS_FOLDER);
            if (!reportDir.exists()) reportDir.mkdirs();

            String reportPath = REPORTS_FOLDER + "/ExtentReport_" + getCurrentDateTime() + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setEncoding("utf-8");
            sparkReporter.config().setReportName("Test Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Tester", "Mohammed Mudassir");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("User", "Automation Tester");
        }
        return extentReports;
    }

    /**
     * Starts a new ExtentTest for the given test name.
     */
    public static ExtentTest startTest(String testName, String desc) {
        ExtentTest test = getExtentReports().createTest(testName, desc);
        testThreadLocal.set(test);
        return test;
    }

    /**
     * Returns the current thread's ExtentTest instance.
     */
    public static ExtentTest getCurrentTest() {
        return testThreadLocal.get();
    }

    /**
     * Logs test status and captures a screenshot on failure.
     */
    public static void logTestStatus(WebDriver driver, boolean status, String testName) {
        ExtentTest test = getCurrentTest();
        if (test != null) {
            if (status) {
                test.log(Status.PASS, "✅ " + testName + " - Test Passed");
            } else {
                String screenshotPath = captureScreenshot(driver);
                test.log(Status.FAIL, "❌ " + testName + " - Test Failed");
                if (screenshotPath != null) {
                    test.addScreenCaptureFromPath(screenshotPath);
                }
            }
        } else {
            System.err.println("⚠️ Warning: No active ExtentTest found for logging.");
        }
    }

    /**
     * Logs a step in the current test.
     */
    public static void logStep(String stepDescription) {
        ExtentTest test = getCurrentTest();
        if (test != null) {
            test.log(Status.INFO, stepDescription);
        }
    }

    /**
     * Ends the current ExtentTest instance.
     */
    public static void endCurrentTest() {
        testThreadLocal.remove();
    }

    /**
     * Flushes the Extent Reports to disk.
     */
    public static void flushReports() {
        if (extentReports != null) {
            try {
                extentReports.flush();
            } catch (Exception e) {
                System.err.println("❌ Error flushing Extent Reports: " + e.getMessage());
            }
        }
    }

    /**
     * Captures a screenshot and returns the file path.
     */
    public static String captureScreenshot(WebDriver driver) {
        if (driver == null) {
            System.err.println("⚠️ WebDriver is null; skipping screenshot.");
            return null;
        }

        String screenshotPath = SCREENSHOTS_FOLDER + "/Screenshot_" + getCurrentDateTime() + ".png";
        File screenshotDir = new File(SCREENSHOTS_FOLDER);
        if (!screenshotDir.exists()) screenshotDir.mkdirs();

        try {
            if (driver instanceof TakesScreenshot) {
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFile, new File(screenshotPath));
                return screenshotPath;
            } else {
                System.err.println("⚠️ WebDriver does not support screenshots.");
                return null;
            }
        } catch (WebDriverException | IOException e) {
            System.err.println("❌ Error capturing screenshot: " + e.getMessage());
            return null;
        }
    }

    // ====== ITestListener Implementations ======

    @Override
    public void onStart(ITestContext context) {
        getExtentReports(); // Ensure reports are initialized at test start
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String desc = result.getMethod().getDescription() != null ? result.getMethod().getDescription() : "No description";
        startTest(testName, desc);
    }

    @Override
    public void onTestSuccess(ITestResult result) { }

    @Override
    public void onTestFailure(ITestResult result) { }

    @Override
    public void onTestSkipped(ITestResult result) { }

    @Override
    public void onFinish(ITestContext context) {
        flushReports(); // Flush reports at suite end
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
}
