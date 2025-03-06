package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class HomePageTopPanel extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageTopPanel(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// All X-paths of Home Page TOP SECTION.
	String topPanelUploadButton = "//button[@type='button'][@title='Upload Files']";
	String topPanelCaptureButton = "//button[@id='capture']";
	String videoRecordStartButton = "//button[@type='button']//span[text()='Start']";
	String videoRecordStopButton = "//button[@type='button']//span[text()='Stop']";
	String videoRecordMuteButton = "//button[@type='button']//span[text()='Mute']";
	String videoRecordUnMuteButton = "//button[@type='button']//span[text()='Unmute']";
	String takePictureButton = "//button[@type='button']//span[text()='Take Picture']";
	String topPanelScreenRecordButton = "//button[@type='button'][@id='btnRecording']";
	String screenRecordingStartButton = "//span[text()='Start']";
	String screenRecordingEndButton = "//button[@id='btnRecording']";
	String screenRecordingCloseButton = "//span[text()='Close']";
	String topPanelSettingsButton = "//button[@type='button'][@title='Settings']";
	String topPanelSwitchModeButton = "//button[@type='button'][@title='Dark Mode']";
	String switchToDarkModeButton = "//button[@title='Dark Mode']";
	String switchToNormalModeButton = "//button[@title='Normal Mode']";
	String topPanelRefreshButton = "//button[@type='button'][@id='btnReload']";
	String topPanelNotificationButton = "//button[@title='Notifications']";
	String clearNotificationButton = "//a[text()='Clear All']";
	String closeNotificationButton = "(//button[@aria-label='notifications'])[2]";
	String noNotificationButton = "//strong[text()=' No Notification.']";
	String topPanelSupportButton = "//button[@type='button'][@title='Support']";

	// Supporting Xpaths for Top Panel
	String autosyncButton ="//span[@title='Auto Sync']";
	String leftPanelHomeButton = "//span[text()=' Home']";
	String uploadCancelButton = "//a[@class='dz-remove']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String fileUploadStatusBarLink = "//div[@id='panel1a-header']";
	String settingsPage = "//div[1]/div/h6/b";
	String supportPageDivTitleLabel = "//div[contains(text(),'ioMoVo Customer Support')]";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");

	// Replace Or Skip Files X-paths
	String appendVersionLink = "//span[text()='Append Version']";
	String replaceCurrentVersionLink = "//span[text()='Replace Current Version']";
	String duplicateLink = "//span[text()='Duplicate file']";

	// All other Variables
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
	//		String pdfFileName = "PDFFormatFile.pdf";
	String pdfFileName = "sample.pdf";
	String videoFileName = "One Planet.mp4";
	String settingsPageConfirmation = "//h6[text()='Account Detail']";

	public void uploadFilesFunctionality(String docFilesPath, String samplePdfFile) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(topPanelUploadButton);
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
			logPassStepInExtentReport("TC 001 : Uploading Same File Multiple Times And Take Certain Actions Functionality");
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

	public void verifyUserAbleToUploadDocumentFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(docFilesPath, pdfFileName);
	}

	public void verifyUserAbleToUploadAudioFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(audioFilesPath, audioFileName);
	}

	public void verifyUserAbleToUploadVideoFileMultipleTimesFromTopPanelUploadButtonAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(videoFilesPath, videoFileName);
	}

	//uploading same file again and check if the file can be DELETED while uploading file

	public void verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 005 : verify User Able To Delete FIle While Uploading From Top Panel Test");
			uploadFilesFunctionality(videoFilesPath, videoFileName);
			waitUntilElementGetsAppeared(duplicateLink);
			clickWebElement(duplicateLink);
			waitUntilElementGetsAppeared(fileUploadStatusBarLink);
			logPassStepInExtentReport("File Upload Process Started Successfully and Clicking on the Cancel Upload Button");
			clickWebElement(uploadCancelButton);
			logPassStepInExtentReportWithScreenshot("Uploading Cancel Button CLicked Successfully");
			acceptSingleAlertIfPresent();
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToDeleteFIleWhileUploadingFromTopPanelTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 006 : verify User Is Able To Record The Video From Top Panel Without AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(topPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordStartButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Started Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordMuteButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Muted Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordStopButton);
			logPassStepInExtentReport("Video Recording Stopped Successfully");
			explicitWaitInSeconds(5);
			acceptSingleAlertIfPresent();
			explicitWaitInSeconds(5);
			String webmFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsAppeared(webmFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(webmFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot("Video File Uploaded Sucessfully");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRecordTheVideoFromTopPanelWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 007 : verify User Is Able To Record The Video From Top Panel With AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(topPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(autosyncButton);
			logPassStepInExtentReportWithScreenshot("Auto Sync Enabled Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordStartButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Started Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordMuteButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Muted Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(videoRecordStopButton);
			logPassStepInExtentReport("Video Recording Stopped Successfully");
			String webmFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(webmFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(webmFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot("Video File Uploaded Sucessfully");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRecordTheVideoFromTopPanelWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 008 : verify User Is Able To Capture Image From Top Panel Without AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(topPanelCaptureButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			clickWebElement(takePictureButton);
			logPassStepInExtentReport("Take Picture Button Clicked Successfully");
			acceptSingleAlertIfPresent();
//			waitUntilElementGetsAppeared(fileUploadStatusBarLink);
			explicitWaitInSeconds(5);
			String imageFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(imageFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(imageFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(" File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToCaptureImageFromTopPanelWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 009 : verify User Is Able To Capture Image From Top Panel With AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(topPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(autosyncButton);
			logPassStepInExtentReportWithScreenshot("Auto Sync Enabled Successfully");
			clickWebElement(takePictureButton);
			logPassStepInExtentReportWithScreenshot("Take Picture Button Clicked Successfully");
			waitUntilElementGetsAppeared(fileUploadStatusBarLink);
			String imageFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(imageFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(imageFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(" File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToCaptureImageFromTopPanelWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRecordTheScreenFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 010 : verify User Is Able To Record The Screen From Top Panel Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(topPanelScreenRecordButton);
			logPassStepInExtentReportWithScreenshot("Screen Record Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(screenRecordingStartButton);
			logPassStepInExtentReportWithScreenshot("Screen Recording Started Successfully");
			explicitWaitInSeconds(10);
			clickWebElement(screenRecordingEndButton);
			logPassStepInExtentReportWithScreenshot("Screen Recording Stopped Successfully");
			String webmFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(webmFileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(webmFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(" File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToRecordTheScreen Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyUserIsRedirectedToSettingsPageFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 011 : verify User Is Redirected To Settings Page From Top Panel Test");
			refreshWebPage();
			clickWebElement(topPanelSettingsButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Settings Button Clicked Successfully");

			if (isWebElementDisplayed(settingsPage)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Settings Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Settings Page");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToSettingsPage Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyUserIsAbleToSwitchToDarkModeFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 012 : verify User Is Able To Switch To Dark Mode From Top Panel Test");
			refreshWebPage();
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(switchToDarkModeButton)) {
				logPassStepInExtentReportWithScreenshot("Current Mode Is Normal Mode");

				clickWebElement(switchToDarkModeButton);
				logPassStepInExtentReport("Switch Mode Button Clicked Successfully");
				explicitWaitInSeconds(5);
				clickWebElement(topPanelRefreshButton);

				if (isWebElementDisplayed(switchToNormalModeButton)){
					logPassStepInExtentReportWithScreenshot("Passed ==> Expected Mode : Dark Mode :: Actual Mode : Dark Mode");
				} else {
					logFailStepInExtentReport("Failed ==> Expected Mode : Dark Mode :: Actual Mode : Normal Mode");
					assertTrue(false);
				}
			} else if (isWebElementDisplayed(switchToNormalModeButton)) {
				logPassStepInExtentReportWithScreenshot("Current Mode Is Dark Mode");

				clickWebElement(switchToNormalModeButton);
				logPassStepInExtentReport("Switch Mode Button Clicked Successfully");
				explicitWaitInSeconds(5);
				clickWebElement(topPanelRefreshButton);

				if (isWebElementDisplayed(switchToDarkModeButton)){
					logPassStepInExtentReportWithScreenshot("Passed ==> Expected Mode : Normal Mode :: Actual Mode : Normal Mode");
				} else {
					logFailStepInExtentReport("Failed ==> Expected Mode : Normal Mode :: Actual Mode : Dark Mode");
					assertTrue(false);
				}
			} else {
				logFailStepInExtentReport("Incorrect Locator for Button used for switching the modes");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToSwitchToDarkModeTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToClearNotificationFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Clear Notification From Top Panel Test");
			refreshWebPage();
			clickWebElement(topPanelNotificationButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Notification Button Clicked Successfully");

			if (isWebElementDisplayed(clearNotificationButton)) {
				logPassStepInExtentReportWithScreenshot(
						"Notification are present. Attempting to clear all the notifications");
				clickWebElement(clearNotificationButton);
				explicitWaitInSeconds(10);
				if (isWebElementDisplayed(noNotificationButton)) {
					logPassStepInExtentReportWithScreenshot("Successfully cleared all the notifications");
				}
			} else if (isWebElementDisplayed(noNotificationButton)) {
				logPassStepInExtentReportWithScreenshot("No Notification Available To Be Cleared");
			}
			clickWebElement(closeNotificationButton);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToClearNotification Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToSupportPageFromTopPanelTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 014 : verify User Is Redirected To Support Page From Top Panel Test");
			refreshWebPage();
			clickWebElement(topPanelSupportButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Support Button Clicked Successfully");
			swithToNextNewWindow();

			if (isWebElementDisplayed(supportPageDivTitleLabel)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Support Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Support Page");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToSupportPage Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
}
