package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.BoxVideoEncodeFunctionality;

public class BoxVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private BoxVideoEncodeFunctionality Box;

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
        Box = new BoxVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInBoxDrive() throws Exception {
        Box.VerifyVideoEncodeFunctionalityto1080pinBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInBoxDrive() throws Exception {
        Box.VerifyVideoEncodeFunctionalityto720pinBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInBoxDrive() throws Exception {
        Box.VerifyVideoEncodeFunctionalityto480pinBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInBoxDrive() throws Exception {
        Box.VerifyVideoEncodeFunctionalityto360pinBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInBoxDrive() throws Exception {
        Box.VerifyVideoEncodeFunctionalityto240pinBoxDrive();
    }
}