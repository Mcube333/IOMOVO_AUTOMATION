package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.FTPAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class FTPAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private FTPAudio_VideoConvertFunctionality  FTP;
	
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
        FTP = new FTPAudio_VideoConvertFunctionality(driver, getWait());

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
    public void verifyAudioConvertFunctionalityInFTP() throws Exception {
        FTP.verifyAudioConvertFunctionalityInFTP();
    }

    @Test
    public void verifyVideoConvertFunctionalityInFTP() throws Exception {
        FTP.verifyVideoConvertFunctionalityInFTP();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInFTP() throws Exception {
        FTP.verifyVideo2AudioConvertFunctionalityInFTP();
    }
}