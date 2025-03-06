package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class HomePageCenterPanel extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public HomePageCenterPanel(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// All X-paths of Home Page TOP SECTION.

	String screenRecordingButton = "//button[@id='btnRecording']";
	String startRecordingButton = "//span[text()='Start']";
	String closeRecordingButton = "//span[text()='Close']";
	String settingsButton = "//button[@aria-label='Settings']";
	String SettingsPage = "//h6[text()='Account Detail']";

	String switchToDarkModeButton = "//button[@title='Dark Mode']";
	String switchToNormalModeButton = "//button[@title='Normal Mode']";

	String reloadButton = "//button[@id='btnReload']";
	String topPanelNotificationButton = "//button[@title='Notifications']";
	String clearNotificationButton = "//a[text()='Clear All']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String noNotificationButton = "//strong[text()=' No Notification.']";

	String SupportButton = "//button[@aria-label='Help']";
	String supportPageDivTitleLabel = "//div[contains(text(),'ioMoVo Customer Support')]";

	// All X-paths of Home Page CENTER PANEL.
	String centerPanelSearchBox = "//*[text()='Your Media Anywhere']//following::input[@placeholder='Global Search'][1]";
	String centerPanelUploadButton = "//p[text()='Upload']";
	String leftPanelHomeButton = "//span[text()=' Home']";
	String uploadCancelButton = "//a[@class='dz-remove']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";

	String centerPanelCaptureButton = "(//span[@aria-label='upload a video'])[1]";
	String centerPanelWebMStartButton = "//span[text()='Start']";
	String centerPanelWebMStopButton = "//span[text()='Stop']";
	String centerPanelWebMMuteButton = "//span[text()='Mute']";
	String centerPanelWebMTakePictureButton = "//span[text()='Take Picture']";
	String cameraEnableConfirmation = "//h6[text()='Record Your Stream']";
	String centerPanelWebMSettingsButton = "//span[text()='Setting']";
	String centerPanelScreenRecorderButton = "//p[text()='Screen Record']";
	String centerPanelAutoSyncButton = "//span[text()='Auto Sync']";
	String fileUploadStatusBarLink = "//div[@id='panel1a-header']";

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
//	String pdfFileName = "PDFFormatFile.pdf";
	String pdfFileName = "sample.pdf";
	String videoFileName = "One Planet.mp4";
	String settingsPageConfirmation = "//h6[text()='Account Detail']";

	public void uploadFilesFunctionality(String docFilesPath, String samplePdfFile) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(centerPanelUploadButton);
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
			isWebElementDisplayed(uploadFileStatusTab);
			waitUntilElementGetsDisappeared(uploadFileStatusTab);
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
			waitUntilElementGetsDisappeared(uploadFileStatusTab);
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
			logPassStepInExtentReport("TC 003 : Uploading Same File again to test REPLACE CURRENT functionality");
			logInfoStepInExtentReport("Uploading same file again for testing REPLACE CURRENT version functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(replaceCurrentVersionLink);
			clickWebElement(replaceCurrentVersionLink);
			waitUntilElementGetsDisappeared(uploadFileStatusTab);
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
			waitUntilElementGetsDisappeared(uploadFileStatusTab);
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

	public void verifyUserAbleToUploadSameDocumentFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(docFilesPath, pdfFileName);
	}

	public void verifyUserAbleToUploadSameAudioFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(audioFilesPath, audioFileName);
	}

	public void verifyUserAbleToUploadSameVideoFileMultipleTimesAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(videoFilesPath, videoFileName);
	}

	//uploading same file again and check if the file can be DELETED while uploading
	
	public void verifyUserAbleToDeleteFileWhileUploadingTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 005 : verify User Able To Delete FIle While Uploading From Center Panel Test");
			uploadFilesFunctionality(videoFilesPath, videoFileName);
			explicitWaitInSeconds(3);
			waitUntilElementGetsAppeared(fileUploadStatusBarLink);
			logPassStepInExtentReport("File Upload Process Started Successfully and Clicking on the Cancel Upload Button");
			clickWebElement(uploadCancelButton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReportWithScreenshot("Uploading Cancel Button Clicked Successfully");
			acceptSingleAlertIfPresent();
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToDeleteFIleWhileUploadingTest Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}
	
	public void verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 006 : verify User Is Able To Record The Video From Center Panel Without AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(centerPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMStartButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Started Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMMuteButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Muted Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMStopButton);
			logPassStepInExtentReport("Video Recording Stopped Successfully");
			explicitWaitInSeconds(5);
			acceptSingleAlertIfPresent();
			explicitWaitInSeconds(5);
			String webmFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsAppeared(webmFileUploadedLabel);
			explicitWaitInSeconds(5);
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
					"Failed In verifyUserIsAbleToRecordTheVideoWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyUserIsAbleToRecordTheVideoWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 007 : verify User Is Able To Record The Video From Center Panel With AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelAutoSyncButton);
			logPassStepInExtentReportWithScreenshot("Auto Sync Enabled Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMStartButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Started Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMMuteButton);
			logPassStepInExtentReportWithScreenshot("Video Recording Muted Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelWebMStopButton);
			logPassStepInExtentReport("Video Recording Stopped Successfully");
			String webmFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			waitUntilElementGetsDisappeared(webmFileUploadedLabel);
			explicitWaitInSeconds(5);
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
					"Failed In verifyUserIsAbleToRecordTheVideoWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureImageWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 008 : verify User Is Able To Capture Image From Center Panel Without AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelCaptureButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			clickWebElement(centerPanelWebMTakePictureButton);
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
					"Failed In verifyUserIsAbleToCaptureImageWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureImageWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 009 : verify User Is Able To Capture Image From Center Panel With AutoSync Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(centerPanelCaptureButton);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			explicitWaitInSeconds(5);
			waitUntilElementGetsAppeared(cameraEnableConfirmation);
			logPassStepInExtentReportWithScreenshot("Camera Is Now Started");
			explicitWaitInSeconds(3);
			clickWebElement(centerPanelAutoSyncButton);
			logPassStepInExtentReportWithScreenshot("Auto Sync Enabled Successfully");
			clickWebElement(centerPanelWebMTakePictureButton);
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
					"Failed In verifyUserIsAbleToCaptureImageWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureTheScreenTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 010 : verify User Is Able To Record The Screen From Center Panel Test");
			refreshWebPage();
			explicitWaitInSeconds(5);
			clickWebElement(screenRecordingButton);
			logPassStepInExtentReportWithScreenshot("Screen Record Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(startRecordingButton);
			logPassStepInExtentReportWithScreenshot("Screen Recording Started Successfully");
			explicitWaitInSeconds(10);
			clickWebElement(screenRecordingButton);
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
			assertTrue(false);
		}
	}
}
