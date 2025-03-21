package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_BoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_BoxToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private Optimised_BoxDriveCopyFunctionality  OBox;
	
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
        OBox = new Optimised_BoxDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromBoxToIoCloudDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToAWSDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToBoxDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToDropBoxDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToFTPDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToGoogleCloudDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToGoogleDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToAzureDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToOneDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToOOSDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToOOSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToSharePointDrive() throws Exception {
        OBox.verifyCopyFilesFunctionalityFromBoxToSharePointDrive();
    }
}