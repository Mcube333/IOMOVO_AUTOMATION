package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.SftpDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SFTPToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private SftpDriveCopyFunctionality  SFTP;
	
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
        SFTP = new SftpDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromSFTPToIoCloudDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToAWSDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToBoxDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToDropBoxDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToFTPDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToGoogleCloudDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToGoogleDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToAzureDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToOneDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToSFTPDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromSFTPToSharePointDrive() throws Exception {
        SFTP.verifyCopyFilesFunctionalityFromSFTPToSharePointDrive();
    }
}
		
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			SFTPDriveCopyFunctionality SFTPDrive = new SFTPDriveCopyFunctionality(driver, wait);
//			SFTPDrive.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

