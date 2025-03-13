package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.IoCloudDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

public class IoCloudToIoHubCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private IoCloudDriveCopyFunctionality  IoCloud;
	
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
        IoCloud = new IoCloudDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionFromIoCloudToIoCloudDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionalityFromIoCloudToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToAwsDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionalityFromIoCloudToAwsDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToBoxDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToDropbox() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToDropbox();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToFTPDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToGoogleCloudDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToGoogleDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToAzureDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToOneDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToSFTPDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionFromIoCloudToSharepointDrive() throws Exception {
        IoCloud.verifyCopyFilesFunctionFromIoCloudToSharepointDrive();
    }
}
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			IoCloudDriveCopyFunctionality ioCloud = new IoCloudDriveCopyFunctionality(driver, wait);
//			ioCloud.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
