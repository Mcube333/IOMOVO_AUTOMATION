package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.DropBoxDriveMoveFunctionality;

public class DropBoxToIoHubMoveTest extends BaseClass {

    private LoginPage loginPage;
    private DropBoxDriveMoveFunctionality DropBox;

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
        DropBox = new DropBoxDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromDropBoxToIoCloudDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToAWSDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToBOXDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToDropBoxDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToFTPDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToGoogleCloudDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToGoogleDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToAzureDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToOneDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToSFTPDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromDropBoxToSharePointDrive() throws Exception {
        DropBox.verifyMoveFilesFunctionalityFromDropBoxToSharePointDrive();
    }
}
