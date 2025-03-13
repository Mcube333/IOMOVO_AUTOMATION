package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.GoogleCloudDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleCloudToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleCloudDriveCopyFunctionality  GoogleCloud;
	
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

        loginPage = new LoginPage(driver, getWait());
        GoogleCloud = new GoogleCloudDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromGoogleCloudToIoCloudDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToAWSDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToBoxDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToDropBoxDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToFTPDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToGoogleCloudDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToGoogleDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToAzureDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToOneDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToSFTPDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleCloudToSharePointDrive() throws Exception {
        GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToSharePointDrive();
    }
}