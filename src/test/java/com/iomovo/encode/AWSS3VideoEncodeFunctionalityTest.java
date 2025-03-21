package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.AWSS3VideoEncodeFunctionality;

public class AWSS3VideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private AWSS3VideoEncodeFunctionality AWSS3;

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
        AWSS3 = new AWSS3VideoEncodeFunctionality(driver, getWait());

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
    public void verifyVideoEncodeFunctionalityTo1080pInAWSS3Drive() throws Exception {
        AWSS3.VerifyVideoEncodeFunctionalityto1080pinAWSS3Drive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInAWSS3Drive() throws Exception {
        AWSS3.VerifyVideoEncodeFunctionalityto720pinAWSS3Drive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInAWSS3Drive() throws Exception {
        AWSS3.VerifyVideoEncodeFunctionalityto480pinAWSS3Drive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInAWSS3Drive() throws Exception {
        AWSS3.VerifyVideoEncodeFunctionalityto360pinAWSS3Drive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInAWSS3Drive() throws Exception {
        AWSS3.VerifyVideoEncodeFunctionalityto240pinAWSS3Drive();
    }
}
