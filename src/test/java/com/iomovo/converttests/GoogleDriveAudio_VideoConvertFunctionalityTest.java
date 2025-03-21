package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.GoogleDriveAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleDriveAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private GoogleDriveAudio_VideoConvertFunctionality  GoogleDrive;
	
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

        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internally
        GoogleDrive = new GoogleDriveAudio_VideoConvertFunctionality(driver, getWait());

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
    public void verifyAudioConvertFunctionalityInGoogleDrive() throws Exception {
        GoogleDrive.verifyAudioConvertFunctionalityInGoogleDrive();
    }

    @Test
    public void verifyVideoConvertFunctionalityInGoogleDrive() throws Exception {
        GoogleDrive.verifyVideoConvertFunctionalityInGoogleDrive();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInGoogleDrive() throws Exception {
        GoogleDrive.verifyVideo2AudioConvertFunctionalityInGoogleDrive();
    }
}