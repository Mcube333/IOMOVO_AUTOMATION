package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.OneDriveVideoEncodeFunctionality;

public class OneDriveVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private OneDriveVideoEncodeFunctionality OneDrive;

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
        OneDrive = new OneDriveVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInOneDrive() throws Exception {
        OneDrive.VerifyVideoEncodeFunctionalityto1080pinOneDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInOneDrive() throws Exception {
        OneDrive.VerifyVideoEncodeFunctionalityto720pinOneDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInOneDrive() throws Exception {
        OneDrive.VerifyVideoEncodeFunctionalityto480pinOneDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInOneDrive() throws Exception {
        OneDrive.VerifyVideoEncodeFunctionalityto360pinOneDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInOneDrive() throws Exception {
        OneDrive.VerifyVideoEncodeFunctionalityto240pinOneDrive();
    }
}