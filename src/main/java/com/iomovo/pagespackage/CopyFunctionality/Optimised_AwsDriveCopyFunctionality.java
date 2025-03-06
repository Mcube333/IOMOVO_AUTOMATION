package com.iomovo.pagespackage.CopyFunctionality;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.iomovo.basepackage.BaseClass;

/**
 * This class automates and verifies the file copy functionality 
 * from AWS Drive to various target cloud storage services.
 */

public class Optimised_AwsDriveCopyFunctionality extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor

	public Optimised_AwsDriveCopyFunctionality(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;	}

	// XPath Constants

	String copyDataFolderSelection = "//a[text()='AVI Data Folder']";
	String moveDataFolderSelectionRoot = "//a[text()='AutomationTestingFolder']";
	String ioHubDataSelectionFolder = "//tr/td/a[text()='Data Folder']";
	String BoxDropBoxDataFolder = "//a[text()='Box & DropBox']";
	String DataPastingAlert = "//div[@role='alert']"; 
	String DataPastingCancelButton = "//span[text()='No']";
	String breadCrumsButton = "//li[@role='button']";
	String breadCrumFolderSelection = "//a[text()='automationfolder']";
	String selectingFiles = "//th[@scope='col']//input[@type='checkbox']";

	String aWSBreadCrumbsButton = "//li/a[text()='00000-automationtestingfolder-dnd']";
	String fTPBreadCrumbsButton = "//li/a[text()='automationtestingfolder-DND']";
	String googleCloudBreadCrumbsButton = "//li/a[text()='automationtestingfolder-dnd']";
	String azureBreadCrumbsButton = "//li/a[text()='automationtestingfolder-dnd']";
	String oneDriveBreadCrumbsButton = "//li/a[text()='AutomationTestingFolder-DND']";
	String sftpBreadCrumbsButton = "//li/a[text()='AutomationTestingFolder-DND']";
	String sharePointBreadCrumbsButton = "//li/a[text()='AutomationTestingFolder-DND']";

	String ioCloudCopyButton = "//span[text()='Copy']";
	String ioCloudMoveButton = "//span[text()='Move']";
	String ioCloudPastebutton = "//span[text()='Paste']";
	String ioCloudPastingYesButton = "//button[@id='Yes-Button']";
	String ioCloudPastingNoButton = "//span[text()='No']";
	String ioCloudElipsebutton = "//Button[@id='menu-icon']";
	String ioCloudElipseCopyButton = "//p[text()='Copy']";

	String aWSDriveDropDownSelection = "//li[text()='Fish AWS Drive']";
	String aWSDriveFolderSelectionRoot = "//*[text()='00000-automationtestingfolder-dnd']";
	String aWSDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String aWSDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToAwsCopyDataPaste = "//tr/td[*]/a[text()='IoCloudtoAWS']";
	String awsToAwsCopyDataPaste = "//tr/td[*]/a[text()='AWStoAWS']";
	String boxToAwsCopyDataPaste = "//tr/td[*]/a[text()='BoxDrivetoAWS']";
	String dropBoxToAwsCopyDataPaste = "//tr/td[*]/a[text()='DropBoxtoAWS']";
	String ftpToAwsCopyDataPaste = "//tr/td[*]/a[text()='FTPtoAWS']";
	String googleCloudToAwsCopyDataPaste = "//tr/td[*]/a[text()='GoogleCloudtoAWS']";
	String googleDriveToAwsCopyDataPaste = "//tr/td[*]/a[text()='GoogleDrivetoAWS']";
	String azureToAwsCopyDataPaste = "//tr/td[*]/a[text()='AzuretoAWS']";
	String oneDriveToAwsCopyDataPaste = "//tr/td[*]/a[text()='OneDrivetoAWS']";
	String oracleToAwsCopyDataPaste = "//tr/td/div/a[text()='OracleToAWS']";
	String sftpToAwsCopyDataPaste = "//tr/td[*]/a[text()='SftptoAWS']";
	String sharePointToAwsCopyDataPaste = "//tr/td[*]/a[text()='SharePointtoAWS']";

	String LeftPanelAWSDriveButton = "(//div[@class='tile'])[1]";
	String LeftPanelBoxDriveButton = "(//div[@class='tile'])[2]";
	String LeftPanelDropBoxDriveButton = "(//div[@class='tile'])[3]";
	String LeftPanelFTPDriveButton = "(//div[@class='tile'])[4]";
	String LeftPanelGoogleCloudDriveButton = "(//div[@class='tile'])[5]";
	String LeftPanelGoogleDriveButton = "(//div[@class='tile'])[6]";
	String LeftPanelAzureDriveButton = "(//div[@class='tile'])[7]";
	String LeftPanelOneDriveButton = "(//div[@class='tile'])[8]";
	String LeftPanelOraleDriveButton = "(//div[@class='tile'])[9]";
	String LeftPanelSFTPDriveButton = "(//div[@class='tile'])[10]";
	String LeftPanelSharePointDriveButton = "(//div[@class='tile'])[11]";

	String leftPanelHomeButton = "//span[text()=' Home']";
	String leftPanelIoAIButton = "//li[@title='Advance Media Services']";
	String leftPanelIoCloudButton = "//li[@title='Digital Asset Management']";
	String leftPanelIoHubButton = "//li[@id='ioHUB-drives']";
	String leftPanelIoPortalButton = "//li[@title='Web Portal Services']";
	String leftPanelioFlowButton = "//span[text()='ioFlow']";
	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String ioCloudSelectAllButton = "//span[text()='Select All']";
	String ioCloudUpload = "//span[text()='Upload']";
	String ioCloudDeleteButton = "//span[text()='Delete']";
	String uploadingStatusBar = "//div[@id='panel1a-header']";
	String topPanelNotificationButton = "//button[@aria-label='notifications']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String MultipleFileSelectionFolder = "//td[3]/div/a[text()='Multiple Avi Files ']";
	String copyFilesConfirmation = "//button[@aria-label='notifications']//span[contains(@class,'MuiBadge-badge') and text()='1']";
	String noDataAvailableOnDriveLable = "//div/strong[text()=' No data found in the directory']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");

	// All other Variables
	String audioFilesPath = projectDirectory + "\\FilesToUpload\\AudioFiles\\";
	String docFilesPath = projectDirectory + "\\FilesToUpload\\DocFiles\\";
	String videoFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles\\";
	String videoFileName = "Test42MB.avi";


	/**
	 * Generates a dynamic XPath for selecting a folder by name.
	 * @param folderName Name of the folder.
	 * @return XPath string.
	 */

	public String commonFolderXpath(String folderName) {
		return "//td[@role='cell']//a[@title='"+folderName+"']";
	}

	/**
	 * Navigates to the specified drive.
	 * @param driveButton The XPath of the target drive button.
	 * @param testCaseName The name of the test case for logging.
	 */

	public void navigateToDrive(String driveButton, String caseName) {
		try {
			logPassStepInExtentReport(caseName);
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(driveButton);
			logPassStepInExtentReportWithScreenshot(driveButton + " clicked successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selects and copies files from the AWS source folder.
	 */

	public void copyFilesFromSourceFolder() {
		try {
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("Data Folder"));
			clickWebElement(selectingFiles);
			logPassStepInExtentReportWithScreenshot("Selecting the files from AWS Drive");
			clickWebElement(ioCloudCopyButton);
			logPassStepInExtentReportWithScreenshot("Copy button clicked successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pastes copied files into the target folder.
	 * @return Copy operation status message.
	 */

	public String pasteFilesToTargetFolder() {
		String copiedSuccessOrFailureMessage = "";
		try {
			clickWebElement(ioCloudPastebutton);
			logPassStepInExtentReportWithScreenshot("Clicking the Paste button");
			clickWebElement(ioCloudPastingYesButton);
			logPassStepInExtentReportWithScreenshot("Clicked Yes to paste the data");
			String commonNotificationLabel = "//li[contains(@class,'MuiListItem-root')]//p[contains(text(),'Copied from')]/following::p/span[contains(text(),'Copied successfully')]";
			explicitWaitInSeconds(5);
			clickWebElement(topPanelNotificationButton);
			if (isWebElementDisplayed(commonNotificationLabel)) {
				copiedSuccessOrFailureMessage = getTextFromWeb(commonNotificationLabel);
				clickWebElement(closeNotificationButton);
				logPassStepInExtentReportWithScreenshot("Closing the notification tab");
				explicitWaitInSeconds(5);
			}
		} catch (Exception e) {
			e.printStackTrace();
			copiedSuccessOrFailureMessage = "Failed to paste files";
		}
		return copiedSuccessOrFailureMessage;
	}

	/**
	 * Verifies the file copy functionality from AWS to the target drive.
	 * @param targetDriveButton The XPath of the target drive button.
	 * @param targetFolderPath The folder path where files should be pasted.
	 * @param testCaseName Name of the test case.
	 */

	public void verifyCopyFilesFunctionality(String targetDriveButton, String targetFolderPath, String testCaseName) throws Exception {
		try {
			navigateToDrive(LeftPanelAWSDriveButton, testCaseName);
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(targetDriveButton);
			logPassStepInExtentReportWithScreenshot("Selecting target drive");

			for (String folder : targetFolderPath.split("/")) {
				doubleClickUsingActionClassWithoutScrolling(commonFolderXpath(folder));
			}
			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot("File successfully copied to target drive");
			} else {
				logFailStepInExtentReport("Files not copied");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed in " + testCaseName + ". Exception: " + e);
			assertTrue(false);
		}
	}

	/**
	 * Example usage for AWS to IoCloud.
	 */
	public void verifyCopyFilesFunctionalityFromAWSToIoCloudDrive() throws Exception {
		verifyCopyFilesFunctionality(leftPanelIoCloudButton, "automationfolder/Copy Folder/AWStoIoCloud", "TC 001 : Verify Copy Function From AWS To IoCloud Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToAWSDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelAWSDriveButton, "automationfolder/Copy Folder/AWStoAWS", "TC 002 : Verify Copy Function From AWS To AWS Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToBoxDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelBoxDriveButton, "automationfolder/Copy Folder/AWSToBox", "TC 003 : Verify Copy Function From AWS To BOX Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelDropBoxDriveButton, "automationfolder/Copy Folder/AWStoDropBox", "TC 004 : Verify Copy Function From AWS To DROPBOX Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToFTPDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelFTPDriveButton, "automationfolder/Copy Folder/AWStoFTP", "TC 005 : Verify Copy Function From AWS To FTP Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelGoogleCloudDriveButton, "automationfolder/Copy Folder/AWStoGoogleCloud", "TC 006 : Verify Copy Function From AWS To GoogleCloud Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelGoogleDriveButton, "automationfolder/Copy Folder/AWStoGoogleDrive", "TC 007 : Verify Copy Function From AWS To Google Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToAzureDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelAzureDriveButton, "automationfolder/Copy Folder/AWStoAzure", "TC 008 : Verify Copy Function From AWS To Azure Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToOneDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelOneDriveButton, "automationfolder/Copy Folder/AWStoOneDrive", "TC 009 : Verify Copy Function From AWS To One Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToOOSDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelOraleDriveButton, "automationfolder/Copy Folder/AWStoOOS", "TC 009 : Verify Copy Function From AWS To OOS Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelSFTPDriveButton, "automationfolder/Copy Folder/AWStoSFTP", "TC 010 : Verify Copy Function From AWS To SFTP Drive");
	}

	public void verifyCopyFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
		verifyCopyFilesFunctionality(LeftPanelSharePointDriveButton, "ioMoVoQATeam/automationfolder/Copy Folder/AWStoSharePoint", "TC 011 : Verify Copy Function From AWS To SharePoint Drive");
	}
}