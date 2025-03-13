package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.OneDriveAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OneDriveAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private OneDriveAudio_VideoConvertFunctionality  OneDrive;
	
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
        OneDrive = new OneDriveAudio_VideoConvertFunctionality(driver, getWait());

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
    public void verifyAudioConvertFunctionalityInOneDrive() throws Exception {
        OneDrive.verifyAudioConvertFunctionalityInOneDrive();
    }

    @Test
    public void verifyVideoConvertFunctionalityInOneDrive() throws Exception {
        OneDrive.verifyVideoConvertFunctionalityInOneDrive();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInOneDrive() throws Exception {
        OneDrive.verifyVideo2AudioConvertFunctionalityInOneDrive();
    }
}
