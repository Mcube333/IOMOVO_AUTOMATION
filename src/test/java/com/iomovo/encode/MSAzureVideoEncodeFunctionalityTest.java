package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.MSAzureVideoEncodeFunctionality;

public class MSAzureVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private MSAzureVideoEncodeFunctionality MSAzure;

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
        MSAzure = new MSAzureVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInAzureDrive() throws Exception {
        MSAzure.VerifyVideoEncodeFunctionalityto1080pinAzureDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInAzureDrive() throws Exception {
        MSAzure.VerifyVideoEncodeFunctionalityto720pinAzureDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInAzureDrive() throws Exception {
        MSAzure.VerifyVideoEncodeFunctionalityto480pinAzureDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInAzureDrive() throws Exception {
        MSAzure.VerifyVideoEncodeFunctionalityto360pinAzureDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInAzureDrive() throws Exception {
        MSAzure.VerifyVideoEncodeFunctionalityto240pinAzureDrive();
    }
}
