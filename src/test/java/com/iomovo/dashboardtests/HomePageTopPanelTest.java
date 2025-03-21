package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageTopPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

public class HomePageTopPanelTest extends BaseClass {

	private WebDriver driver;
	private LoginPage loginPage;
    private HomePageTopPanel topPanel;

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
        
        loginPage = new LoginPage(); // ✅ No need to pass driver, fetched internallyloginPage = new LoginPage(driver, getWait());
        topPanel = new HomePageTopPanel(driver, getWait());

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
    public void verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
    	topPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
    	topPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
    	topPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserAbleToDeleteFIleWhileUploadingFromTopPanel() throws Exception {
    	topPanel.verifyUserAbleToDeleteFIleWhileUploadingFromTopPanel();
    }

    @Test
    public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSync() throws Exception {
    	topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSync();
    }

    @Test
    public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSync() throws Exception {
    	topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSync();
    }

    @Test
    public void verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSync() throws Exception {
    	topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSync();
    }

    @Test
    public void verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSync() throws Exception {
    	topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSync();
    }

    @Test
    public void verifyUserIsAbleToRecordTheScreenFromTopPanel() throws Exception {
    	topPanel.verifyUserIsAbleToRecordTheScreenFromTopPanel();
    }

    @Test
    public void verifyUserIsRedirectedToSettingsPageFromTopPanel() throws Exception {
    	topPanel.verifyUserIsRedirectedToSettingsPageFromTopPanel();
    }

    @Test
    public void verifyUserIsAbleToSwitchToDarkModeFromTopPanel() throws Exception {
    	topPanel.verifyUserIsAbleToSwitchToDarkModeFromTopPanel();
    }

    @Test
    public void verifyUserAbleToClearNotificationFromTopPanel() throws Exception {
    	topPanel.verifyUserAbleToClearNotificationFromTopPanel();
    }

    @Test
    public void verifyUserIsRedirectedToSupportPageFromTopPanel() throws Exception {
    	topPanel.verifyUserIsRedirectedToSupportPageFromTopPanel();
    }
}