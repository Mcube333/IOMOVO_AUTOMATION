package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

/**
 * This class contains test cases for Login functionality in the IoMoVo application.
 * It extends BaseClass for WebDriver setup and utility methods.
 * Supports cross-browser testing with 'browser' and 'os' parameters.
 * Uses TestNG groups "smoke" and "regression" for suite categorization.
 *
 * Test cases include:
 * - Verifying elements on the login page
 * - Successful and unsuccessful login attempts (split into individual scenarios)
 * - Redirection to terms and privacy policy pages
 *
 * Author: Mudassir
 */
public class LoginPageTest extends BaseClass {
	
    private LoginPage loginPage;

    /**
     * Setup method runs before each test.
     * Initializes WebDriver via BaseClass using the specified browser and os, and sets up the LoginPage object.
     * @param browser The browser type (e.g., "chrome", "firefox", "edge"), defaults to "chrome" if not provided.
     * @param os The operating system (e.g., "windows"), defaults to "windows" if not provided.
     */
    @BeforeMethod
    @Parameters({"browser", "os"})
    public void setUp(@Optional("chrome") String browser, @Optional("windows") String os) {
        // BaseClass setUp() runs automatically, initializing driver and wait
        if (getDriver() == null) {
            throw new IllegalStateException("❌ WebDriver is null in LoginPageTest. Check BaseClass initialization.");
        }
        loginPage = new LoginPage(); // Use default constructor, which fetches driver from BaseClass
    }
    
    // ----------------------------------------------
    // 🔹 Login Page Test Cases
    // ----------------------------------------------

    /**
     * Smoke Test: Verifies all elements are present on the login page.
     * Ensures that required fields (email, password, login button, etc.) are displayed.
     * Grouped as "smoke" and "regression" since it’s a core UI check.
     */
    @Test(groups = {"sanity", "regression"})
    public void verifyAllElementsArePresentInLoginPageTest() throws Exception {
        loginPage.verifyAllElementsArePresentInLoginPageTest();
    }

    /**
     * Smoke Test: Verifies valid login functionality with correct credentials.
     * Grouped as "smoke" and "regression" since it’s a critical feature.
     */
    @Test(groups = {"sanity", "regression"})
    public void loginTest() throws Exception {
        log.info("Starting login test with URL: " + strUrl + ", Username: " + strUsername);
        loginPage.login_logout();
        log.info("Login test completed successfully");
    }

    /**
     * Regression Test: Verifies login with both correct email and password.
     * Grouped as "regression" only as part of detailed login scenario testing.
     */
    @Test(groups = "regression")
    public void verifyLoginWithCorrectEmailAndPassword() throws Exception {
        loginPage.VerifyUserAbleToLoginWithBothCorrectEmailIDAndPasswordTest();
    }

    /**
     * Regression Test: Verifies login with both incorrect email and password.
     * Grouped as "regression" only as part of detailed login scenario testing.
     */
    @Test(groups = "regression")
    public void verifyLoginWithIncorrectEmailAndPassword() throws Exception {
        loginPage.VerifyUserAbleToLoginWithBothWrongEmailIDAndPasswordTest();
    }

    /**
     * Regression Test: Verifies login with incorrect email and correct password.
     * Grouped as "regression" only as part of detailed login scenario testing.
     */
    @Test(groups = "regression")
    public void verifyLoginWithIncorrectEmailAndCorrectPassword() throws Exception {
        loginPage.VerifyUserAbleToLoginWithWrongEmailIDAndCorrectPasswordTest();
    }

    /**
     * Regression Test: Verifies login with correct email and incorrect password.
     * Grouped as "regression" only as part of detailed login scenario testing.
     */
    @Test(groups = "regression")
    public void verifyLoginWithCorrectEmailAndIncorrectPassword() throws Exception {
        loginPage.VerifyUserAbleToLoginWithCorrectEmailIDAndWrongPasswordTest();
    }

    /**
     * Regression Test: Verifies login without entering email and password.
     * Grouped as "regression" only as part of detailed login scenario testing.
     */
    @Test(groups = "regression")
    public void verifyLoginWithoutEmailAndPassword() throws Exception {
        loginPage.VerifyUserAbleToLoginWithOutEnteringBothEmailIDAndPasswordTest();
    }

    /**
     * Regression Test: Verifies redirection to the Terms page when "Terms" is clicked.
     * Grouped as "regression" only as it’s a secondary feature.
     */
    @Test(groups = "regression")
    public void verifyTermsPageRedirectionTest() throws Exception {
        loginPage.verifyUserIsRedirectedToIoMoVoTermsPageTest();
    }

    /**
     * Regression Test: Verifies redirection to the Privacy Policy page when "Privacy Policy" is clicked.
     * Grouped as "regression" only as it’s a secondary feature.
     */
    @Test(groups = "regression")
    public void verifyPrivacyPolicyPageRedirectionTest() throws Exception {
        loginPage.verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest();
    }
}