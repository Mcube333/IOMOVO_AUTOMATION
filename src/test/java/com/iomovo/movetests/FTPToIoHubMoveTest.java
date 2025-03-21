package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.FtpDriveMoveFunctionality;


public class FTPToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private FtpDriveMoveFunctionality FTP;

    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
        driver = getDriver(); // ✅ Use inherited WebDriver from BaseClass
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in DropBoxToIoHubMoveTest. Check BaseClass initialization.");
        }

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        FTP = new FtpDriveMoveFunctionality(driver, getWait());

        performLogin(); // ✅ Ensures user is logged in before each test
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
    public void verifyMoveFilesFunctionalityFromFTPToIoCloudDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToAWSDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToBOXDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToDropBoxDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToFTPDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToGoogleCloudDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToGoogleDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToAzureDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToOneDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToSFTPDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromFTPToSharePointDrive() throws Exception {
        FTP.verifyMoveFilesFunctionalityFromFTPToSharePointDrive();
    }
}
