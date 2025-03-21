package com.iomovo.converttests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.DropBoxAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class DropBoxAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private DropBoxAudio_VideoConvertFunctionality  DropBox;
	
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
        DropBox = new DropBoxAudio_VideoConvertFunctionality(driver, getWait());

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
    public void verifyAudioConvertFunctionalityInDropBox() throws Exception {
        DropBox.verifyAudioConvertFunctionalityInDropBox();
    }

    @Test
    public void verifyVideoConvertFunctionalityInDropBox() throws Exception {
        DropBox.verifyVideoConvertFunctionalityInDropBox();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInDropBox() throws Exception {
        DropBox.verifyVideo2AudioConvertFunctionalityInDropBox();
    }
}