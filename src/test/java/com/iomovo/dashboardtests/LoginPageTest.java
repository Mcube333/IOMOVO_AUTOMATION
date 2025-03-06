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
			login.login();
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