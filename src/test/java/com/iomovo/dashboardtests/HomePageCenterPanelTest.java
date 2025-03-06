package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageCenterPanelTest extends BaseTestClass {
	LoginPage loginPage;
	HomePageCenterPanel CenterPanel;

	@BeforeMethod
	public void setUp() {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
		}
		loginPage = new LoginPage();
		CenterPanel = new HomePageCenterPanel(driver, wait);
	}

	//These Below Methods are for Home Page CENTER PANEL Functionality tests

	@Test
	public void verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToDeleteFIleWhileUploadingTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserAbleToDeleteFileWhileUploadingTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsAbleToCaptureImageWithoutAutoSyncTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserIsAbleToCaptureImageWithoutAutoSyncTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsAbleToCaptureImageWithAutoSyncTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserIsAbleToCaptureImageWithAutoSyncTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsAbleToRecordTheVideoWithAutoSyncTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserIsAbleToRecordTheVideoWithAutoSyncTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsAbleToCaptureTheScreenTest() {
		try {
			loginPage.loginMethod();

			CenterPanel.verifyUserIsAbleToCaptureTheScreenTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}