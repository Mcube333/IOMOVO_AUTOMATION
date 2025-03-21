package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.SharePointCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SharePointToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private SharePointCopyFunctionality SharePoint;
	
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
        SharePoint = new SharePointCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromSharePointToIoCloudDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToAWSDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToBoxDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToDropBoxDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToFTPDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToGoogleCloudDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToGoogleDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToAzureDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToOneDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToSFTPDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSharePointToSharePointDrive() throws Exception {
        SharePoint.verifyCopyFilesFunctionalityFromSharePointToSharePointDrive();
    }
}
		
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			SharePointCopyFunctionality SharePoint = new SharePointCopyFunctionality(driver, wait);
//			SharePoint.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

