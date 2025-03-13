package com.iomovo.movetests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.OOSDriveMoveFunctionality;


public class OosDriveToIoHubMoveTest extends BaseClass {
	
	private LoginPage loginPage;
    private OOSDriveMoveFunctionality Oracle;

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
        Oracle = new OOSDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromOosToIoCloudDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToAwsDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToAwsDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToBoxDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToDropBoxDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToFTPDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToGoogleCloudDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToGoogleDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToMSAzureDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToMSAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToOneDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToSftpDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToSftpDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromOosToSharePointDrive() throws Exception {
        Oracle.verifyMoveFilesFunctionalityFromOosToSharePointDrive();
    }
}