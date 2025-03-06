package com.iomovo.dashboardtests;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.IoCloudCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class IoCloudCenterPanelTest extends BaseClass 
{
	/**
	 * This Method Runs Before Suite. Logs, extent report and properties file are
	 * loaded and configured. Screen Recording is started to monitor the execution.
	 * 
	 * @author Mudassir
	 * @throws FileNotFoundException
	 */
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException {
		try {
			System.out.println("********** Inside beforeSuite Method **********");
			loadPropertiesFile();
			numberOfAttemptsToFindWebElements();
			extReport = extentReportsClass.startReport("IOMOVO App Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Runs Before Each Method or TestCase. Here Web Driver is
	 * initialized and configured.
	 * 
	 * @author Mudassir
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void testSetUp() throws InterruptedException {
		System.out.println("********** Inside testSetUp Method **********");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		System.out.println("********** After WebDriverManager **********");
		ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.addArguments("use-fake-ui-for-media-stream");
		handlingSSL.setAcceptInsecureCerts(true);
		handlingSSL.addArguments("--incognito");
		driver = new ChromeDriver(handlingSSL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	
	//These Below Methods are for IOCLOUD Page Functionality tests

		@Test
		public void verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				String folderName = "testfolder"; // Provide the desired folder name
				leftPanel.verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest(folderName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				String ProjectName = "AutotestProject"; // Provide the desired folder name
				leftPanel.verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest(ProjectName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel leftPanel = new IoCloudCenterPanel(driver, wait);
				leftPanel.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFilesFunctionalityTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFilesFunctionalityTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSortRecordsFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSortRecordsFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToPinAndUnPinFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToPinAndUnPinFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		@Test
		public void verifyUserAbleToCopyFilesFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToCopyFilesFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToDragAndDropFileFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToDragAndDropFileFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToOpenVideoFileInTheNewTabFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

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
				login.Login();

				IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
				ioCloud.verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//	@Test
		//	public void verifyUserAbleToMoveFolderFromIoCloudMyFiles() {
		//		try {
		//			LoginPage login = new LoginPage(driver, wait);
		//			login.Login();
		//
		//			IoCloudCenterPanel ioCloud = new IoCloudCenterPanel(driver, wait);
		//			ioCloud.verifyUserAbleToMoveFolderFromIoCloudMyFiles();
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
		//	}

		@Test
		public void verifyUserAbleToRenameFileFromIoCloudMyFiles() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

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
				login.Login();

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
				login.Login();

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
