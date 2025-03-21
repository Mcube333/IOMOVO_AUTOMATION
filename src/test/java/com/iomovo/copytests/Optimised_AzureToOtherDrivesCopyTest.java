package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_AzureDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_AzureToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private Optimised_AzureDriveCopyFunctionality OAzure;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
    	driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in HomePageTopPanelTest. Check BaseTestClass initialization.");
        }

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        OAzure = new Optimised_AzureDriveCopyFunctionality(driver, getWait());

        performLogin(); // Login before each test
    }

    /**
     * Perform login before executing test cases.
     */
    private void performLogin() {
        try {
            loginPage.loginMethod();
        } catch (Exception e) {
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }
	
    @Test
    public void verifyCopyFilesFunctionalityFromAzureToIoCloudDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToAWSDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToBoxDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToDropBoxDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToFTPDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToGoogleDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToAzureDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToOneDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToOOSDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToOOSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToSFTPDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToSharePointDrive() throws Exception {
        OAzure.verifyCopyFilesFunctionalityFromAzureToSharePointDrive();
    }
}
