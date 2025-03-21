package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

/**
 * Test class for verifying file copy functionality from AWS to various drives.
 * Extends BaseClass for WebDriver setup and utility methods.
 * Supports cross-browser testing with 'browser' and 'os' parameters from BaseClass.
 * Uses TestNG groups "smoke" and "regression" for suite categorization.
 */
public class AwsToOtherDrivesCopyTest extends BaseClass {
	
    private LoginPage loginPage;
    private AwsDriveCopyFunctionality awsCopyFunctionality;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver via BaseClass using the specified browser and os, logs in, and sets up page objects.
     * @param browser The browser type (e.g., "chrome", "firefox", "edge"), defaults to "chrome" if not provided.
     * @param os The operating system (e.g., "windows"), defaults to "windows" if not provided.
     */
    @BeforeMethod
    @Parameters({"browser", "os"})
    public void setUp(@Optional("chrome") String browser, @Optional("windows") String os) {
        driver = getDriver(); // Retrieves the WebDriver set by BaseClass's @BeforeMethod
        
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in AwsToOtherDrivesCopyTest. Check BaseClass initialization.");
        }

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        awsCopyFunctionality = new AwsDriveCopyFunctionality(driver, getWait());

        performLogin(); // Login before each test
    }

    /**
     * Performs login before executing test cases.
     * Fails the test if login encounters an exception.
     */
    private void performLogin() {
        try {
            log.info("Attempting login with URL: " + strUrl + ", Username: " + strUsername);
            loginPage.loginMethod();
            log.info("Login successful");
        } catch (Exception e) {
            log.error("❌ Login failed. Exception: " + e.getMessage(), e);
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }
	
    @Test(groups = {"smoke", "regression"})
    public void verifyCopyFilesFunctionalityFromAWSToIoCloudDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyCopyFilesFunctionalityFromAWSToAWSDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToBoxDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToFTPDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToAzureDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToOneDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToOneDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToOOSDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToOOSDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
    }

    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
    }
}