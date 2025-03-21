package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.GoogleCloudDriveMoveFunctionality;


public class GoogleCloudToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleCloudDriveMoveFunctionality GoogleCloud;

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
        GoogleCloud = new GoogleCloudDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromGoogleCloudToIoCloudDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToAWSDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToBOXDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToDropBoxDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToFTPDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToGoogleCloudDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToGoogleDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToAzureDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToOneDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToSFTPDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromGoogleCloudToSharePointDrive() throws Exception {
        GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToSharePointDrive();
    }
}