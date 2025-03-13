package com.iomovo.movetests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.BoxDriveMoveFunctionality;


public class BoxToIoHubMoveTest extends BaseClass {
	
	private WebDriver driver;
	private LoginPage loginPage;
    private BoxDriveMoveFunctionality  Box;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
    	driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in HomePageTopPanelTest. Check BaseTestClass initialization.");
        }

        loginPage = new LoginPage(driver, getWait());
        Box = new BoxDriveMoveFunctionality(driver, getWait());

        performLogin(); // Login before each test
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
    public void verifyMoveFilesFunctionalityFromBoxToIoCloudDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToAWSDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToBOXDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToDropBoxDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToFTPDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToGoogleCloudDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToGoogleDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToAzureDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToOneDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToSFTPDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromBoxToSharePointDrive() throws Exception {
        Box.verifyMoveFilesFunctionalityFromBoxToSharePointDrive();
    }
}

