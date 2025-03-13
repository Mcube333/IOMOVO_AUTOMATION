package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.GoogleCloudAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleCloudAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleCloudAudio_VideoConvertFunctionality  GoogleCloud;
	
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
        GoogleCloud = new GoogleCloudAudio_VideoConvertFunctionality(driver, getWait());

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

	//These Below Methods are for Login Functionality tests
	
    @Test
    public void verifyAudioConvertFunctionalityInGoogleCloud() throws Exception {
        GoogleCloud.verifyAudioConvertFunctionalityInGoogleCloud();
    }

    @Test
    public void verifyVideoConvertFunctionalityInGoogleCloud() throws Exception {
        GoogleCloud.verifyVideoConvertFunctionalityInGoogleCloud();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInGoogleCloud() throws Exception {
        GoogleCloud.verifyVideo2AudioConvertFunctionalityInGoogleCloud();
    }
}