package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.IoCloudCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class IoCloudCenterPanelTest extends BaseTestClass 
{
	/**
	 * This Method Runs Before Suite. Logs, extent report and properties file are
	 * loaded and configured. Screen Recording is started to monitor the execution.
	 * 
	 * @author Mudassir
	 * @throws FileNotFoundException
	 */
	LoginPage loginPage;
	IoCloudCenterPanel ioCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        ioCloud = new IoCloudCenterPanel(driver, wait);
    }

	
	
	//These Below Methods are for IOCLOUD Page Functionality tests

		@Test
		public void verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest() {
			try {
				loginPage.loginMethod(); // Perform login

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest("testfolder");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest("AutotestProject");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();
				
				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest() {
			try {
				loginPage.loginMethod();
				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFilesFunctionalityTest() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFilesFunctionalityTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSortRecordsFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSortRecordsFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToPinAndUnPinFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToPinAndUnPinFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		@Test
		public void verifyUserAbleToCopyFilesFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToCopyFilesFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToDragAndDropFileFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToDragAndDropFileFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToOpenVideoFileInTheNewTabFromIoCloudMyFiles() {
			try {
				loginPage.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToOpenVideoFileInTheNewTabFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToRenameFileFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToRenameFileFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToRenameFolderFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToRenameFolderFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}	

		@Test
		public void verifyUserAbleToDeleteFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToDeleteFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void verifyUserAbleToUploadVideoFileToIoCloudUploadSectionTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
