package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageTopPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageTopPanelTest extends BaseTestClass 
{
	/**
	 * This Method Runs Before Suite. Logs, extent report and properties file are
	 * loaded and configured. Screen Recording is started to monitor the execution.
	 * 
	 * @author Mudassir
	 * @throws FileNotFoundException
	 */
	
	LoginPage loginPage;
	HomePageTopPanel topPanel;
	
	@BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        topPanel = new HomePageTopPanel(driver, wait);
    }

	//These Below Methods are for Home Page TOP PANEL Functionality tests

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheScreenFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToRecordTheScreenFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSettingsPageFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsRedirectedToSettingsPageFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToSwitchToDarkModeFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsAbleToSwitchToDarkModeFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToClearNotificationFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserAbleToClearNotificationFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSupportPageFromTopPanelTest() {
			try {
				loginPage.loginMethod(); 

				topPanel.verifyUserIsRedirectedToSupportPageFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}