package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageLeftPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageLeftPanelTest extends BaseClass {

	private WebDriver driver;
	private LoginPage loginPage;
    private HomePageLeftPanel leftPanel;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
    	driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in HomePageTopPanelTest. Check BaseTestClass initialization.");
        }

        loginPage = new LoginPage(driver, getWait());
        leftPanel = new HomePageLeftPanel(driver, getWait());

        performLogin(); // Login before each test
    }

    /**
     * Perform login before executing test cases.
     */
    private void performLogin() {
        try {
            loginPage.loginMethod();
        } catch (Exception e) {
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }


    @Test
    public void verifyUserIsRedirectedToMyFileFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToMyFileFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToRecycleBinFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToRecycleBinFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest();
    }

    @Test
    public void verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest() throws Exception {
        leftPanel.verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest();
    }
}