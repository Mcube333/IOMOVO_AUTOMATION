package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

/**
 * Test class for verifying optimized file copy functionality from AWS to various drives.
 * Extends BaseClass for WebDriver setup and utility methods.
 * Supports cross-browser testing with 'browser' and 'os' parameters.
 * Uses TestNG groups "smoke" and "regression" for suite categorization.
 */
public class Optimised_AwsDriveCopyFunctionalityTest extends BaseClass {
	
    private LoginPage loginPage;
    private Optimised_AwsDriveCopyFunctionality awsCopyFunctionality; // Renamed for clarity
	
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
            throw new IllegalStateException("❌ WebDriver is null in Optimised_AwsDriveCopyFunctionalityTest. Check BaseClass initialization.");
        }

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        awsCopyFunctionality = new Optimised_AwsDriveCopyFunctionality(driver, getWait());

        performLogin(); // Login before each test
    }

    /**
     * Performs login before executing test cases.
     * Fails the test if login encounters an exception.
     */
    private void performLogin() {
        try {
            loginPage.loginMethod();
        } catch (Exception e) {
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }
	
    /**
     * Smoke Test: Verifies optimized file copy from AWS to IoCloud Drive.
     * Grouped as "smoke" and "regression" since it’s a core functionality.
     */
    @Test(groups = {"smoke", "regression"})
    public void verifyCopyFilesFunctionalityFromAWSToIoCloudDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
    }

    /**
     * Smoke Test: Verifies optimized file copy from AWS to AWS Drive (same-source copy).
     * Grouped as "smoke" and "regression" for critical functionality.
     */
    @Test(groups = {"smoke", "regression"})
    public void verifyCopyFilesFunctionalityFromAWSToAWSDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to Box Drive.
     * Grouped as "regression" only, as it’s a secondary drive.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToBoxDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to Dropbox Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to FTP Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToFTPDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to Google Cloud Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to Google Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to Azure Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToAzureDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to OneDrive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToOneDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToOneDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to SFTP Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
    }

    /**
     * Regression Test: Verifies optimized file copy from AWS to SharePoint Drive.
     * Grouped as "regression" only.
     */
    @Test(groups = {"regression"})
    public void verifyCopyFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
        awsCopyFunctionality.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
    }
}