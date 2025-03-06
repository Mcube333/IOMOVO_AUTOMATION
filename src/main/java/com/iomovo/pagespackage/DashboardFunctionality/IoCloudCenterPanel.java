package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class IoCloudCenterPanel extends BaseClass {
	
	public IoCloudCenterPanel(WebDriver driver, WebDriverWait wait) {
		BaseClass.driver = driver;
        BaseClass.wait = wait;
	}

	// All X-Paths after selecting a file in IoCloud.
	String leftPanelHomeButton = "//span[text()=' Home']";

	String leftpanelIOCloudButton = "//span[text()='ioCloud']";
	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String leftPanelIOCloud_Recent = "//div[text()='Recent']";
	String leftPanelIOCloud_SharedWithMe = "//div[text()='Shared With Me']";
	String leftPanelIOCloud_SharedByMe = "//div[text()='Shared By Me']";
	String leftPanelIOCloud_RecycleBin = "//div[text()='Recycle Bin']";

	String emptyRecycleBinConfirmtion = "//img[@class='jss1391']";

	String ioCloudAddFolder = "//span[text()='Add Folder']";
	String ioCloudFolderNameTextBox = "//input[@id='standard-basic' and @type='text']";
	String ioCloudSaveFolderButton = "//span[text()='Save']";
	String ioCloudAddProject = "//span[text()='Add Project']";
	String ioCloudUpload = "//span[text()='Upload']";
	String ioCloudCapture = "//span[text()='Capture']";
	String ioCloudSelectAllButton = "//span[text()='Select All']";
	String SelectAllFilesConfirmation = "//input[@type='checkbox']";
	String ioCloudSelectAllDisabledButton = "//button[@disabled]";
	String ioCloudClearSectionButton = "//span[text()='Clear Selection']";
	String ioCloudPinToTopButton = "//span[text()='Pin to Top']";
	String ioCloudUnPinButton = "//span[text()='Unpin']";
	String pinnedConfirmation = "//td//div//div//img[@alt='Pin to Top']";
	String File1 = "(//td//input[@type='checkbox'])[1]";
	String File2 = "(//td//input[@type='checkbox'])[2]";
	String File3 = "(//td//input[@type='checkbox'])[3]";
	String ioCloudBatchUpdateButton = "//span[text()='Batch Update']";
	String ioCloudShareButton = "//span[text()='Share']";
	String ioCloudDownloadButton = "//span[text()='Download']"; 
	String ioCloudZipButton = "//span[text()='Zip']";
	String ioCloudUnZipButton = "//span[text()='Unzip']";
	String ioCloudRenameButton = "Rename";
	String ioCloudCopyButton = "//span[text()='Copy']";
	String ioCloudDataFolder = "//td//div//a[text()='Data']";
	String copyingFileLink = "//a[contains(text(),'5000')]";
	String selectCheckBox = "(//tr//td[1]//span//input)";
	String selectedFolderElipseButton = "//button[@type='button']//following::td[@data-name='Destination Folder']";
	String copyingTable = "//table[@aria-label='sticky table']";
	String copyingFolderlink = "//td//div//a[text()='Sample Folder']";
	String dataCopyingDestination = "//li//span[text()='Destination Folder']";
	String multipleDataFileCopyingDestination = "//td//div//a[text()='Destination Folder']";
	String CopyButton = "//a//span[text()='Copy']";
	String copyConfirmationButton = "(//a[@role='button'])[3]";
	String ioCloudMoveButton = "//span[text()='Move']";
	String ioCloudDeleteButton = "//span[text()='Delete']";
	String ioCloudElipsebutton = "//Button[@id='menu-icon']";
	String ioCloudPastebutton = "//span[text()='Paste']";
	String ioCloudElipseOpenButton = "//div[text()='Open']";
	String ioCloudElipseRenameButton = "//p[text()='Rename']";
	String ioCloudElipseCopyButton = "//p[text()='Copy']";
	String ioCloudElipsePasteButton = "//p[text()='Paste']";
	String ioCloudElipseMoveButton = "//p[text()='Move']";
	String ioCloudElipseDeleteButton = "//p[text()='Delete']";
	String ioCloudSwitchToListViewButton = "//button[@title='Switch to List View']";
	String ioCloudSortRecord = "//button[@aria-controls='sorting-menu']";

	String ioCloudFilesFolder = "//a[text()='Files.']";
	String myFilesioCloudLink = "(//a[text()='ioCloud'])[2]";
	String myFilesioCloud = "//a[text()='ioCloud']";
	String iocloudSelectZipFolder = "//span[text()='Zip Folder']";
	String iocloudSelectUnZipFolder = "//span[text()='Unzipped Files']";
	String zipButton = "//span[text()='Zip' and @class='MuiButton-label' ]";
	String UnzipButton = "//span[text()='Unzip' and @class='MuiButton-label' ]";
	String zipCreatedNotification = "//p[text()='Your zip file is ready to download.']";
	String unZippedNotification = "//p[text()='Unzip completed successfully.']";
	String openZipFileCreatedLink = "//a[text()='Open File Location']";
	String selectZipFileCheckbox = "(//input[@type='checkbox'])[2]";

	String sortingFilesFolderLink = "//a[text()='Sorting Files']";
	String ioCloudSortRecordsButton = "//Button[@title='Sort records']";
	String ioCloudSortAscendingLink = "//p[text()='Ascending']";
	String ascendingConfirmation = "//li[contains(@class, 'Mui-selected')]//p[text()='Ascending']";
	String ioCloudSortDescendingLink = "//p[text()='Descending']";
	String descendingConfirmation = "//li[contains(@class, 'Mui-selected')]//p[text()='Descending']";
	String ioCloudSortByNameLink = "//p[text()='Sort by Name']";
	String sortByNameConfirmation = "//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Name']";
	String ioCloudSortBySizeLink = "//p[text()='Sort by Size']";
	String sortBySizeConfirmation = "//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Size']";
	String ioCloudSortByDateLink = "//p[text()='Sort by Date']";
	String sortByDateConfirmation = "//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Date']";

	String SwitchToGridViewButton = "//button[@title='Switch to Grid View']";
	String SwitchToListViewButton = "//button[@title='Switch to List View']";

	String ioCloudDeleteRecover = "//button[@title='Recover']";
	String ioCloudDeleteEmptyTrash = "//span[text()='Empty Trash']";

	String ioCloudMyfilesVideoFileLink = "//a[text()='One Planet.mp4']";
	String iocloudMyfilesVideoFileElipseButton = "//a[text()='One Planet.mp4']//following::td[5]";
	String iocloudMyfilesElipseButtonMenuOpenNewTabButton = "//div[text()='Open (new tab)']";
	String VideoFileConfirmation = "//h2[text()='One Planet.mp4']";
	String ioCloudMyfilesAudioFileLink = "//a[text()='BesharamRang.mp3']";
	String iocloudMyfilesAudioFileElipseButton = "//a[text()='BesharamRang.mp3']//following::td[5]";
	String AudioFileConfirmation = "//h2[text()='BesharamRang.mp3']";
	String ioCloudMyFilesMovingFolder1link = "//a[text()='MovingFolder1']";
	String iocloudMyfilesMovingFolderElipseButton = "//a[text()='MovingFolder1']//following::td[5]";
	String iocloudMyFilesSubMenuLoadMoreButton = "//a//span[text()='Load More']";
	String iocloudMyFilesSubMenuProject1Link ="//span[text()='Project 1']";
	String iocloudMyFilesSubMenuMoveButton ="//a//span[text()='Move']";

	String iocloudMyFilesRenameFileLink = "//a[text()='Renaming File.mov']";
	String iocloudMyfilesRenameFileElipseButton = "//a[text()='Renaming File.mov']//following::td[5]";
	String iocloudMyFilesRenameFolderLink = "//a[text()='RenameMe']";
	String iocloudMyfilesRenameFolderElipseButton = "//a[text()='RenameMe']//following::td[5]";
	String iocloudMyfilesElipseMenuRenameButton = "//a[text()='Rename']";
	String iocloudMyfilesRenameTextBox = "//div//input[@type='text' and @id='standard-basic1']";
	String iocloudMyfilesRenameSaveButton = "//span[text()='Save']";
	String iocloudMyFilesNameSortLink = "//th[text()='Name']";

	String iocloudDeleteMyFilesFolderName = "//td[3]/div/a[text()='DeleteMyFiles']";
	String iocloudDeleteMyFilesFolder = "//td[8][@data-name='DeleteMyFiles']/div/button[@type='button']";

	String iocloudMyFilesSourceFileLink = "//a[text()='TOI Delhi 27 Feb 2023.pdf']";  
	String iocloudMyFilesDestinationFileLink = "//a[text()='DragandDropFolder']";
	String iocloudMyFilesSourceFileLinkGrid = "//p[text()='TOI Delhi 27 Feb 2023.pdf']";
	String iocloudMyFilesDestinationFileLinkGrid = "//span[text()='DragandDropFolder']";
	
	String iocloudMyFilesBilingPaymentMethodsButton = "//li[text()='Payment Methods']";
	String iocloudMyFilesBilingAddPaymentMethodsButton = "//span[text()='Add Payment Method']";
	String iocloudMyFilesCCAddPaymentMethodHeading = "//h2[text()='Add Payment Method']";
	String iocloudMyFilesCCFullName = "//input[@id='Field-nameInput']";
	String iocloudMyFilesCCCountryDropdown = "//select[@id='Field-countryInput']";
	String iocloudMyFilesCCCountry = "//option[@value='IN' and text()='India']";
	String iocloudMyFilesCCAddressLine1	= "//input[@id='Field-addressLine1Input']";
	String iocloudMyFilesCCAddressLine2 = "//input[@id='Field-addressLine2Input']";
	String iocloudMyFilesCCCity = "//input[@id='Field-localityInput'] 	";
	String iocloudMyFilesCCStateDropdown = "//select[@id='Field-administrativeAreaInput']";
	String iocloudMyFilesCCState = "//option[@value='Karnataka']";
	String iocloudMyFilesCCZip = "//input[@id='Field-postalCodeInput']";
	String iocloudMyFilesCCCardNumber = "//input[@name='cardnumber']";
	String iocloudMyFilesCCExpiryDate = "//input[@name='exp-date']";
	String iocloudMyFilesCCCvv = "//input[@name='cvc']";
	String iocloudMyFilesCCDefultMethodCheckBox = "//input[@name='Set as default method']";
	String iocloudMyFilesCCAddNowButton = "//span[@id='button-text']";
	
	
	// Other XPath expressions...
	String topPanelSettingsButton = "//button[@type='button'][@title='Settings']";
	String viewAccountBillingPageButton = "//span[text()='Billing']";
	String topPanelNotificationButton = "//button[@aria-label='notifications']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String centerPanelWebMStartButton = "//span[text()='Start']";
	String centerPanelWebMStopButton = "//span[text()='Stop']";
	String centerPanelWebMMuteButton = "//span[text()='Mute']";
	String centerPanelWebMTakePictureButton = "//span[text()='Take Picture']";
	String centerPanelAutoSyncButton = "//span[text()='Auto Sync']";
	String cameraEnableConfirmation = "//h6[text()='Record Your Stream']";
	String fileUploadStatusBarLink = "//div[@id='panel1a-header']";
	String dragAndDropFolder = "//a[text()='DragandDrop Folder']";
	String fileToDrag = "//a[text()='Dainik Jagran27Feb2023.pdf']";
	String fileToDrop = "//a[text()='Drop Folder']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");
	String strFileRename = prop.getProperty("strFileRename");
	
	String CCFullName = prop.getProperty("Mudassir");			
	String CCCountryOrRegion = prop.getProperty("India");
	String CCAddressLine1 = prop.getProperty("BTM");
	String CCAddressLine2 = prop.getProperty("1stStage");
	String CCCity = prop.getProperty("Bengaluru");
	String CCState = prop.getProperty("Karnataka");
	String CCZip = prop.getProperty("560029");
	String CCCardNumber = prop.getProperty("4000056655665556"); 
	String CCExpiryDate = prop.getProperty("12/26");
	String CCCVV = prop.getProperty("333");
	
	
	// Append,Replace,Duplicate Files X-paths
	String appendVersionLink = "//span[text()='Append Version']";
	String replaceCurrentVersionLink = "//span[text()='Replace Current Version']";
	String duplicateLink = "//span[text()='Duplicate file']";

	// All other Variables
	String audioFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles";
	String docFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles";
	String videoFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles";
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


	public void verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest(String folderName) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 001: verify User Able To Add Folder From Left Panel MyFiles Functionality Test");
//			doubleClickUsingActionClass(leftPanelHomeButton);
			clickWebElement(leftpanelIOCloudButton);
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files Button Clicked Successfully");
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudAddFolder);
			logPassStepInExtentReport("Add Folder Button Clicked Successfully");
			explicitWaitInSeconds(3);
			setTextAndClickEnterInTextField(ioCloudFolderNameTextBox, "testfolder");
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			String folderCreationSuccessMessage = "//p[contains(text(),'has been created')]";
			waitUntilElementGetsAppeared(folderCreationSuccessMessage);
			explicitWaitInSeconds(10);

			if (isWebElementDisplayed(folderCreationSuccessMessage)) {
				logPassStepInExtentReportWithScreenshot("Folder Successfully Created");
			} else {
				logFailStepInExtentReport("Failed to Create Folder");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToAddFolderFromLeftPanelMyFilesFunctionalityTest Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest(String ProjectName) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 002: verify User Able To Add Project From Left Panel MyFiles Functionality Test");
//			doubleClickUsingActionClass(leftPanelHomeButton);
			clickWebElement(leftpanelIOCloudButton);
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files Button Clicked Successfully");
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudAddProject);
			logPassStepInExtentReport("Add Project Button Clicked Successfully");
			explicitWaitInSeconds(3);
			setTextAndClickEnterInTextField(ioCloudFolderNameTextBox, "Auto Test Project");
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			String folderCreationSuccessMessage = "//p[contains(text(),'has been created')]";
			waitUntilElementGetsAppeared(folderCreationSuccessMessage);
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(folderCreationSuccessMessage)) {
				logPassStepInExtentReportWithScreenshot("Project Successfully Created");
			} else {
				logFailStepInExtentReport("Failed to Create Project");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToAddProjectFromLeftPanelMyFilesFunctionalityTest Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void uploadFilesFunctionality(String docFilesPath, String samplePdfFile) throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			doubleClickUsingActionClass(leftpanelIOCloudButton);
			clickWebElement(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudUpload);
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
			logPassStepInExtentReport("TC 003: verify User Able To Upload File From IoCloud MyFiles Functionality Test");
			logInfoStepInExtentReport("Uploading a file for the first time");
			uploadFilesFunctionality(filesPath, fileName);
			explicitWaitInSeconds(5);
			String docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			explicitWaitInSeconds(3);
			clickWebElement(topPanelNotificationButton);
			isWebElementDisplayed(docFileUploadedLabel);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			explicitWaitInSeconds(5);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing APPEND functionality
			logInfoStepInExtentReport("Uploading same file again for testing append functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(appendVersionLink);
			clickWebElement(appendVersionLink);
			explicitWaitInSeconds(5);
			docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			isWebElementDisplayed(docFileUploadedLabel);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing REPLACE AND CURRENT VERSION functionality
			logInfoStepInExtentReport("Uploading same file again for testing replace and current version functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(replaceCurrentVersionLink);
			clickWebElement(replaceCurrentVersionLink);
			explicitWaitInSeconds(5);
			docFileUploadedLabel = "//p[contains(text(),'has been uploaded')]";
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			isWebElementDisplayed(docFileUploadedLabel);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			// Uploading same file again for testing DUPLICATE functionality
			logInfoStepInExtentReport("Uploading same file again for testing Duplicate functionality");
			uploadFilesFunctionality(filesPath, fileName);
			waitUntilElementGetsAppeared(duplicateLink);
			clickWebElement(duplicateLink);
			explicitWaitInSeconds(5);
			String fileExtension = fileName.split("\\.")[1];
			fileName = fileName.replace("." + fileExtension, "_");
			docFileUploadedLabel = "(//p[contains(text(),'has been uploaded')])[1]";
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			isWebElementDisplayed(docFileUploadedLabel);
			waitUntilElementGetsAppeared(docFileUploadedLabel);
			if (isWebElementDisplayed(docFileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(fileName + " File Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(fileName + " File Not Uploaded ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);

		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToUploadFilesAndTakeCertainActions Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(docFilesPath, pdfFileName);
	}

	public void verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(audioFilesPath, audioFileName);
	}

	public void verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest() throws Exception {
		uploadSameFileMultipleTimesAndTakeCertainActionsFunctionality(videoFilesPath, videoFileName);
	}

	public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Is Able To Capture Image From IoCloud Capture Section Without Auto Sync Test");
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudCapture);
			logPassStepInExtentReportWithScreenshot("Capture Button Clicked Successfully");
			waitUntilElementGetsAppeared(cameraEnableConfirmation);
			logPassStepInExtentReportWithScreenshot("Camera Is Now Started");
			clickWebElement(centerPanelWebMTakePictureButton);
			logPassStepInExtentReport("Take Picture Button Clicked Successfully");
			acceptSingleAlertIfPresent();
			waitUntilElementGetsAppeared(fileUploadStatusBarLink);
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
					"Failed In verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Capture Image From IoCloud Capture Section With AutoSync Test");
			clickWebElement(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudCapture);
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
					"Failed In verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Record The Video From IoCloud Capture Section Without Auto Sync Test");
			clickWebElement(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudCapture);
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
					"Failed In verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Record The Video From IoCloud Capture Section With AutoSync Test");
			clickWebElement(leftPanelIOCloud_MyFiles);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudCapture);
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
					"Failed In verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFilesFunctionalityTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 000 : verify User Able To Select All And Clear Selected Files From IoCloud MyFiles Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My files Button Clicked Successfully");
			explicitWaitInSeconds(5);
			if (isWebElementDisplayed(ioCloudSelectAllButton)) {
				logPassStepInExtentReportWithScreenshot("Files are present. Selecting all Files Present in the IoCloud");
				clickWebElement(ioCloudSelectAllButton);
				explicitWaitInSeconds(3);
				WebElement checkbox = uiElement(SelectAllFilesConfirmation);
				if (checkbox.isSelected()) {
					int textboxCount = uiElements(SelectAllFilesConfirmation).size();
					logPassStepInExtentReport("Count of Files Present and Selected in the IoCloud: " + textboxCount);
				} else {
					logPassStepInExtentReport("Checkbox is not selected.");
				}
				isWebElementDisplayed(ioCloudClearSectionButton);
				logPassStepInExtentReportWithScreenshot("Clear section Button Visible Clicking on the Button");
				explicitWaitInSeconds(5);
				clickWebElement(ioCloudClearSectionButton);
			}	
		}catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToSelectAllAndClearSelectedFilesFromIoCloudMyFiles Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 000 : verify User Able To Zip And Unzip Files From IoCloud MyFiles Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My files Button Clicked Successfully");
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(ioCloudFilesFolder);
			explicitWaitInSeconds(5);
			if (isWebElementDisplayed(ioCloudSelectAllButton)) {
				logPassStepInExtentReportWithScreenshot("Files are present. Selecting all Files Present in the IoCloud");
				clickWebElement(ioCloudSelectAllButton);
				explicitWaitInSeconds(3);
				WebElement checkbox = uiElement(SelectAllFilesConfirmation);
				if (checkbox.isSelected()) {
					int textboxCount = uiElements(SelectAllFilesConfirmation).size();
					logPassStepInExtentReport("Count of Files Present and Selected in the IoCloud: " + textboxCount);
				} else {
					logPassStepInExtentReport("Checkbox is not selected.");
				}
				isWebElementDisplayed(ioCloudZipButton);
				logPassStepInExtentReport("Zip Button Visible Clicking on the Zip Button");
				explicitWaitInSeconds(5);
				clickWebElement(ioCloudZipButton);
				explicitWaitInSeconds(5);
				clickWebElement(myFilesioCloudLink);
				explicitWaitInSeconds(5);
				clickWebElement(iocloudSelectZipFolder);
				logPassStepInExtentReport("Clicking on IoCloud Selecting Zip Folder To store zip File");
				explicitWaitInSeconds(5);
				clickWebElement(zipButton);
				String zipFileCreatedLabel = "//p[text()='Your zip file is ready to download.']";
				waitUntilElementGetsDisappeared(zipFileCreatedLabel);
				clickWebElement(topPanelNotificationButton);
				if (isWebElementDisplayed(zipFileCreatedLabel)) {
					logPassStepInExtentReportWithScreenshot(" Zip File Created Sucessfully ");
				} else {
					logFailStepInExtentReport(" Failed To Create Zip File ");
					assertTrue(false);
				}
				explicitWaitInSeconds(5);
				logPassStepInExtentReportWithScreenshot(" Clicking On Open File Location To Initiate The UnZip Process");
				clickWebElement(openZipFileCreatedLink);
				explicitWaitInSeconds(5);
				clickWebElement(closeNotificationButton);
				explicitWaitInSeconds(5);
				clickWebElement(selectZipFileCheckbox);
				isWebElementDisplayed(ioCloudUnZipButton);
				logPassStepInExtentReportWithScreenshot(" Unzip Button Visible Clicking on the Button");
				clickWebElement(ioCloudUnZipButton);
				explicitWaitInSeconds(5);
				clickWebElement(myFilesioCloudLink);
				explicitWaitInSeconds(5);
				logPassStepInExtentReport(" Selecting The Unzipped Folder To Unzip the File Selected");
				clickWebElement(iocloudSelectUnZipFolder);
				explicitWaitInSeconds(5);
				logPassStepInExtentReport("Unzip Button Clicked Successfully");
				clickWebElement(UnzipButton);
				String unzipFileCreatedLabel = "//p[text()='Unzip completed successfully.']";
				waitUntilElementGetsDisappeared(unzipFileCreatedLabel);
				clickWebElement(topPanelNotificationButton);
				if (isWebElementDisplayed(unzipFileCreatedLabel)) {
					logPassStepInExtentReportWithScreenshot(" UnZip File Process Completed successfully ");
				} else {
					logFailStepInExtentReport(" Failed To Un-Zip File ");
					assertTrue(false);
				}
				clickWebElement(closeNotificationButton);
			}	
		}catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToSortRecordsFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("verify User Able To Sort Records From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My files Button Clicked Successfully");
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(sortingFilesFolderLink);
			logPassStepInExtentReport("Sorting Button Clicked Successfully");
			explicitWaitInSeconds(5);

			clickWebElement(ioCloudSortRecord);
			logPassStepInExtentReport("TC 013 : Verify User Able To Sort Records By Ascending Order From IoCloud MyFiles");
			isWebElementDisplayed(ioCloudSortAscendingLink);
			logPassStepInExtentReport("Clicked On Sort Ascending Button");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudSortAscendingLink);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'Mui-selected')]//p[text()='Ascending']")));
			String selectedOptionClass = driver.findElement(By.xpath("//li[contains(@class, 'Mui-selected')]")).getAttribute("class");
			assertTrue(selectedOptionClass.contains("Mui-selected"));
			logPassStepInExtentReportWithScreenshot(" Data Sorted Successfully By ASCENDING ");
			explicitWaitInSeconds(5);

			clickWebElement(ioCloudSortRecord);
			logPassStepInExtentReport("TC 013 : Verify User Able To Sort Records By Descending Order From IoCloud MyFiles");
			isWebElementDisplayed(ioCloudSortDescendingLink);
			logPassStepInExtentReport("Clicked On Sort Descending Button");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudSortDescendingLink);
			// Wait for the sorting process to complete
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'Mui-selected')]//p[text()='Descending']")));
			// Get the class attribute of the selected sorting option
			selectedOptionClass = driver.findElement(By.xpath("//li[contains(@class, 'Mui-selected')]")).getAttribute("class");
			// Verify that the Descending sorting option is selected
			assertTrue(selectedOptionClass.contains("Mui-selected"));
			logPassStepInExtentReportWithScreenshot(" Data Sorted Successfully By DESCENDING ");
			explicitWaitInSeconds(5);

			clickWebElement(ioCloudSortRecord);
			logPassStepInExtentReport("TC 013 : Verify User Able To Sort Records By Name From IoCloud MyFiles");
			isWebElementDisplayed(ioCloudSortByNameLink);
			logPassStepInExtentReport("Clicked On Sort By Name Button");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudSortByNameLink);
			// Wait for the sorting process to complete
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Name']")));
			// Get the class attribute of the selected sorting option
			selectedOptionClass = driver.findElement(By.xpath("//li[contains(@class, 'Mui-selected')]")).getAttribute("class");
			// Verify that the Sort by Name option is selected
			assertTrue(selectedOptionClass.contains("Mui-selected"));
			logPassStepInExtentReportWithScreenshot(" Data Sorted Successfully By Name ");
			explicitWaitInSeconds(5);

			clickWebElement(ioCloudSortRecord);
			logPassStepInExtentReport("TC 013 : Verify User Able To Sort Records By Size From IoCloud MyFiles");
			isWebElementDisplayed(ioCloudSortBySizeLink);
			logPassStepInExtentReport("Clicked On Sort By Size Button");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudSortBySizeLink);
			// Wait for the sorting process to complete
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Size']")));
			// Get the class attribute of the selected sorting option
			selectedOptionClass = driver.findElement(By.xpath("//li[contains(@class, 'Mui-selected')]")).getAttribute("class");
			// Verify that the Sort by Size option is selected
			assertTrue(selectedOptionClass.contains("Mui-selected"));
			logPassStepInExtentReportWithScreenshot(" Data Sorted Successfully By Size ");
			explicitWaitInSeconds(5);

			clickWebElement(ioCloudSortRecord);
			logPassStepInExtentReport("TC 013 : Verify User Able To Sort Records By Date From IoCloud MyFiles");
			isWebElementDisplayed(ioCloudSortByDateLink);
			logPassStepInExtentReportWithScreenshot("Clicked On Sort By Date Button");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudSortByDateLink);
			// Wait for the sorting process to complete
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@class, 'Mui-selected')]//p[text()='Sort by Date']")));
			// Get the class attribute of the selected sorting option
			selectedOptionClass = driver.findElement(By.xpath("//li[contains(@class, 'Mui-selected')]")).getAttribute("class");
			// Verify that the Sort by Date option is selected
			assertTrue(selectedOptionClass.contains("Mui-selected"));
			logPassStepInExtentReportWithScreenshot(" Data Sorted Successfully By Date ");
			explicitWaitInSeconds(5);
		}catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToSortRecordsFromIoCloudMyFiles Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Switch Files To List And GridView From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(SwitchToGridViewButton)) {
				logPassStepInExtentReportWithScreenshot("Files already sorted in the List View. Clicking the Grid View button");
				clickWebElement(SwitchToGridViewButton);
				explicitWaitInSeconds(5);
				refreshWebPage();
				if (isWebElementDisplayed(SwitchToListViewButton)) {
					logPassStepInExtentReportWithScreenshot("Successfully switched files to Grid View");
				}
				explicitWaitInSeconds(5);
			} if (isWebElementDisplayed(SwitchToListViewButton)) {
				logPassStepInExtentReportWithScreenshot(" Files sorted in the Grid View.Switching back to the List View");
				clickWebElement(SwitchToListViewButton);
				explicitWaitInSeconds(5);
				refreshWebPage();
				if (isWebElementDisplayed(SwitchToGridViewButton)) {
					logPassStepInExtentReportWithScreenshot("Successfully switched files to List View");
				} else {
					logFailStepInExtentReport("Failed to switch to List View");
					assertTrue(false);
				}
			} else {
				logFailStepInExtentReport("Switch buttons not found on the page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToPinAndUnPinFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : Verify User Able To Pin File ");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			clickWebElement(File1);
			logPassStepInExtentReport(" File1 Selected ");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudPinToTopButton);
			logPassStepInExtentReport(" Pin To Top Button Clicked Successfully");
			explicitWaitInSeconds(5);
			if (isWebElementDisplayed(pinnedConfirmation)) {
				logPassStepInExtentReportWithScreenshot("File Pinned Successfully");
			}else {
				logFailStepInExtentReport(" Failed To Pin File ");
				assertTrue(true);
			}
			explicitWaitInSeconds(5);
			refreshWebPage();

			logPassStepInExtentReport("TC 013 : Verify User Able To Un-Pin File");
			clickWebElement(File1);
			logPassStepInExtentReport(" File1 Selected ");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudUnPinButton);
			logPassStepInExtentReport(" UnPin Button Clicked Successfully");
			explicitWaitInSeconds(5);
			if (!isWebElementDisplayed(pinnedConfirmation)) {
				logPassStepInExtentReportWithScreenshot(" Un-Pinned File Successfully ");
			}else {
				logFailStepInExtentReport(" Failed To Un-Pin File ");
				assertTrue(false);
			}
			explicitWaitInSeconds(5);
			refreshWebPage();

			logPassStepInExtentReport("TC 013 : Verify User Able To Pin Multiple Files ");
			logPassStepInExtentReport(" Verify User Able To Pin Multiple Files");
			clickWebElement(File1);
			logPassStepInExtentReport(" File1 Selected ");
			explicitWaitInSeconds(3);
			clickWebElement(File2);
			logPassStepInExtentReport(" File2 Selected ");
			explicitWaitInSeconds(5);
			clickWebElement(ioCloudPinToTopButton);
			logPassStepInExtentReport(" Pin To Top Button Clicked Successfully");
			explicitWaitInSeconds(5);
			if (isWebElementDisplayed(pinnedConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Files Pinned Successfully");
			} else {
				logFailStepInExtentReport("Failed To Pin Files");
				assertTrue(true);
			}
			explicitWaitInSeconds(5);
			refreshWebPage();

			logPassStepInExtentReport("TC 013 : Verify User Able To Un-Pin Multiple Files");
			clickWebElement(File1);
			logPassStepInExtentReport(" File1 Selected ");
			explicitWaitInSeconds(3);
			clickWebElement(File2);
			logPassStepInExtentReport(" File2 Selected ");
			clickWebElement(ioCloudUnPinButton);
			explicitWaitInSeconds(5);
			if (!isWebElementDisplayedAndEnabled(pinnedConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Files Unpinned Successfully");
			} else {
				logFailStepInExtentReport("Failed To Unpin Files");
				assertTrue(false);
			}
			explicitWaitInSeconds(5);
			refreshWebPage();

			logPassStepInExtentReport("TC 013 : Verify User Able To Pin with Different Sort Order");
			logPassStepInExtentReport(" Sorting Button Clicked Successfully ");
			clickWebElement(ioCloudSortRecord);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport(" Sort By Date Button Clicked Successfully ");
			clickWebElement(sortByDateConfirmation);
			clickWebElement(File3);
			logPassStepInExtentReport(" File3 Selected ");
			clickWebElement(ioCloudPinToTopButton);
			logPassStepInExtentReport(" Pin To Top Button Clicked Successfully");
			if (!isWebElementDisplayedAndEnabled(pinnedConfirmation)) {
				logPassStepInExtentReportWithScreenshot("File Pinned Successfully");
			} else {
				logFailStepInExtentReport("Failed To Pin Files");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToPinAndUnPinFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	/* Need To Add PreRequisite For The Copy Functionality Before Running The test Case */

	public void verifyUserAbleToCopyFilesFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : Verify that a single file can be successfully copied to a destination.");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			clickWebElement(copyingFileLink);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudElipsebutton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport(" Selected The File And Copying The File to Destination ");
			clickWebElement(ioCloudElipseCopyButton);
			isWebElementDisplayed(dataCopyingDestination);
			explicitWaitInSeconds(3);
			clickWebElement(dataCopyingDestination);
			explicitWaitInSeconds(5);
			clickWebElement(CopyButton);
			String fileUploadedLabel = "//p[contains(text(),'completed')]";
			waitUntilElementGetsDisappeared(fileUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(fileUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(" File Sucessfully Copied");
			} else {
				logFailStepInExtentReport(" File Not Copied ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			refreshWebPage();
			logPassStepInExtentReport("TC 013 Verify that multiple files can be copied simultaneously to a destination ");
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(ioCloudDataFolder);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudSelectAllButton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport(" Opening Data Folder And Selecting All Files And Copying The Files");
			clickWebElement(ioCloudCopyButton);
			explicitWaitInSeconds(3);
			clickWebElement(myFilesioCloud);
			explicitWaitInSeconds(5);
			clickUsingActionClass(multipleDataFileCopyingDestination);
			doubleClickUsingActionClass(multipleDataFileCopyingDestination);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport(" Selecting The Destination Folder To Paste The Copied Files ");
			clickWebElement(ioCloudPastebutton);
			explicitWaitInSeconds(3);
			clickWebElement(copyConfirmationButton);
			explicitWaitInSeconds(10);
			String filesUploadedLabel = "//p[contains(text(),'completed')]";
			waitUntilElementGetsDisappeared(filesUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(filesUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot(" Files Sucessfully Uploaded");
			} else {
				logFailStepInExtentReport(" File Not Uploaded ");
				assertTrue(true);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);

			refreshWebPage();
			logPassStepInExtentReport(" TC 013 : Verify that a folder and its contents can be copied to a destination folder.");
			clickWebElement(ioCloudSortRecord);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudSortByNameLink);			
			explicitWaitInSeconds(3);
			isWebElementDisplayed(copyingFolderlink);
			clickWebElement(copyingFolderlink);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudElipsebutton);
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudElipseCopyButton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport(" Folder Visible -- Selecting the folder to COPY ");
			explicitWaitInSeconds(3);
			scrollToElement(dataCopyingDestination);
			isWebElementDisplayed(dataCopyingDestination);
			explicitWaitInSeconds(3);
			clickWebElement(dataCopyingDestination);
			logPassStepInExtentReport(" Selected The Folder And Copying The Folder to Destination ");
			explicitWaitInSeconds(5);
			clickWebElement(CopyButton);
			logPassStepInExtentReport("Clicked on Copy button");
			String folderUploadedLabel = "//p[contains(text(),'completed')]";
			waitUntilElementGetsDisappeared(folderUploadedLabel);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(folderUploadedLabel)) {
				logPassStepInExtentReportWithScreenshot("Folder Copied Successfully");
			} else {
				logFailStepInExtentReport("Folder Not Copied");
				assertTrue(false);
			}
			clickWebElement(closeNotificationButton);
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToCopyFilesFromIoCloudMyFiles Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToDragAndDropFileFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Drag And Drop File From IoCloud MyFiles Test");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);

			clickWebElement(SwitchToGridViewButton);
			explicitWaitInSeconds(3);
			WebElement sourceElement = uiElement(iocloudMyFilesSourceFileLinkGrid);
			WebElement targetElement = uiElement(iocloudMyFilesDestinationFileLinkGrid);

			// Create an Actions object
			Actions actions = new Actions(driver);
			explicitWaitInSeconds(3);
			// Perform drag-and-drop
			logPassStepInExtentReportWithScreenshot("Source file Selected for drag and drop task");
			actions.dragAndDrop(sourceElement, targetElement).build().perform();
			explicitWaitInSeconds(3);
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToDragAndDropFileFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(true);
		}
	}


	public void verifyUserAbleToOpenVideoFileInTheNewTabFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Open Video File In The New Tab From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			refreshWebPage();
			explicitWaitInSeconds(5);
			scrollToElement(ioCloudMyfilesVideoFileLink);
			isWebElementDisplayed(ioCloudMyfilesVideoFileLink);
			logPassStepInExtentReportWithScreenshot("Video File Visible clicking On The Elipse Button");
			explicitWaitInSeconds(5);
			WebElement selectedVideoFile = uiElement(ioCloudMyfilesVideoFileLink);
			WebElement selectedVideoFileElipseButton = selectedVideoFile.findElement(By.xpath(iocloudMyfilesVideoFileElipseButton));
			explicitWaitInSeconds(3);
			selectedVideoFileElipseButton.click();
			explicitWaitInSeconds(3);
			isWebElementDisplayed(iocloudMyfilesElipseButtonMenuOpenNewTabButton);
			logPassStepInExtentReportWithScreenshot("Selecting Open In New Tab Option From the Menu");
			clickWebElement(iocloudMyfilesElipseButtonMenuOpenNewTabButton);
			explicitWaitInSeconds(3);
			swithToNextNewWindow();
			logPassStepInExtentReport("Switched to the next window");
			explicitWaitInSeconds(10);
			if (isWebElementDisplayed(VideoFileConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Video File Successfully Opened in New Tab");
			} else {
				logFailStepInExtentReport("Failed To Open The Video File In The New Tab");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToOpenVideoFileInTheNewTabFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : verify User Able To Open Audio File In The New Tab From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			refreshWebPage();
			explicitWaitInSeconds(5);
			scrollToElement(ioCloudMyfilesAudioFileLink);
			isWebElementDisplayed(ioCloudMyfilesAudioFileLink);
			logPassStepInExtentReportWithScreenshot("Audio File Visible clicking On The Elipse Button");
			explicitWaitInSeconds(5);
			WebElement selectedVideoFile = uiElement(ioCloudMyfilesAudioFileLink);
			WebElement selectedVideoFileElipseButton = selectedVideoFile.findElement(By.xpath(iocloudMyfilesAudioFileElipseButton));
			explicitWaitInSeconds(3);
			selectedVideoFileElipseButton.click();
			explicitWaitInSeconds(3);
			isWebElementDisplayed(iocloudMyfilesElipseButtonMenuOpenNewTabButton);
			logPassStepInExtentReportWithScreenshot("Selecting Open In New Tab Option From the Menu");
			clickWebElement(iocloudMyfilesElipseButtonMenuOpenNewTabButton);
			explicitWaitInSeconds(3);
			swithToNextNewWindow();
			logPassStepInExtentReport("Switched to the next window");
			explicitWaitInSeconds(10);
			if (isWebElementDisplayed(AudioFileConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Audio File Successfully Opened in New Tab");
			} else {
				logFailStepInExtentReport("Failed To Open The Audio File In The New Tab");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}


	//	Need to Re-Script the Move Functionality

	//	public void verifyUserAbleToMoveFolderFromIoCloudMyFiles() throws Exception {
	//		try {
	//			logConsoleOutputMessage("strUrl: " + strUrl);
	//			logPassStepInExtentReport("TC 013 : Verify User Able To Move Folder From IoCloud MyFiles");
	//			refreshWebPage();
	//			clickWebElement(leftPanelIOCloud_MyFiles);
	//			logPassStepInExtentReport("My Files button clicked successfully");
	//			explicitWaitInSeconds(5);
	//			refreshWebPage();
	//			explicitWaitInSeconds(5);
	//			//			scrollToElement(ioCloudMyfilesAudioFileLink);
	//			isWebElementDisplayed(ioCloudMyFilesMovingFolder1link);
	//			logPassStepInExtentReportWithScreenshot("Moving Folder Visible clicking On The Elipse Button");
	//			explicitWaitInSeconds(5);
	//			//			WebElement selectedVideoFile = uiElement(ioCloudMyFilesMovingFolder1link);
	//			//			WebElement selectedVideoFileElipseButton = selectedVideoFile.findElement(By.xpath(iocloudMyfilesMovingFolderElipseButton));
	//			//			explicitWaitInSeconds(3);
	//			scrollToElement(iocloudMyfilesMovingFolderElipseButton);
	//			isWebElementDisplayed(iocloudMyfilesMovingFolderElipseButton);
	//			explicitWaitInSeconds(3);
	//			doubleClickUsingActionClass(iocloudMyfilesMovingFolderElipseButton);
	//			//			selectedVideoFileElipseButton.click();
	//			//			explicitWaitInSeconds(3);
	//			//			isWebElementDisplayed(iocloudMyfilesElipseButtonMenuOpenNewTabButton);
	//			//			logPassStepInExtentReportWithScreenshot("Selecting Move Option From the Elipse Menu");
	//			//			clickWithJavaScriptExecutor(selectedVideoFileElipseButton);
	//			//			clickWebElement(selectedVideoFileElipseButton);
	//			explicitWaitInSeconds(3);
	//			clickWebElement(ioCloudElipseMoveButton);
	//			explicitWaitInSeconds(5);
	//			scrollToElement(iocloudMyFilesSubMenuLoadMoreButton);
	//			isWebElementDisplayed(iocloudMyFilesSubMenuLoadMoreButton);
	//			explicitWaitInSeconds(3);
	//			clickWebElement(iocloudMyFilesSubMenuLoadMoreButton);
	//			logPassStepInExtentReport("Load More Button Clicked Successfully");
	//			scrollToElement(iocloudMyFilesSubMenuProject1Link);
	//			isWebElementDisplayed(iocloudMyFilesSubMenuProject1Link);
	//			explicitWaitInSeconds(3);
	//			doubleClickUsingActionClass(iocloudMyFilesSubMenuProject1Link);
	//			logPassStepInExtentReport("Clicked On Project1 Folder Successfully");
	//			explicitWaitInSeconds(3);
	//			String folderUploadedLabel = "//p[contains(text(),'completed')]";
	//			waitUntilElementGetsDisappeared(folderUploadedLabel);
	//			clickWebElement(topPanelNotificationButton);
	//			if (isWebElementDisplayed(folderUploadedLabel)) {
	//				logPassStepInExtentReportWithScreenshot("Folder Moved Successfully");
	//			} else {
	//				logFailStepInExtentReport("Folder Not Moved");
	//				assertTrue(false);
	//			}
	//			clickWebElement(closeNotificationButton);
	//			explicitWaitInSeconds(5);
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			logFailStepInExtentReport("Failed in verifyUserAbleToOpenAudioFileInTheNewTabFromIoCloudMyFiles method. Failure Exception: " + e);
	//			assertTrue(false);
	//		}
	//	}


	public void verifyUserAbleToRenameFileFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : Verify User Able To Rename File From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			refreshWebPage();
			scrollToElement(iocloudMyFilesRenameFileLink);
			isWebElementDisplayed(iocloudMyFilesRenameFileLink);
			logPassStepInExtentReport("Renaming File Visible clicking On The Elipse Button");
			explicitWaitInSeconds(5);
			WebElement selectedRenameFile = uiElement(iocloudMyFilesRenameFileLink);
			WebElement selectedRenameFileElipseButton = selectedRenameFile.findElement(By.xpath(iocloudMyfilesRenameFileElipseButton));
			explicitWaitInSeconds(3);
			selectedRenameFileElipseButton.click();
			explicitWaitInSeconds(3);
			isWebElementDisplayed(iocloudMyfilesElipseMenuRenameButton);
			logPassStepInExtentReportWithScreenshot("Clicking On The Rename Button ");
			explicitWaitInSeconds(3);
			clickWebElement(iocloudMyfilesElipseMenuRenameButton);
			WebElement Rename = uiElement(iocloudMyfilesRenameTextBox);
			Rename.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			logPassStepInExtentReport("Clearing the Old Data And Entering The Desired File Name");
			setTextInTextField(iocloudMyfilesRenameTextBox,strFileRename);
			explicitWaitInSeconds(3);
			logPassStepInExtentReportWithScreenshot("Clicking On The Save Button");
			clickUsingActionClass(iocloudMyfilesRenameSaveButton);
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			String folderRenameSuccessMessage = "//p[contains(text(),'has been renamed')]";
			explicitWaitInSeconds(10);

			if (isWebElementDisplayed(folderRenameSuccessMessage)) {
				logPassStepInExtentReportWithScreenshot("File Renamed Successfiully");
			} else {
				logFailStepInExtentReport("Failed to Rename File");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToRenameFileFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToRenameFolderFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : Verify User Able To Rename Folder From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			refreshWebPage();
			clickWebElement(iocloudMyFilesNameSortLink);
			isWebElementDisplayed(iocloudMyFilesRenameFolderLink);
			scrollToElement(iocloudMyFilesRenameFolderLink);
			logPassStepInExtentReport("Renaming File Visible clicking On The Elipse Button");
			explicitWaitInSeconds(5);
			WebElement selectedRenameFile = uiElement(iocloudMyFilesRenameFolderLink);
			WebElement selectedRenameFileElipseButton = selectedRenameFile.findElement(By.xpath(iocloudMyfilesRenameFolderElipseButton));
			explicitWaitInSeconds(3);
			selectedRenameFileElipseButton.click();
			explicitWaitInSeconds(3);
			isWebElementDisplayed(iocloudMyfilesRenameFolderElipseButton);
			logPassStepInExtentReportWithScreenshot("Clicking On The Rename Button ");
			explicitWaitInSeconds(3);
			clickWebElement(iocloudMyfilesElipseMenuRenameButton);
			WebElement Rename = uiElement(iocloudMyfilesRenameTextBox);
			Rename.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			logPassStepInExtentReport("Clearing the Old Data And Entering The Desired File Name");
			setTextInTextField(iocloudMyfilesRenameTextBox,strFileRename);
			explicitWaitInSeconds(3);
			logPassStepInExtentReportWithScreenshot("Clicking On The Save Button");
			clickUsingActionClass(iocloudMyfilesRenameSaveButton);
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			String folderRenameSuccessMessage = "//p[contains(text(),'has been renamed')]";
			explicitWaitInSeconds(10);

			if (isWebElementDisplayed(folderRenameSuccessMessage)) {
				logPassStepInExtentReportWithScreenshot("File Renamed Successfiully");
			} else {
				logFailStepInExtentReport("Failed to Rename File");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToRenameFolderFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}


	public void verifyUserAbleToDeleteFromIoCloudMyFiles() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			logPassStepInExtentReport("TC 013 : Verify User Able To Delete From IoCloud MyFiles");
			refreshWebPage();
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("My Files button clicked successfully");
			explicitWaitInSeconds(5);
			refreshWebPage();

			explicitWaitInSeconds(3);
			clickWebElement(iocloudMyFilesNameSortLink);
			scrollToElement(iocloudDeleteMyFilesFolder);
			isWebElementDisplayed(iocloudDeleteMyFilesFolder);
			explicitWaitInSeconds(3);
			clickWebElement(iocloudDeleteMyFilesFolder);
			clickWebElement(ioCloudElipseOpenButton);
			explicitWaitInSeconds(5);
			
			List<WebElement> fileCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

			// Select the files you want to delete (e.g., the first two files)
			fileCheckboxes.get(1).click(); // Check the first file
			fileCheckboxes.get(2).click(); // Check the second file
			clickWebElement(ioCloudSelectAllButton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport("All File From DeleteMYFiles Folder Selected Clicking On Delete Button");
			clickWebElement(ioCloudDeleteButton);
			explicitWaitInSeconds(10);
			clickWebElement(leftPanelIOCloud_RecycleBin);
			explicitWaitInSeconds(3);

			if (isWebElementDisplayed(emptyRecycleBinConfirmtion)) {
				logPassStepInExtentReportWithScreenshot("File Renamed Successfiully");
			} else {
				logFailStepInExtentReport("Failed to Rename File");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in verifyUserAbleToDeleteFromIoCloudMyFiles method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

}
