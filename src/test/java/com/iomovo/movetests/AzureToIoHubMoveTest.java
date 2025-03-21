package com.iomovo.movetests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.AzureDriveMoveFunctionality;


public class AzureToIoHubMoveTest extends BaseClass {
	
	private WebDriver driver;
	private LoginPage loginPage;
    private AzureDriveMoveFunctionality  Azure;
	
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

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        Azure = new AzureDriveMoveFunctionality(driver, getWait());

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
    public void verifyMoveFilesFunctionalityFromAzureToIoCloudDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToIoCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToAWSDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToAWSDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToBOXDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToBOXDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToDropBoxDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToDropBoxDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToFTPDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToGoogleCloudDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToGoogleCloudDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToGoogleDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToGoogleDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToAzureDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToAzureDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToOneDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToOneDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToSFTPDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToSFTPDrive();
    }

    @Test
    public void verifyMoveFilesFunctionalityFromAzureToSharePointDrive() throws Exception {
        Azure.verifyMoveFilesFunctionalityFromAzureToSharePointDrive();
    }
}

