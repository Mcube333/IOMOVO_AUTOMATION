package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.SFTPVideoEncodeFunctionality;

public class SFTPVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private SFTPVideoEncodeFunctionality SFTP;

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
        SFTP = new SFTPVideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInSFTPDrive() throws Exception {
        SFTP.VerifyVideoEncodeFunctionalityto1080pinSFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInSFTPDrive() throws Exception {
        SFTP.VerifyVideoEncodeFunctionalityto720pinSFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInSFTPDrive() throws Exception {
        SFTP.VerifyVideoEncodeFunctionalityto480pinSFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInSFTPDrive() throws Exception {
        SFTP.VerifyVideoEncodeFunctionalityto360pinSFTPDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInSFTPDrive() throws Exception {
        SFTP.VerifyVideoEncodeFunctionalityto240pinSFTPDrive();
    }
}