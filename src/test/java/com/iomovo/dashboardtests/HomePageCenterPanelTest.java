package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageCenterPanelTest extends BaseClass {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePageCenterPanel CenterPanel;

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
        CenterPanel = new HomePageCenterPanel(driver, getWait());

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

	//These Below Methods are for Home Page CENTER PANEL Functionality tests

	@Test
	public void verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
			CenterPanel.verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest();
	}

	@Test
	public void verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
			CenterPanel.verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest();
	}

	@Test
	public void verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
			CenterPanel.verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest();
	}

	@Test
	public void verifyUserAbleToDeleteFIleWhileUploadingTest() throws Exception {
			CenterPanel.verifyUserAbleToDeleteFileWhileUploadingTest();
	}

	@Test
	public void verifyUserIsAbleToCaptureImageWithoutAutoSyncTest() throws Exception {
			CenterPanel.verifyUserIsAbleToCaptureImageWithoutAutoSyncTest();
	}

	@Test
	public void verifyUserIsAbleToCaptureImageWithAutoSyncTest() throws Exception {
			CenterPanel.verifyUserIsAbleToCaptureImageWithAutoSyncTest();
	}


	@Test
	public void verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest() throws Exception {
			CenterPanel.verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest();
	}

	@Test
	public void verifyUserIsAbleToRecordTheVideoWithAutoSyncTest() throws Exception {
			CenterPanel.verifyUserIsAbleToRecordTheVideoWithAutoSyncTest();
	}

	@Test
	public void verifyUserIsAbleToCaptureTheScreenTest() throws Exception {
			CenterPanel.verifyUserIsAbleToCaptureTheScreenTest();
	}
}