package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.IoCloudDriveMoveFunctionality;


public class IoCloudToIoHubMoveTest extends BaseClass{
	
	private LoginPage loginPage;
    private IoCloudDriveMoveFunctionality IoCloud;

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
        IoCloud = new IoCloudDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromIoCloudToIoCloudDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToAwsDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToAwsDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToBoxDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToDropbox() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToDropbox();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToFTPDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToGoogleCloudDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToGoogleDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToAzureDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToOneDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToSFTPDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromIoCloudToSharepointDrive() throws Exception {
        IoCloud.verifyMoveFilesFunctionalityFromIoCloudToSharepointDrive();
    }
}