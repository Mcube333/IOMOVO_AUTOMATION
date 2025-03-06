package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageRightPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageRightPanelTest extends BaseTestClass 
{

	LoginPage loginPage;
	HomePageRightPanel rightPanel;
	
	@BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        rightPanel = new HomePageRightPanel(driver, wait);
    }
	
	//These Below Methods are for HOME PAGE RIGHT PANEL Functionality tests

		@Test
		public void verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();
				
				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest() {
			try {
				loginPage.loginMethod();
				
				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest() {
			try {
				loginPage.loginMethod();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
