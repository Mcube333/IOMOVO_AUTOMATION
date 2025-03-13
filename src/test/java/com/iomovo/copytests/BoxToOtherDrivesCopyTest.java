package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.BoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class BoxToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private BoxDriveCopyFunctionality Box;
	
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
        Box = new BoxDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromBoxToIoCloudDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToAWSDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToBoxDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToBOXDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToDropBoxDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToFTPDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToGoogleCloudDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToGoogleDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToAzureDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToOneDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToSFTPDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromBoxToSharePointDrive() throws Exception {
        Box.verifyCopyFilesFunctionalityFromBOXToSharePointDrive();
    }
}