package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.SharePointVideoEncodeFunctionality;

public class SharePointVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private SharePointVideoEncodeFunctionality SharePoint;

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
        SharePoint = new SharePointVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInSharePointDrive() throws Exception {
        SharePoint.VerifyVideoEncodeFunctionalityto1080pinSharePointDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInSharePointDrive() throws Exception {
        SharePoint.VerifyVideoEncodeFunctionalityto720pinSharePointDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInSharePointDrive() throws Exception {
        SharePoint.VerifyVideoEncodeFunctionalityto480pinSharePointDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInSharePointDrive() throws Exception {
        SharePoint.VerifyVideoEncodeFunctionalityto360pinSharePointDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInSharePointDrive() throws Exception {
        SharePoint.VerifyVideoEncodeFunctionalityto240pinSharePointDrive();
    }
}