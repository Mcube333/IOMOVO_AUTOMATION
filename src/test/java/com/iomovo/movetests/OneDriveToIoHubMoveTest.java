package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.OneDriveMoveFunctionality;


public class OneDriveToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private OneDriveMoveFunctionality OneDrive;

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
        OneDrive = new OneDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromOneDriveToIoCloudDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToAWSDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToBOXDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToDropBoxDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToFTPDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToGoogleCloudDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToGoogleDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToAzureDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToOneDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToSFTPDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOneDriveToSharePointDrive() throws Exception {
        OneDrive.verifyMoveFilesFunctionalityFromOneDriveToSharePointDrive();
    }
}