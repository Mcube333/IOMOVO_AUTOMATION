package com.iomovo.dashboardtests;

import org.testng.annotations.*;

import com.iomovo.basepackage.BaseClass;
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
public class LoginPageTest extends BaseClass {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = getDriver(); // Fetch WebDriver from BaseClass
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in LoginPageTest. Check BaseClass initialization.");
        }
        loginPage = new LoginPage(driver, getWait()); // Initialize LoginPage once
    }

    // ----------------------------------------------
    // 🔹 Login Page Test Cases
    // ----------------------------------------------

    /**
     * Test to verify all elements are present on the login page.
     * Ensures that all required fields (email, password, login button, etc.) are displayed.
     */
    @Test
    public void verifyAllElementsArePresentInLoginPageTest() throws Exception {
        loginPage.verifyAllElementsArePresentInLoginPageTest();
    }

    /**
     * Test for valid login functionality.
     * Verifies that a user can log in with correct credentials.
     */
    @Test
    public void loginTest() throws Exception {
        loginPage.loginMethod();
    }

    /**
     * Comprehensive test to check multiple login scenarios.
     */
    @Test
    public void multipleLoginScenariosTest() throws Exception {
        loginPage.VerifyUserAbleToLoginWithBothCorrectEmailIDAndPasswordTest();
        loginPage.VerifyUserAbleToLoginWithBothWrongEmailIDAndPasswordTest();
        loginPage.VerifyUserAbleToLoginWithWrongEmailIDAndCorrectPasswordTest();
        loginPage.VerifyUserAbleToLoginWithCorrectEmailIDAndWrongPasswordTest();
        loginPage.VerifyUserAbleToLoginWithOutEnteringBothEmailIDAndPasswordTest();
    }

    /**
     * Test to verify that clicking on "Terms" redirects the user to the Terms page.
     */
    @Test
    public void verifyTermsPageRedirectionTest() throws Exception {
        loginPage.verifyUserIsRedirectedToIoMoVoTermsPageTest();
    }

    /**
     * Test to verify that clicking on "Privacy Policy" redirects the user to the Privacy Policy page.
     */
    @Test
    public void verifyPrivacyPolicyPageRedirectionTest() throws Exception {
        loginPage.verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest();
    }
}