package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageRightPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageRightPanelTest extends BaseClass 
{

	private WebDriver driver;
	private LoginPage loginPage;
    private HomePageRightPanel rightPanel;
	
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
        rightPanel = new HomePageRightPanel(driver, getWait());

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
    public void verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest() throws Exception {
        rightPanel.verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest();
    }

    @Test
    public void verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
        rightPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
        rightPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
        rightPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelQuickLinksTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelQuickLinksTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelQuickLinksTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest();
    }

    @Test
    public void verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelQuickLinksTest() throws Exception {
        rightPanel.verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest();
    }
}
