package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.FTPVideoEncodeFunctionality;

public class FTPVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private FTPVideoEncodeFunctionality FTP;

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
        FTP = new FTPVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInFTPDrive() throws Exception {
        FTP.VerifyVideoEncodeFunctionalityto1080pinFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInFTPDrive() throws Exception {
        FTP.VerifyVideoEncodeFunctionalityto720pinFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInFTPDrive() throws Exception {
        FTP.VerifyVideoEncodeFunctionalityto480pinFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInFTPDrive() throws Exception {
        FTP.VerifyVideoEncodeFunctionalityto360pinFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInFTPDrive() throws Exception {
        FTP.VerifyVideoEncodeFunctionalityto240pinFTPDrive();
    }
}