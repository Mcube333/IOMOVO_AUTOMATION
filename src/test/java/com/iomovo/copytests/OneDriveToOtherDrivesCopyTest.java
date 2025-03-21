package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.OneDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OneDriveToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private OneDriveCopyFunctionality  OneDrive;
	
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
        OneDrive = new OneDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromOneDriveToIoCloudDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToAWSDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToBoxDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToDropBoxDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToFTPDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToGoogleCloudDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToGoogleDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToAzureDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToOneDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToSFTPDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOneDriveToSharePointDrive() throws Exception {
        OneDrive.verifyCopyFilesFunctionalityFromOneDriveToSharePointDrive();
    }
}
		
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			OneDriveCopyFunctionality OneDrive = new OneDriveCopyFunctionality(driver, wait);
//			OneDrive.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	

