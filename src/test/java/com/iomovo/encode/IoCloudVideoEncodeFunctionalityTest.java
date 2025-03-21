package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.IoCloudVideoEncodeFunctionality;

public class IoCloudVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private IoCloudVideoEncodeFunctionality IoCloud;

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
        IoCloud = new IoCloudVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInIoCloudDrive() throws Exception {
        IoCloud.VerifyVideoEncodeFunctionalityto1080pinIoCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInIoCloudDrive() throws Exception {
        IoCloud.VerifyVideoEncodeFunctionalityto720pinIoCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInIoCloudDrive() throws Exception {
        IoCloud.VerifyVideoEncodeFunctionalityto480pinIoCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInIoCloudDrive() throws Exception {
        IoCloud.VerifyVideoEncodeFunctionalityto360pinIoCloudDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInIoCloudDrive() throws Exception {
        IoCloud.VerifyVideoEncodeFunctionalityto240pinIoCloudDrive();
    }
}