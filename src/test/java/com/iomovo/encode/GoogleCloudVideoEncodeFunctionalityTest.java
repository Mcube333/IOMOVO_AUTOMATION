package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.GoogleCloudVideoEncodeFunctionality;

public class GoogleCloudVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleCloudVideoEncodeFunctionality GoogleCloud;

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
        GoogleCloud = new GoogleCloudVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInGoogleCloudDrive() throws Exception {
        GoogleCloud.VerifyVideoEncodeFunctionalityto1080pinGoogleCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInGoogleCloudDrive() throws Exception {
        GoogleCloud.VerifyVideoEncodeFunctionalityto720pinGoogleCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInGoogleCloudDrive() throws Exception {
        GoogleCloud.VerifyVideoEncodeFunctionalityto480pinGoogleCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInGoogleCloudDrive() throws Exception {
        GoogleCloud.VerifyVideoEncodeFunctionalityto360pinGoogleCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInGoogleCloudDrive() throws Exception {
        GoogleCloud.VerifyVideoEncodeFunctionalityto240pinGoogleCloudDrive();
    }
}
