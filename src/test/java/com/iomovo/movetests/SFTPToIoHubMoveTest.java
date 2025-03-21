package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.SftpDriveMoveFunctionality;


public class SFTPToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private SftpDriveMoveFunctionality SFTP;

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
        SFTP = new SftpDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromSFTPToIoCloudDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToAWSDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToBOXDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToDropBoxDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToFTPDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToGoogleCloudDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToGoogleDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToAzureDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToOneDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToSFTPDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSFTPToSharePointDrive() throws Exception {
        SFTP.verifyMoveFilesFunctionalityFromSFTPToSharePointDrive();
    }
}