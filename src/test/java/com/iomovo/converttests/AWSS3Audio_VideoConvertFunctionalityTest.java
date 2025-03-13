package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.AWSS3Audio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

public class AWSS3Audio_VideoConvertFunctionalityTest extends BaseClass {

	private LoginPage loginPage;
    private AWSS3Audio_VideoConvertFunctionality  AWSS3;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
    	driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in HomePageTopPanelTest. Check BaseTestClass initialization.");
        }

        loginPage = new LoginPage(driver, getWait());
        AWSS3 = new AWSS3Audio_VideoConvertFunctionality(driver, getWait());

        performLogin(); // Login before each test
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
    public void verifyAudioConvertFunctionalityInAWSS3() throws Exception {
        AWSS3.verifyAudioConvertFunctionalityInAWSS3();
    }

    @Test
    public void verifyVideoConvertFunctionalityInAWSS3() throws Exception {
        AWSS3.verifyVideoConvertFunctionalityInAWSS3();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInAWSS3() throws Exception {
        AWSS3.verifyVideo2AudioConvertFunctionalityInAWSS3();
    }
}
