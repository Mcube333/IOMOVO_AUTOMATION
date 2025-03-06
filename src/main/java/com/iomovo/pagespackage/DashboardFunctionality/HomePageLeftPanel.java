package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class HomePageLeftPanel extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageLeftPanel(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	//All X-paths of Home Page LEFT PANEL.
	String leftPanelHomeButton = "//span[text()=' Home']";
	String leftPanelIOCloud = "//span[text()='ioCloud']";

	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String myFilesPageConfirmation = "//a[text()='ioCloud']";
	String leftPanelIOCloud_Recent = "//div[text()='Recent']";
	String recentPageConfirmation = "//h1[text()='Recent']";
	String leftPanelIOCloud_SharedWithMe = "//div[text()='Shared With Me']";
	String sharedWithMePageConfirmation = "//h1[text()='Shared with Me']";
	String leftPanelIOCloud_SharedByMe = "//div[text()='Shared By Me']";
	String sharedByMePageConfirmation = "//h1[text()='Shared by Me']";
	String leftPanelIOCloud_RecycleBin = "//div[text()='Recycle Bin']";
	String recyclebinPageConfirmation = "//span[text()='Empty Trash']";

	String leftPanelIOHubAddConnectionButton = "(//span[text()='Add Connection'])[1]";
	String addConnectionPageConfirmation = "//b[text()='Active Connectors']";
	String leftPanelIOAIMSVideoAnalyzerButton = "//div[text()='MS Video Analyzer']";
	String MSVideoAnalyzerPageConfirmation = "//span[text()='Buy Now']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");
	
	

	public void verifyUserIsRedirectedToMyFileFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 001 : Verify User Is Redirected To My File From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("MyFiles Button Clicked Successfully");

			if (isWebElementDisplayed(myFilesPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To My Files Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To My Files Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToMyFileFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 002 : Verify User Is Redirected To Recent Files From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_Recent);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Recent Button Clicked Successfully");

			if (isWebElementDisplayed(recentPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Recent Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Recent Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToRecentFilesSectionFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 003 : Verify User Is Redirected To Shared With Me Section From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_SharedWithMe);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Shared With Me Button Clicked Successfully");

			if (isWebElementDisplayed(sharedWithMePageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Shared With Me Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Shared With Me Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToSharedWithMeSectionFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 004 : Verify User Is Redirected To Shared By Me Section From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_SharedByMe);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Shared By Me Button Clicked Successfully");

			if (isWebElementDisplayed(sharedByMePageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Shared By Me Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Shared By Me Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToSharedByMeSectionFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToRecycleBinFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 005 : Verify User Is Redirected To Recycle Bin From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_RecycleBin);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Recycle Bin Button Clicked Successfully");

			if (isWebElementDisplayed(recyclebinPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Recycle Bin Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Recycle Bin Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToRecycleBinFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 006 : Verify User Is Redirected To Add Connection Page From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOHubAddConnectionButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Add Connection Button Clicked Successfully");

			if (isWebElementDisplayed(addConnectionPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Add Connection Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Add Connection Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToIOHubAddConnectionPageFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 007 : Verify User Is Redirected To Add Connection Page From Left Panel Test");
			refreshWebPage();
			clickWebElement(leftPanelIOAIMSVideoAnalyzerButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("MS Video Analyzer Button Clicked Successfully");

			if (isWebElementDisplayed(addConnectionPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To MS Video Analyzer Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To MS Video Analyzer Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToIOAIMSVideoAnalyzerPageFromLeftPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
}



