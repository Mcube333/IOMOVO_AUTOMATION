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
import com.iomovo.pagespackage.DashboardFunctionality.HomePageLeftPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageLeftPanelTest extends BaseClass 
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
	
	//These Below Methods are for HOME PAGE LEFT PAGE Functionality tests

		@Test
		public void verifyUserIsRedirectedToMyFileFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToMyFileFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToRecycleBinFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToRecycleBinFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Test
		public void verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest() {
			try {
				LoginPage login = new LoginPage(driver, wait);
				login.Login();

				HomePageLeftPanel leftPanel = new HomePageLeftPanel(driver, wait);
				leftPanel.verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}