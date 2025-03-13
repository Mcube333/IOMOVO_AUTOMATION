package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.SharePointDriveMoveFunctionality;


public class SharePointToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private SharePointDriveMoveFunctionality SharePoint;

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

        loginPage = new LoginPage(driver, getWait());
        SharePoint = new SharePointDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromSharePointToIoCloudDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToAWSDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToBOXDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToDropBoxDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToFTPDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToGoogleCloudDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToGoogleDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToAzureDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToOneDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToSFTPDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromSharePointToSharePointDrive() throws Exception {
        SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToSharePointDrive();
    }
}