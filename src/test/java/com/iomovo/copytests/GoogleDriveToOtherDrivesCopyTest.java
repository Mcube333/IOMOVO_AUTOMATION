package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.GoogleDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleDriveToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleDriveCopyFunctionality  GoogleDrive;
	
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
        GoogleDrive = new GoogleDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromGoogleDriveToIoCloudDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToAWSDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToBoxDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToDropBoxDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToFTPDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToGoogleCloudDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToGoogleDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToAzureDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToOneDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToSFTPDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromGoogleDriveToSharePointDrive() throws Exception {
        GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToSharePointDrive();
    }
}