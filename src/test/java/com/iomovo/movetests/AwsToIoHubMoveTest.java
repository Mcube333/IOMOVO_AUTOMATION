package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.AwsDriveMoveFunctionality;


public class AwsToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private AwsDriveMoveFunctionality AWSS3;

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
        AWSS3 = new AwsDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromAWSToIoCloudDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAwsToAwsDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAwsToAwsDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToBOXDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToFTPDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToAzureDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToOneDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToOOSDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToOOSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
        AWSS3.verifyMoveFilesFunctionalityFromAWSToSharePointDrive();
    }
}
