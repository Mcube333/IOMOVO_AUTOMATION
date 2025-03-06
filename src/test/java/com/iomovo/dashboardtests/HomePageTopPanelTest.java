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
import com.iomovo.pagespackage.DashboardFunctionality.HomePageTopPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageTopPanelTest extends BaseClass 
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
	
	//These Below Methods are for Home Page TOP PANEL Functionality tests

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheScreenFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToRecordTheScreenFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSettingsPageFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsRedirectedToSettingsPageFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToSwitchToDarkModeFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsAbleToSwitchToDarkModeFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToClearNotificationFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserAbleToClearNotificationFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSupportPageFromTopPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageTopPanel topPanel = new HomePageTopPanel(driver, wait);
				topPanel.verifyUserIsRedirectedToSupportPageFromTopPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}