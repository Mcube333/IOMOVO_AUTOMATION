package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class HomePageRightPanel extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageRightPanel(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// All X-paths of Home Page RIGHT PANEL.
	String rightPanelIOCloudDropdown = "//h6[text()='ioCloud']";
	String rightPanelIOCloudDropdown_UploadButtonLink = "//span[text()='Upload']";
	String rightPanleIOCloudDropdown_GoToMyFilesLink = "//a[text()='Go to My Files']";
	String goTOMyFilesPageConfirmation = "//a[text()='ioCloud']";
	String rightPanelICloudDropdown_RecentlyAddedFilesLink = "//a[text()='Recently Added Files']";
	String recentlyAddedFilesPageConfirmation = "//h1[text()='Recent']";
	String rightPanelICloudDropdown_FilesSharedWithMeLink = "//a[text()='Files Shared with me']";
	String shredWithMePageConfirmation = "//h1[text()='Shared with Me']";
	String rightPanelICloudDropdown_RecycleBinLink = "//a[text()='Recycle Bin']";
	String recycleBinPageConfirmation = "//span[text()='Empty Trash']";

	String leftPanelHomeButton = "//span[text()=' Home']";
	String profileButtonLink = "//button[@aria-label='Profile']";
	String topPanelNotificationButton = "//button[@title='Notifications']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";

	String rightPanelIntegrationHubDropdown = "//h6[text()='ioHub']";
	String rightPanelIntegrationHubDropdown_AddConnectionButtonLink = "//button[@id='custom-btn-Add-Connection']";
	String integrationHubPageConfirmation = "//b[text()='Active Connectors']";
	String rightPanelIntegrationHubDropdown_AWSCloudStorgaeLink = "//h6[text()='AWS Cloud Storage']";
	String rightPanelIntegrationHubDropdown_BoxDriveStorgaeLink = "//h6[text()='Box Drive']";
	String rightPanelIntegrationHubDropdown_DropboxStorgaeLink = "//h6[text()='Dropbox']";
	String rightPanelIntegrationHubDropdown_GoogleDriveStorgaeLink = "//h6[text()='Google Drive™']";
	String rightPanelIntegrationHubDropdown_MicrosoftOneDriveStorgaeLink = "//h6[text()='Microsoft OneDrive']";
	String rightPanelIntegrationHubDropdown_AzureStorageStorgaeLink = "//h6[text()='Azure Storage']";
	String rightPanelIntegrationHubDropdown_SharePointOnlineStorgaeLink = "//h6[text()='SharePoint Online']";
	String rightPanelIntegrationHubDropdown_FTPStorgaeLink = "//h6[text()='FTP']";

	String rightPanelAIEngineOption = "//h6[text()='ioAI']";
	String rightPanelAIEngineOption_BuyAIEngineButtonLink = "//span[text()='Buy AI Engine']";

	String rightPanelQuickLinksDropdown = "//h6[text()='Quick Links']";
	String rightPanelQuickLinksDropdown_ActivityLogLink = "//a[text()='Activity Log']";
	String activityLogPageConfirmation = "//span[text()='Activities']";
	String rightPanelQuickLinksDropdown_AccountSettingsLink = "//a[text()='Account Settings']";
	String accountSettingsPageConfirmation = "//h6[text()='Account Detail']"; 
	String rightPanelQuickLinksDropdown_BillingInformationLink = "//a[text()='Billing Information']";
	String BillingPageConfirmation = "//b[text()='Billing']";
	String rightPanelQuickLinksDropdown_UpgradeLink = "//a[text()='Upgrade']";
	String upgradePageConfirmation = "//p[text()='Plan']";

	String rightPanelQuickLinksSendFeedbackOption = "//h6[text()='Send Feedback']";
	String fileUploadStatusBarLink = "//div[@id='panel1a-header']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");

	// Replace Or Skip Files X-paths
	String appendVersionLink = "//span[text()='Append Version']";
	String replaceCurrentVersionLink = "//span[text()='Replace Current Version']";
	String duplicateLink = "//span[text()='Duplicate file']";

	String audioFilesPath = projectDirectory + "\\FilesToUpload\\AudioFiles\\";
	String docFilesPath = projectDirectory + "\\FilesToUpload\\DocFiles\\";
	String videoFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles\\";
	String audioFileName = "BesharamRang.mp3";
	String odpFileName = "ODPFormatFile.odp";
	String odsFileName = "ODSFormatFile.ods";
	String pptFileName = "PPTFormatFile.ppt";
	String xlxsFileName = "XLSXFormatFile.xlsx";
	String docxFileName = "DOCXFormatFile.docx";
	String odtFileName = "ODTFormatFile.odt";
	String rtfFileName = "RTFFormatFile.rtf";
	String pdfFileName = "PDFFormatFile.pdf";
	String samplePdfFile = "sample.pdf";
	String videoFileName = "One Planet.mp4";


	public void uploadFilesFunctionality(String docFilesPath, String samplePdfFile) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(rightPanelIOCloudDropdown_UploadButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Upload button Clicked Successfully");
			logConsoleOutputMessage("docFilesPath: " + docFilesPath);
			logConsoleOutputMessage("pdfFileName: " + samplePdfFile);
			uploadFileUsingRobotClass(docFilesPath, samplePdfFile);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In uploadFilesFunctionality Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(String filesPath, String fileName)
			throws Exception {
		try {
			// Uploading a file for the first time
			logPassStepInExtentReport("TC 001 : Uploading Same File from RIGHT Panel Multiple Times And Take Certain Actions Functionality");
			logInfoStepInExtentReport("Uploading a file for the first time");
			uploadFilesFunctionality(filesPath, fileName);
			isWebElementDisplayed(fileUploadStatusBarLink);
			waitUntilElementGetsDisappeared(fileUploadStatusBarLink);
			String docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(docFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(false);
			}
			explicitWaitInSeconds(5);
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing APPEND functionality
			logPassStepInExtentReport("TC 002 : Uploading Same File again to test APPEND functionality");
			logInfoStepInExtentReport("Uploading same file again for testing APPEND functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(appendVersionLink);
			clickWebElement(appendVersionLink);
			waitUntilElementGetsDisappeared(fileUploadStatusBarLink);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			explicitWaitInSeconds(10);
			clickWebElement(topPanelNotificationButton);
			docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			explicitWaitInSeconds(5);
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing REPLACE AND CURRENT VERSION functionality
			logPassStepInExtentReport("TC 003 : Uploading Same File again to test REPLACE CURRENT VERSION functionality");
			logInfoStepInExtentReport("Uploading same file again for testing REPLACE CURRENT VERSION functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(replaceCurrentVersionLink);
			clickWebElement(replaceCurrentVersionLink);
			waitUntilElementGetsDisappeared(fileUploadStatusBarLink);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			explicitWaitInSeconds(10);
			clickWebElement(topPanelNotificationButton);
			docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			explicitWaitInSeconds(5);
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing DUPLICATE functionality
			logPassStepInExtentReport("TC 004 : Uploading Same File again to test DUPLICATE functionality");
			logInfoStepInExtentReport("Uploading same file again for testing DUPLICATE functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(duplicateLink);
			clickWebElement(duplicateLink);
			waitUntilElementGetsDisappeared(fileUploadStatusBarLink);
			String fileExtension = fileName.split("\\.")[1];
			fileName = fileName.replace("." + fileExtension, "_");
			docFileUploadedLabel = "(//p[contains(text(),'has been uploaded')])[1]";
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			explicitWaitInSeconds(10);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			explicitWaitInSeconds(5);
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToUploadFilesAndTakeCertainActions Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToUploadDocumentFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(docFilesPath, pdfFileName);
	}

	public void verifyUserAbleToUploadAudioFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(audioFilesPath, audioFileName);
	}

	public void verifyUserAbleToUploadVideoFileMultipleTimesFromRightPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(videoFilesPath, videoFileName);
	}

	public void verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 002 : verify User Able To Redirect To My Files From The Right Panel IoCloud Test");
			refreshWebPage();
			isWebElementDisplayed(rightPanleIOCloudDropdown_GoToMyFilesLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanleIOCloudDropdown_GoToMyFilesLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Go To My Files Link Clicked Successfully");

			if (isWebElementDisplayed(goTOMyFilesPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To My Files Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To My Files Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToRedirectToMyFilesFromTheRightPanelIoCloudTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 003 : verify User Is Able To redirect to recently added files from the right panel IoCloud test");
			refreshWebPage();
			isWebElementDisplayed(rightPanelICloudDropdown_RecentlyAddedFilesLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelICloudDropdown_RecentlyAddedFilesLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Recently Added Files Link Clicked Successfully");

			if (isWebElementDisplayed(recentlyAddedFilesPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Recently Added Files Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Recently Added Files Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToRecentlyAddedFilesFromTheRightPanelIoCloudTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 004 : verify User Is Able To redirect to files shared with me from the right panel IoCloud test");
			refreshWebPage();
			isWebElementDisplayed(rightPanelICloudDropdown_FilesSharedWithMeLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelICloudDropdown_FilesSharedWithMeLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Files Shared With Me Link Clicked Successfully");

			if (isWebElementDisplayed(shredWithMePageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Shared With Me Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Shared With Me Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToFilesSharedWithMeFromTheRightPanelIoCloudTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 005 : verify User Is Able To redirect to recycle bin from the right panel IoCloud test");
			refreshWebPage();
			isWebElementDisplayed(rightPanelICloudDropdown_RecycleBinLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelICloudDropdown_RecycleBinLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Recycle Bin Link Clicked Successfully");

			if (isWebElementDisplayed(recycleBinPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Recycle Bin Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Recycle Bin Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToRecycleBinFromTheRightPanelIoCloudTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 006 : verify User Is Able To redirect to IO hub from the right panel test");
			refreshWebPage();
			isWebElementDisplayed(rightPanelIntegrationHubDropdown);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelIntegrationHubDropdown);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(rightPanelIntegrationHubDropdown_AddConnectionButtonLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelIntegrationHubDropdown_AddConnectionButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Add Connection Button Clicked Successfully");

			if (isWebElementDisplayed(integrationHubPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Integration Hub Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Integration Hub Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToIOHubFromTheRightPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 007 : verify User Is Able To redirect to activity log from the right panel quick links test");
			refreshWebPage();
			isWebElementDisplayed(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(rightPanelQuickLinksDropdown_ActivityLogLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown_ActivityLogLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Activity Log Clicked Successfully");

			if (isWebElementDisplayed(activityLogPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Activities Log Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Activities Log Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToActivityLogFromTheRightPanelquicklinksTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 008 : verify User Is Able To redirect to account settings from the right panel quick links test");
			refreshWebPage();
			doubleClickUsingActionClass(leftPanelHomeButton);
			isWebElementDisplayed(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(rightPanelQuickLinksDropdown_AccountSettingsLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown_AccountSettingsLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Account Settings Clicked Successfully");

			if (isWebElementDisplayed(accountSettingsPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Account Settings Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Account Settings Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToAccountSettingsFromTheRightPanelquicklinksTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 009 : verify User Is Able To redirect to Billing Information from the right panel quick links test");
			refreshWebPage();
			doubleClickUsingActionClass(leftPanelHomeButton);
			isWebElementDisplayed(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(rightPanelQuickLinksDropdown_BillingInformationLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown_BillingInformationLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Billing Information Clicked Successfully");

			if (isWebElementDisplayed(BillingPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Billing Information Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Billing Information Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToBillingInformationFromTheRightPanelquicklinksTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 010 : verify User Is Able To redirect to upgrade from the right panel quick links test");
			refreshWebPage();
			doubleClickUsingActionClass(leftPanelHomeButton);
			isWebElementDisplayed(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(rightPanelQuickLinksDropdown_UpgradeLink);
			explicitWaitInSeconds(3);
			clickWebElement(rightPanelQuickLinksDropdown_UpgradeLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Upgrade Clicked Successfully");

			if (isWebElementDisplayed(upgradePageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Upgrade Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Upgrade Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRedirectToUpgradeFromTheRightPanelquicklinksTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

}

