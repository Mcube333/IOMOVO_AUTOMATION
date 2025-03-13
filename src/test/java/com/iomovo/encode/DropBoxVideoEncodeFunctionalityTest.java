package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.DropBoxVideoEncodeFunctionality;

public class DropBoxVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private DropBoxVideoEncodeFunctionality DropBox;

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
        DropBox = new DropBoxVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInDropBoxDrive() throws Exception {
        DropBox.VerifyVideoEncodeFunctionalityto1080pinDropBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInDropBoxDrive() throws Exception {
        DropBox.VerifyVideoEncodeFunctionalityto720pinDropBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInDropBoxDrive() throws Exception {
        DropBox.VerifyVideoEncodeFunctionalityto480pinDropBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInDropBoxDrive() throws Exception {
        DropBox.VerifyVideoEncodeFunctionalityto360pinDropBoxDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInDropBoxDrive() throws Exception {
        DropBox.VerifyVideoEncodeFunctionalityto240pinDropBoxDrive();
    }
}