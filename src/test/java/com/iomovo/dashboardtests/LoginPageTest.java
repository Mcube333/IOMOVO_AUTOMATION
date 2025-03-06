package com.iomovo.dashboardtests;

import org.testng.annotations.*;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

/**
 * This class contains test cases for Login functionality in the IoMoVo application.
 * It includes setting up WebDriver, running login tests, and managing test execution.
 * 
 * Test cases include:
 * - Verifying elements on the login page
 * - Successful and unsuccessful login attempts
 * - Redirection to terms and privacy policy pages
 * 
 * Author: Mudassir
 */
public class LoginPageTest extends BaseTestClass {
	
	LoginPage loginPage;
	
	@BeforeMethod
    public void setUp() {
		if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LoginPageTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage(driver, wait);  // Pass WebDriver from BaseTestClass
    }

//    /**
//     * This method runs **once before the entire test suite**.
//     * It performs the following setup:
//     * - Loads configuration properties
//     * - Initializes logging and reporting
//     * - Sets up necessary configurations for the test execution
//     * 
//     * @throws FileNotFoundException If the properties file is not found
//     */
//    @BeforeSuite
//    public void beforeSuite() throws FileNotFoundException {
//        try {
//            System.out.println("********** Inside beforeSuite Method **********");
//            loadPropertiesFile();  // Load configuration properties
//            numberOfAttemptsToFindWebElements();  // Set retry attempts for locating elements
//            extReport = extentReportsClass.startReport("IOMOVO App Automation");  // Start test report
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * This method runs **before each test method**.
//     * It initializes the WebDriver with necessary configurations:
//     * - Uses WebDriverManager to set up ChromeDriver
//     * - Configures Chrome options for SSL handling and incognito mode
//     * - Sets browser window size and timeouts
//     * - Initializes WebDriverWait for explicit waits
//     */
//    @BeforeMethod
//    public void testSetUp() throws InterruptedException {
//        System.out.println("********** Inside testSetUp Method **********");
//
//        // Automatically set up ChromeDriver using WebDriverManager
//        WebDriverManager.chromedriver().setup();
//        System.out.println("********** After WebDriverManager **********");
//
//        // Configure Chrome browser options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("use-fake-ui-for-media-stream"); // Simulates UI for media permissions
//        options.setAcceptInsecureCerts(true); // Accepts insecure SSL certificates
//        options.addArguments("--incognito"); // Opens browser in incognito mode
//
//        // Initialize WebDriver (Chrome) with the specified options
//        driver = new ChromeDriver(options);
//        driver.manage().deleteAllCookies();  // Clear cookies to prevent session carryover
//        driver.manage().window().maximize();  // Maximize browser window for better visibility
//
//        // Set implicit and explicit wait durations (Selenium 4+ best practices)
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // Page load timeout
//
//        // Initialize WebDriverWait for explicit waits
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    }

    // ----------------------------------------------
    // 🔹 Login Page Test Cases
    // ----------------------------------------------

    /**
     * Test to verify all elements are present on the login page.
     * It ensures that all required fields (email, password, login button, etc.) are displayed.
     */
    @Test
    public void verifyAllElementsArePresentInLoginPageTest() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.verifyAllElementsArePresentInLoginPageTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Test for valid login functionality.
     * It verifies that a user can log in with correct credentials.
     */
    @Test
    public void LoginTest() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Another test for the login function.
     * (Possibly a duplicate; consider merging with `LoginTest()` if they test the same functionality.)
     */
    @Test
    public void Login() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.Login();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Comprehensive test to check multiple login scenarios:
     * - Correct email & password
     * - Wrong email & password
     * - Wrong email & correct password
     * - Correct email & wrong password
     * - No credentials entered
     */
    @Test
    public void ioMoVoAppTest() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.VerifyUserAbleToLoginWithBothCorrectEmailIDAndPasswordTest();
			login.VerifyUserAbleToLoginWithBothWrongEmailIDAndPasswordTest();
			login.VerifyUserAbleToLoginWithWrongEmailIDAndCorrectPasswordTest();
			login.VerifyUserAbleToLoginWithCorrectEmailIDAndWrongPasswordTest();
			login.VerifyUserAbleToLoginWithOutEnteringBothEmailIDAndPasswordTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Test to verify that clicking on "Terms" redirects the user to the Terms page.
     */
    @Test
    public void verifyUserIsRedirectedToIoMoVoTermsPageTest() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.verifyUserIsRedirectedToIoMoVoTermsPageTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * Test to verify that clicking on "Privacy Policy" redirects the user to the Privacy Policy page.
     */
    @Test
    public void verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest() {
        try {
			LoginPage login = new LoginPage(driver, wait);
			login.verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

//    // ----------------------------------------------
//    // 🔹 Test Cleanup Methods
//    // ----------------------------------------------
//
//    /**
//     * This method runs **after each test method**.
//     * - It waits for 3 seconds before closing the browser.
//     * - Ensures the browser is closed properly to prevent memory leaks.
//     */
//    @AfterMethod
//    public void exitTest() {
//        explicitWaitInSeconds(3); // Small wait before closing
//        if (driver != null) {
//            try {
//                driver.quit(); // Close browser
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * This method runs **after the entire test suite**.
//     * - It stops the Extent report logging.
//     * - Finalizes any reporting or logging required.
//     */
//    @AfterSuite
//    public void afterSuite() {
//        extentReportsClass.endReport();
//    }
//}
