package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.FtpDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class FTPToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private FtpDriveCopyFunctionality  FTP;
	
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
        FTP = new FtpDriveCopyFunctionality(driver, getWait());

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
    public void verifyCopyFilesFunctionalityFromFTPToIoCloudDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToAWSDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToBoxDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToBOXDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToDropBoxDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToFTPDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToGoogleCloudDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToGoogleDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToAzureDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToOneDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToSFTPDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromFTPToSharePointDrive() throws Exception {
        FTP.verifyCopyFilesFunctionalityFromFTPToSharePointDrive();
    }
}