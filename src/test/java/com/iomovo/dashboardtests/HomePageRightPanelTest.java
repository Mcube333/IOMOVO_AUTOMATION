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
import com.iomovo.pagespackage.DashboardFunctionality.HomePageRightPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageRightPanelTest extends BaseClass 
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
	
	//These Below Methods are for HOME PAGE RIGHT PANEL Functionality tests

		@Test
		public void verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageRightPanel RightPanel = new HomePageRightPanel(driver, wait);
				RightPanel.verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
