package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.AzureDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AzureToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private AzureDriveCopyFunctionality  Azure;
	
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
        Azure = new AzureDriveCopyFunctionality(driver, getWait());

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

	//These Below Methods are for Login Functionality tests

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToIoCloudDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToAWSDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToBoxDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToDropBoxDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToFTPDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToGoogleDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToAzureDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToOneDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToSFTPDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAzureToSharePointDrive() throws Exception {
        Azure.verifyCopyFilesFunctionalityFromAzureToSharePointDrive();
    }
}