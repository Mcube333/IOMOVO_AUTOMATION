package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.GoogleDriveMoveFunctionality;


public class GoogleDriveToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleDriveMoveFunctionality GoogleDrive;

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
        GoogleDrive = new GoogleDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromGoogleDriveToIoCloudDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToAWSDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToBOXDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToDropBoxDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToFTPDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToGoogleCloudDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToGoogleDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToAzureDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToOneDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToSFTPDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleDriveToSharePointDrive() throws Exception {
        GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToSharePointDrive();
    }
}