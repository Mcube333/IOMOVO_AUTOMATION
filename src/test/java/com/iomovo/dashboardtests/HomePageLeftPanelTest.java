package com.iomovo.dashboardtests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.HomePageLeftPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class HomePageLeftPanelTest extends BaseTestClass {

	LoginPage loginPage;
	HomePageLeftPanel leftPanel;

	@BeforeMethod
	public void setUp() {
		if (driver == null) {
			throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
		}
		loginPage = new LoginPage();
		leftPanel = new HomePageLeftPanel(driver, wait);
	}


	//These Below Methods are for HOME PAGE LEFT PAGE Functionality tests

	@Test
	public void verifyUserIsRedirectedToMyFileFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToMyFileFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToRecycleBinFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToRecycleBinFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest() {
		try {
			loginPage.loginMethod(); 

			leftPanel.verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}