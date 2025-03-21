package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.DropBoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class DropBoxToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private DropBoxDriveCopyFunctionality  DropBox;
	
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
        DropBox = new DropBoxDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromDropBoxToIoCloudDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToAWSDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToBoxDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToBOXDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToDropBoxDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToFTPDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToGoogleCloudDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToGoogleDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToAzureDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToOneDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToSFTPDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromDropBoxToSharePointDrive() throws Exception {
        DropBox.verifyCopyFilesFunctionalityFromDropBoxToSharePointDrive();
    }
}