package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.OosDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OosToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private OosDriveCopyFunctionality  Oracle;
	
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
        Oracle = new OosDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromOosToIoCloudDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToAwsDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToAwsDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToBoxDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToDropBoxDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToFTPDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToGoogleCloudDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToGoogleDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToMSAzureDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToMSAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToOneDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToSftpDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToSftpDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromOosToSharePointDrive() throws Exception {
        Oracle.verifyCopyFilesFunctionalityFromOosToSharePointDrive();
    }
}
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.loginMethod();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
