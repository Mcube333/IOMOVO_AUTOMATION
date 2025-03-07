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

import com.iomovo.basepackage.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass extends BaseClass {
    private static ExtentReports extentReports;
    private static ExtentTest extLog;
    private static final String REPORTS_FOLDER = System.getProperty("user.dir") + "/ExtentReports";
    private static final String SCREENSHOTS_FOLDER = System.getProperty("user.dir") + "/ScreenShots";

    // Method to get current timestamp
    private String getCurrentDateTime() {
        return new SimpleDateFormat("ddMMMyyyy_HHmmss").format(new Date());
    }

    public ExtentTest startReport(String testName) {
        // Ensure the ExtentReports folder exists
        File reportDir = new File(REPORTS_FOLDER);
        if (!reportDir.exists() && reportDir.mkdirs()) {
            System.out.println("Created ExtentReports directory: " + REPORTS_FOLDER);
        }

        // Generate report file path
        String reportPath = REPORTS_FOLDER + "/ExtentReport_IomovoApp_" + getCurrentDateTime() + ".html";
        System.out.println("Saving Extent Report at: " + reportPath);
        
        // Initialize ExtentReports
        extentReports = new ExtentReports(reportPath, true);

        // Load Extent Report Config XML (if exists)
        File configFile = new File(System.getProperty("user.dir") + "/PropertyFiles/extent-config.xml");
        if (configFile.exists()) {
            extentReports.loadConfig(configFile);
        } else {
            System.out.println("Warning: extent-config.xml not found at " + configFile.getAbsolutePath());
        }

        // Set system information
        extentReports.addSystemInfo("Environment", "QA");
        extentReports.addSystemInfo("User Name", "Mohammed Mudassir");

        extLog = extentReports.startTest(testName);
        return extLog;
    }

    public void endReport() {
        if (extentReports != null) {
            extentReports.endTest(extLog);
            extentReports.flush();
            extentReports.close();
            System.out.println("✅ Extent Report successfully flushed and saved.");
        } else {
            System.out.println("❌ Error: ExtentReports instance is NULL, report was not created.");
        }
    }

    /**
     * Logs test status (Pass/Fail) and captures a screenshot if failed.
     * @param driver WebDriver instance
     * @param status true if test passed, false if failed
     * @param testName Name of the test case
     */
    public void logTestStatus(WebDriver driver, boolean status, String testName) {
        if (status) {
            extLog.log(LogStatus.PASS, testName + " - Passed ✅");
        } else {
            String screenshotPath = capture(driver);
            extLog.log(LogStatus.FAIL, testName + " - Failed ❌");
            if (screenshotPath != null) {
                extLog.log(LogStatus.INFO, "Screenshot: " + extLog.addScreenCapture(screenshotPath));
            }
        }
    }

    /**
     * Captures screenshot and returns the file path.
     * @param driver WebDriver instance
     * @return Screenshot file path
     */
    public String capture(WebDriver driver) {
        String screenshotPath = null;

        // Ensure Screenshots folder exists
        File screenshotDir = new File(SCREENSHOTS_FOLDER);
        if (!screenshotDir.exists() && screenshotDir.mkdirs()) {
            System.out.println("Created Screenshots directory: " + SCREENSHOTS_FOLDER);
        }

        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenshotPath = SCREENSHOTS_FOLDER + "/Screenshot_" + getCurrentDateTime() + ".png";
            File Dest = new File(screenshotPath);
            FileUtils.copyFile(scrFile, Dest);
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (WebDriverException | IOException e) {
            System.err.println("Error capturing screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
