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
import com.iomovo.pagespackage.DashboardFunctionality.HomePageCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageCenterPanelTest extends BaseClass 
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
	
	//These Below Methods are for Home Page CENTER PANEL Functionality tests

		@Test
		public void verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToDeleteFIleWhileUploadingTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel home = new HomePageCenterPanel(driver, wait);
				home.verifyUserAbleToDeleteFileWhileUploadingTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserIsAbleToCaptureImageWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureImageWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserIsAbleToCaptureImageWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		@Test
		public void verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRecordTheVideoWithAutoSyncTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserIsAbleToRecordTheVideoWithAutoSyncTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToCaptureTheScreenTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.loginMethod();

				HomePageCenterPanel CenterPanel = new HomePageCenterPanel(driver, wait);
				CenterPanel.verifyUserIsAbleToCaptureTheScreenTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}