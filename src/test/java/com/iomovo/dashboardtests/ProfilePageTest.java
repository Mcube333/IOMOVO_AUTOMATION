package com.iomovo.dashboardtests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.DashboardFunctionality.ProfilePage;


public class ProfilePageTest extends BaseTestClass 
{
	/**
	 * This method runs **once before the entire test suite**.
	 * It performs the following setup:
	 * - Loads configuration properties
	 * - Initializes logging and reporting
	 * - Sets up necessary configurations for the test execution
	 * 
	 * @throws FileNotFoundException If the properties file is not found
	 */
//	@BeforeSuite
//	public void beforeSuite() throws FileNotFoundException {
//		try {
//			System.out.println("********** Inside beforeSuite Method **********");
//			loadPropertiesFile();  // Load configuration properties
//			numberOfAttemptsToFindWebElements();  // Set retry attempts for locating elements
//			extReport = extentReportsClass.startReport("IOMOVO App Automation");  // Start test report
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * This method runs **before each test method**.
	 * It initializes the WebDriver with necessary configurations:
	 * - Uses WebDriverManager to set up ChromeDriver
	 * - Configures Chrome options for SSL handling and incognito mode
	 * - Sets browser window size and timeouts
	 * - Initializes WebDriverWait for explicit waits
	 */
//	@BeforeMethod
//	public void testSetUp() throws InterruptedException {
//		System.out.println("********** Inside testSetUp Method **********");
//
//		// Automatically set up ChromeDriver using WebDriverManager
//		WebDriverManager.chromedriver().setup();
//		System.out.println("********** After WebDriverManager **********");
//
//		// Configure Chrome browser options
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("use-fake-ui-for-media-stream"); // Simulates UI for media permissions
//		options.setAcceptInsecureCerts(true); // Accepts insecure SSL certificates
//		options.addArguments("--incognito"); // Opens browser in incognito mode
//
//		// Initialize WebDriver (Chrome) with the specified options
//		driver = new ChromeDriver(options);
//		driver.manage().deleteAllCookies();  // Clear cookies to prevent session carryover
//		driver.manage().window().maximize();  // Maximize browser window for better visibility
//
//		// Set implicit and explicit wait durations (Selenium 4+ best practices)
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // Page load timeout
//
//		// Initialize WebDriverWait for explicit waits
//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	}

	//These Below Methods are for PROFILE PAGE Functionality tests

	@Test
	public void verifyUserAbleToSignOutFromCurrentAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToSignOutFromCurrentAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToViewAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToViewAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithWebCamTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithWebCamTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithUploadImageTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithUploadImageTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsAbleToDeactivateAccountTestTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserIsAbleToDeactivateAccountTestTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToSupportPageFromProfileTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserIsRedirectedToSupportPageFromProfileTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToSwitchAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile3 = new ProfilePage(driver, wait);
			profile3.verifyUserAbleToSwitchAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserAbleToSignInFromDifferentAccountTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserAbleToSignInFromDifferentAccountTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			ProfilePage profile = new ProfilePage(driver, wait);
			profile.verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ----------------------------------------------
	// 🔹 Test Cleanup Methods
	// ----------------------------------------------

	/**
	 * This method runs **after each test method**.
	 * - It waits for 3 seconds before closing the browser.
	 * - Ensures the browser is closed properly to prevent memory leaks.
	 */
	@AfterMethod
	public void exitTest() {
		explicitWaitInSeconds(3); // Small wait before closing
		if (driver != null) {
			try {
				driver.quit(); // Close browser
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method runs **after the entire test suite**.
	 * - It stops the Extent report logging.
	 * - Finalizes any reporting or logging required.
	 */
	@AfterSuite
	public void afterSuite() {
		extentReportsClass.endReport();
	}
}
