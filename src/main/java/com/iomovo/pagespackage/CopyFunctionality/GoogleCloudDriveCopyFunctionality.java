package com.iomovo.pagespackage.CopyFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class GoogleCloudDriveCopyFunctionality extends BaseClass {

	public GoogleCloudDriveCopyFunctionality(WebDriver driver, WebDriverWait wait) {
		BaseClass.driver = driver;
        BaseClass.wait = wait;
	}

	String copyDataFolderSelection = "//a[text()='AVI Data Folder']";
	String moveDataFolderSelectionRoot = "//a[text()='AutomationTestingFolder']";
	String ioHubDataSelectionFolder = "//tr/td/a[text()='Data Folder']";
	String BoxDropBoxDataFolder = "//a[text()='Box & DropBox']";
	String DataPastingAlert = "//div[@role='alert']"; 
	String DataPastingCancelButton = "//span[text()='No']";
	String breadCrumsButton = "//li[@role='button']";
	String selectingFiles = "//th[1]";
	
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

	String iocloudDriveFolderSelectionMoveData = "//tr/td[*]/div/a[text()='Move Data Folder']";
	String iocloudDriveFolderSelectionCopy = "//tr/td/div/a[text()='Copy Folder']";
	String iocloudDriveFolderSelectionMove = "//tr/td/div/a[text()='Move Folder']";
	String ioCloudDropDownSelection = "//li[text()='ioCloud']";
	String ioCloudPastingYesButtonDisabled = "//button[@id='Yes-Button']";
	String IoCloudPastingError = "//div[text()='Items cannot be Copied/Moved into the same directory']";
	String ioCloudDriveDropDownSelection = "//li[text()='ioCloud']";
	String destinationCopyButton = "//a/span[text()='Copy']";
	String destinationFolderSelection = "//tr[2]"; 
	String drivesDropDownButton = "//div[@id='demo-simple-select']";
	String ioCloudToIocloudCopyDataPaste = "//tr/td/div/a[text()='IoCloudtoIoCloud']";
	String awsToIocloudCopyDataPaste = "//tr/td/div/a[text()='AWStoIoCloud']";
	String boxToIocloudCopyDataPaste = "//tr/td/div/a[text()='BoxDrivetoIoCloud']";
	String dropBoxToIocloudCopyDataPaste = "//tr/td/div/a[text()='DropBoxtoIoCloud']";
	String ftpToIocloudCopyDataPaste = "//tr/td/div/a[text()='FTPtoIoCloud']";
	String googleCloudToIocloudCopyDataPaste = "//tr/td/div/a[text()='GoogleCloudtoIoCloud']";
	String googleDriveToIocloudCopyDataPaste = "//tr/td/div/a[text()='GoogleDrivetoIoCloud']";
	String azureToIocloudCopyDataPaste = "//tr/td/div/a[text()='AzuretoIoCloud']";
	String oneDriveToIocloudCopyDataPaste = "//tr/td/div/a[text()='OneDrivetoIoCloud']";
	String sftpToIocloudCopyDataPaste = "//tr/td/div/a[text()='SftptoIoCloud']";
	String sharePointToIocloudCopyDataPaste = "//tr/td/div/a[text()='SharePointtoIoCloud']";

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
	String sftpToAwsCopyDataPaste = "//tr/td[*]/a[text()='SftptoAWS']";
	String sharePointToAwsCopyDataPaste = "//tr/td[*]/a[text()='SharePointtoAWS']";

	String boxDriveDropDownSelection = "//li[text()='Fish Box Drive']";
	String boxDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String boxDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToBoxCopyDataPaste = "//tr/td/a[text()='IoCloudToBox']";
	String awsToBoxCopyDataPaste = "//tr/td/a[text()='AWSToBox']";
	String boxToBoxCopyDataPaste = "//tr/td/a[text()='BoxToBox']";
	String dropBoxToBoxCopyDataPaste = "//tr/td/a[text()='DropBoxToBox']";
	String ftpToBoxCopyDataPaste = "//tr/td/a[text()='FTPToBox']";
	String googleCloudToBoxCopyDataPaste = "//tr/td/a[text()='GoogleCloudToBox']";
	String googleDriveToBoxCopyDataPaste = "//tr/td/a[text()='GoogleDriveToBox']";
	String azureToBoxCopyDataPaste = "//tr/td/a[text()='AzureToBox']";
	String oneDriveToBoxCopyDataPaste = "//tr/td/a[text()='OneDriveToBox']";
	String sftpToBoxCopyDataPaste = "//tr/td/a[text()='SftpToBox']";
	String sharePointToBoxCopyDataPaste = "//tr/td/a[text()='SharePointToBox']";

	String dropBoxDriveDropDownSelection = "//li[text()='Fish DropBox Drive']";
	String dropBoxDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String dropBoxDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToDropBoxCopyDataPaste = "//tr/td/a[text()='IoCloudToDropBox']";
	String awsToDropBoxCopyDataPaste = "//tr/td/a[text()='AWSToDropBox']";
	String boxToDropBoxCopyDataPaste = "//tr/td/a[text()='BoxToDropBox']";
	String dropBoxToDropBoxCopyDataPaste = "//tr/td/a[text()='DropBoxToDropBox']";
	String ftpToDropBoxCopyDataPaste = "//tr/td/a[text()='FTPToDropBox']";
	String googleCloudToDropBoxCopyDataPaste = "//tr/td/a[text()='GoogleCloudToDropBox']";
	String googleDriveToDropBoxCopyDataPaste = "//tr/td/a[text()='GoogleDriveToDropBox']";
	String azureToDropBoxCopyDataPaste = "//tr/td/a[text()='AzureToDropBox']";
	String oneDriveToDropBoxCopyDataPaste = "//tr/td/a[text()='OneDriveToDropBox']";
	String sftpToDropBoxCopyDataPaste = "//tr/td/a[text()='SftpToDropBox']";
	String sharePointToDropBoxCopyDataPaste = "//tr/td/a[text()='SharePointToDropBox']";

	String fTPDriveDropDownSelection = "//li[text()='Fish FTP Drive']";
	String fTPDriveFolderSelectionRoot = "//span[text()='automationtestingfolder-DND']";
	String fTPDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String fTPDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToFtpCopyDataPaste = "//tr/td/a[text()='IoCloudToFtp']";
	String awsToFtpCopyDataPaste = "//tr/td/a[text()='AWSToFtp']";
	String boxToFtpCopyDataPaste = "//tr/td/a[text()='BoxToFtp']";
	String dropBoxToFtpCopyDataPaste = "//tr/td/a[text()='DropBoxToFtp']";
	String ftpToFtpCopyDataPaste = "//tr/td/a[text()='FTPToFtp']";
	String googleCloudToFtpCopyDataPaste = "//tr/td/a[text()='GoogleCloudToFtp']";
	String googleDriveToFtpCopyDataPaste = "//tr/td/a[text()='GoogleDriveToFtp']";
	String azureToFtpCopyDataPaste = "//tr/td/a[text()='AzureToFtp']";
	String oneDriveToFtpCopyDataPaste = "//tr/td/a[text()='OneDriveToFtp']";
	String sftpToFtpCopyDataPaste = "//tr/td/a[text()='SftpToFtp']";
	String sharePointToFtpCopyDataPaste = "//tr/td/a[text()='SharePointToFtp']";

	String googleCloudDriveDropDownSelection = "//li[text()='Fish G Cloud Drive']";
	String googleCloudFolderSelectionRoot = "//span[text()='automationtestingfolder-dnd']";
	String googleCloudFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String googleCloudFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToGoogleCloudCopyDataPaste = "//tr/td/a[text()='IoCloudToGoogleCloud']";
	String awsToGoogleCloudCopyDataPaste = "//tr/td/a[text()='AWSToGoogleCloud']";
	String boxToGoogleCloudCopyDataPaste = "//tr/td/a[text()='BoxToGoogleCloud']";
	String dropBoxToGoogleCloudCopyDataPaste = "//tr/td/a[text()='DropBoxToGoogleCloud']";
	String ftpToGoogleCloudCopyDataPaste = "//tr/td/a[text()='FTPToGoogleCloud']";
	String googleCloudToGoogleCloudCopyDataPaste = " //tr/td/a[text()='GoogleCloudToGoogleCloud']"; 
	String googleDriveToGoogleCloudCopyDataPaste = "//tr/td/a[text()='GoogleDriveToGoogleCloud']";
	String azureToGoogleCloudCopyDataPaste = "//tr/td/a[text()='AzureToGoogleCloud']";
	String oneDriveToGoogleCloudCopyDataPaste = "//tr/td/a[text()='OneDriveToGoogleCloud']";
	String sftpToGoogleCloudCopyDataPaste = "//tr/td/a[text()='SftpToGoogleCloud']";
	String sharePointToGoogleCloudCopyDataPaste = "//tr/td/a[text()='SharePointToGoogleCloud']";

	String googleDriveDropDownSelection = "//li[text()='Fish Google Drive']";
	String googleDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String googleDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToGoogleDriveCopyDataPaste = "//tr/td/a[text()='IoCloudToGoogleDrive']";
	String awsToGoogleDriveCopyDataPaste = "//tr/td/a[text()='AWSToGoogleDrive']";
	String boxToGoogleDriveCopyDataPaste = "//tr/td/a[text()='BoxToGoogleDrive']";
	String dropBoxToGoogleDriveCopyDataPaste = "//tr/td/a[text()='DropBoxToGoogleDrive']";
	String ftpToGoogleDriveCopyDataPaste = "//tr/td/a[text()='FTPToGoogleDrive']";
	String googleCloudToGoogleDriveCopyDataPaste = "//tr/td/a[text()='GoogleCloudToGoogleDrive']";
	String googleDriveToGoogleDriveCopyDataPaste = "//tr/td/a[text()='GoogleDriveToGoogleDrive']";
	String azureToGoogleDriveCopyDataPaste = "//tr/td/a[text()='AzureToGoogleDrive']";
	String oneDriveToGoogleDriveCopyDataPaste = "//tr/td/a[text()='OneDriveToGoogleDrive']";
	String sftpToGoogleDriveCopyDataPaste = "//tr/td/a[text()='SftpToGoogleDrive']";
	String sharePointToGoogleDriveCopyDataPaste = "//tr/td/a[text()='SharePointToGoogleDrive']";

	String azureDriveDropDownSelection = "//li[text()='Fish Azure Drive']";
	String azureFolderSelectionRoot = "//span[text()='automationtestingfolder-dnd']";
	String azureFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String azureFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToAzureCopyDataPaste = "//tr/td/a[text()='IocloudToAzure']";
	String awsToAzureCopyDataPaste = "//tr/td/a[text()='AwsToAzure']";
	String boxToAzureCopyDataPaste = "//tr/td/a[text()='BoxToAzure']";
	String dropBoxToAzureCopyDataPaste = "//tr/td/a[text()='DropBoxToAzure']";
	String ftpToAzureCopyDataPaste = "//tr/td/a[text()='FtpToAzure']";
	String googleCloudToAzureCopyDataPaste = "//tr/td/a[text()='GoogleCloudToAzure']";
	String googleDriveToAzureCopyDataPaste = "//tr/td/a[text()='GloogleDriveToAzure']";
	String azureToAzureCopyDataPaste = "//tr/td/a[text()='AzureToAzure']";
	String oneDriveToAzureCopyDataPaste = "//tr/td/a[text()='OneDriveToAzure']";
	String sftpToAzureCopyDataPaste = "//tr/td/a[text()='SftpToAzure']";
	String sharePointToAzureCopyDataPaste = "//tr/td/a[text()='SharePointToAzure']";

	String oneDriveDropDownSelection = "//li[text()='Fish Corp One Drive']";
	String oneDriveFolderSelectionRoot = "//span[text()='AutomationTestingFolder-DND']";
	String oneDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String oneDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToOneDriveCopyDataPaste = "//tr/td/a[text()='IoCloudToOneDrive']";
	String awsToOneDriveCopyDataPaste = "//tr/td/a[text()='AWSToOneDrive']";
	String boxToOneDriveCopyDataPaste = "//tr/td/a[text()='BoxToOneDrive']";
	String dropBoxToOneDriveCopyDataPaste = "//tr/td/a[text()='DropBoxToOneDrive']";
	String ftpToOneDriveCopyDataPaste = "//tr/td/a[text()='FTPToOneDrive']";
	String googleCloudToOneDriveCopyDataPaste = "//tr/td/a[text()='GoogleCloudToOneDrive']";
	String googleDriveToOneDriveCopyDataPaste = "//tr/td/a[text()='GoogleDriveToOneDrive']";
	String azureToOneDriveCopyDataPaste = "//tr/td/a[text()='AzureToOneDrive']";
	String oneDriveToOneDriveCopyDataPaste = "//tr/td/a[text()='OneDriveToOneDrive']";
	String sftpToOneDriveCopyDataPaste = "//tr/td/a[text()='SftpToOneDrive']";
	String sharePointToOneDriveCopyDataPaste = "//tr/td/a[text()='SharePointToOneDrive']";

	String sftpDriveFolderSelectionRoot = "//span[text()='AutomationTestingFolder-DND']";
	String sftpDriveFolderSelectionCopy = "//tr/td/a[text()='Copy Folder']";
	String sftpDriveFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
	String ioCloudToSftpCopyDataPaste = "//tr/td/a[text()='IoCloudToSftp']";
	String awsToSftpCopyDataPaste = "//tr/td/a[text()='AWSToSftp']";
	String boxToSftpCopyDataPaste = "//tr/td/a[text()='BoxToSftp']";
	String dropBoxToSftpCopyDataPaste = "//tr/td/a[text()='DropBoxToSftp']";
	String ftpToSftpCopyDataPaste = "//tr/td/a[text()='FTPToSftp']";
	String googleCloudToSftpCopyDataPaste = "//tr/td/a[text()='GoogleCloudToSftp']";
	String googleDriveToSftpCopyDataPaste = "//tr/td/a[text()='GoogleDriveToSftp']";
	String azureToSftpCopyDataPaste = "//tr/td/a[text()='AzureToSftp']";
	String oneDriveToSftpCopyDataPaste = "//tr/td/a[text()='OneDriveToSftp']";
	String sftpToSftpCopyDataPaste = "//tr/td/a[text()='SftpToSftp']";
	String sharePointToSftpCopyDataPaste = "//tr/td/a[text()='SharePointToSftp']";

	String sharePointDriveDropDownSelection = "//li[text()='Fish SP Drive']";
//	String sharePointFolderSelectonRoot = "//span[text()='ioMoVoQATeam']";
	String sharePointFolderSelectonRoot = "//a[text()='ioMoVoQATeam']";
	String switchToGridViewButton = "//button[@title='Switch to Grid View']";
	String switchToListViewButton = "//button[@title='Switch to List View']";
//	String sharePointFolderSelectionL1 = "//span[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionL1 = "//*/td[3]/a[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionL1Grid = "//*/span[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionCopy = "//p/span[text()='Copy Folder']";
	String sharePointFolderSelectionMove = "//p/span[text()='Move Folder']";
	String ioCloudToSharePointCopyDataPaste = "//tr/td/a[text()='IoCloudToSharePoint']";
	String awsToSharePointCopyDataPaste = "//tr/td/a[text()='AWSToSharePoint']";
	String boxToSharePointCopyDataPaste = "//tr/td/a[text()='BoxToSharePoint']";
	String dropBoxToSharePointCopyDataPaste = "//tr/td/a[text()='DropBoxToSharePoint']";
	String ftpToSharePointCopyDataPaste = "//tr/td/a[text()='FTPToSharePoint']";
	String googleCloudToSharePointCopyDataPaste = "//tr/td/a[text()='GoogleCloudToSharePoint']";
	String googleDriveToSharePointCopyDataPaste = "//tr/td/a[text()='GoogleDriveToSharePoint']";
	String azureToSharePointCopyDataPaste = "//tr/td/a[text()='AzureToSharePoint']";
	String oneDriveToSharePointCopyDataPaste = "//tr/td/a[text()='OneDriveToSharePoint']";
	String sftpToSharePointCopyDataPaste = "//tr/td/a[text()='SftpToSharePoint']";
	String sharePointToSharePointCopyDataPaste = "//tr/td/a[text()='SharePointToSharePoint']";

	String LeftPanelAWSDriveButton = "(//div[@class='tile'])[1]";
	String LeftPanelBoxDriveButton = "(//div[@class='tile'])[2]";
	String LeftPanelDropBoxDriveButton = "(//div[@class='tile'])[3]";
	String LeftPanelFTPDriveButton = "(//div[@class='tile'])[4]";
	String LeftPanelGoogleCloudDriveButton = "(//div[@class='tile'])[5]";
	String LeftPanelGoogleDriveButton = "(//div[@class='tile'])[6]";
	String LeftPanelAzureDriveButton = "(//div[@class='tile'])[7]";
	String LeftPanelOneDriveButton = "(//div[@class='tile'])[8]";
	String LeftPanelOOSDriveButton = "(//div[@class='tile'])[9]";
	String LeftPanelSFTPDriveButton = "(//div[@class='tile'])[10]";
	String LeftPanelSharePointDriveButton = "(//div[@class='tile'])[11]";	 

	String leftPanelHomeButton = "//span[text()=' Home']";
	String leftPanelIoAIButton = "//li[@title='Advance Media Services']";
	String leftPanelIoCloudButton = "//li[@title='Digital Asset Management']";
	String leftPanelIoHubButton = "//li[@id='ioHUB-drives']";
	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String ioCloudSelectAllButton = "//span[text()='Select All']";
	String ioCloudUpload = "//span[text()='Upload']";
	String ioCloudDeleteButton = "//span[text()='Delete']";
	String uploadingStatusBar = "//div[@id='panel1a-header']";
	String topPanelNotificationButton = "//button[@aria-label='notifications']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String MultipleFileSelectionFolder = "//td[3]/div/a[text()='Multiple Avi Files ']";
	String copyFilesConfirmation = "//div/p/*[contains (text(),'Copied successfully')]";

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
	
	public String commonFolderXpathioCloud(String folderName) {
		return "//tr/td/div/*[text()='"+folderName+"']";
	}
	
	public String commonFolderXpathioHub(String folderName) {
		return "//tr/td/*[text()='"+folderName+"']";
	}

	public String commonFolderXpath(String folderName) {
		return "//tr/td/a[text()='"+folderName+"']";
	}

	public String commonFolderXpathLeftPanel(String folderName) {
		return "//span[text()='"+folderName+"']";
	}

	/**
	 *This Method Navigates to the Oracle Drive
	 *
	 * @author Mudassir
	 */
	public void navigateToGoogleCloudDrive(String caseName) {
		try {
			logPassStepInExtentReport(caseName);
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelGoogleCloudDriveButton);
			logPassStepInExtentReportWithScreenshot("GoogleCloud Drive button clicked successfully");
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *This Method Copies Data From Oracle Source Folder
	 *
	 * @author Mudassir
	 */
	public void copyFilesFromSourceFolder() {
		try {
			doubleClickUsingActionClass(commonFolderXpathLeftPanel("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("Data Folder"));
			explicitWaitInSeconds(3);
			clickWebElement(selectingFiles);
			logPassStepInExtentReportWithScreenshot(" Selecting The Files from GoogleCloud Drive ");	
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudCopyButton);
			logPassStepInExtentReportWithScreenshot(" Copy Butoon clicked Successfully ");
			explicitWaitInSeconds(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *This Method Pastes the Data Copied From Oracle Source Folder
	 *
	 * @author Mudassir
	 */
	public String pasteFilesToTargetFolder() {
	    String copiedSuccessOrFailureMessage = "";
	    try {
	        clickWebElement(ioCloudPastebutton);
	        logPassStepInExtentReportWithScreenshot(" Clicking The Paste Button ");
	        explicitWaitInSeconds(3);
	        clickWebElement(ioCloudPastingYesButton);
	        logPassStepInExtentReportWithScreenshot(" Cliking On Yes Button To Paste The Data ");
	        explicitWaitInSeconds(3);

	        waitUntilElementGetsAppeared(copyFilesConfirmation); 
	        String commonNotificationLabel = "//*[text()='Notifications']//following::p[contains(text(),'Copied')][1]";
	        explicitWaitInSeconds(5);

	        clickWebElement(topPanelNotificationButton);

	        if (isWebElementDisplayed(commonNotificationLabel)) {
	            copiedSuccessOrFailureMessage = getTextFromWeb(commonNotificationLabel);
	            clickWebElement(closeNotificationButton);
	            logPassStepInExtentReportWithScreenshot(" Closing The Notification Tab ");
	            explicitWaitInSeconds(5);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        copiedSuccessOrFailureMessage = "Failed to paste files";
	    }
	    return copiedSuccessOrFailureMessage;
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToIoCloudDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 001 : Verify Copy Function From GoogleCloud To IoCloud Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoCloudButton);
			logPassStepInExtentReportWithScreenshot(" Selecting IoCloud Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("GoogleCloudToIoCloud"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To IoCloud Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToIoCloudDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToAWSDrive() throws Exception {
			try {
				navigateToGoogleCloudDrive("TC 002 : Verify Copy Function From GoogleCloud To AWS Drive");
				copyFilesFromSourceFolder();
				clickWebElement(leftPanelIoHubButton);
				clickWebElement(LeftPanelAWSDriveButton);
				logPassStepInExtentReportWithScreenshot(" Selecting AWS Drive ");
				explicitWaitInSeconds(3);
				doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
				doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
				explicitWaitInSeconds(3);
				doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToAWS"));
				explicitWaitInSeconds(3);
				pasteFilesToTargetFolder();

				String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
				if (!copiedSuccessOrFailureMessage.contains("Failed")) {
					logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To AWS Drive");
				} else {
					logFailStepInExtentReport(" Files Not Copied ");
					assertTrue(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logFailStepInExtentReport(
						"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToAWSDrive Method. Failure Exception: " + e);
				assertTrue(false);
			}
		}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToBoxDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 003 : Verify Copy Function From GoogleCloud To Box Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelBoxDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Box Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToBox"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To Box Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToBoxDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToDropBoxDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 004 : Verify Copy Function From GoogleCloud To DropBox Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelDropBoxDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting DropBox Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToDropBox"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To DropBox Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToDropBoxDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToFTPDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 005 : Verify Copy Function From GoogleCloud To Ftp Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelFTPDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Ftp Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToFtp"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To Ftp Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToFTPDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToGoogleCloudDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 006 : Verify Copy Function From GoogleCloud To GoogleCloud Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelGoogleCloudDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting GoogleCloud Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToGoogleCloud"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To GoogleCloud Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToGoogleCloudDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToGoogleDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 007 : Verify Copy Function From GoogleCloud To Google Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelGoogleDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Google Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToGoogleDrive"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To Google Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToGoogleDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToAzureDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 008 : Verify Copy Function From GoogleCloud To Azure Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelAzureDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Azure Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToAzure"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To Azure Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToAzureDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToOneDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 009 : Verify Copy Function From GoogleCloud To One Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelOneDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting OneDrive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToOneDrive"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To One Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToOneDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyCopyFilesFunctionalityFromGoogleCloudToOOSDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 010 : Verify Copy Function From GoogleCloud To OOS Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelOOSDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting OOS Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToOOS"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To OOS Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToOOSDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToSFTPDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 011 : Verify Copy Function From GoogleCloud To Sftp Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelSFTPDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Sftp Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToSFTP"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To Sftp Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToSFTPDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyCopyFilesFunctionalityFromGoogleCloudToSharePointDrive() throws Exception {
		try {
			navigateToGoogleCloudDrive("TC 012 : Verify Copy Function From GoogleCloud To SharePoint Drive");
			copyFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelSharePointDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting SharePoint Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("Copy Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioHub("GoogleCloudToSharePoint"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Copied From GoogleCloud To SharePoint Drive");
			} else {
				logFailStepInExtentReport(" Files Not Copied ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyCopyFilesFunctionalityFromGoogleCloudToSharePointDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() throws Exception {
	//		try {
	//			logConsoleOutputMessage("strUrl: " + strUrl);
	//			logPassStepInExtentReport("TC 012 : Erasing The Copied Data SucccessFully From IoHub Drives");
	//			refreshWebPage();
	//
	//			clickWebElement(leftPanelIOCloud_MyFiles);
	//			doubleClickUsingActionClass(iocloudDriveFolderSelectionRoot);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In AWS--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In AWS. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting AWS Drive Data To Delete ");	
	//			}
	//
	//			explicitWaitInSeconds(5);
	//
	//			isWebElementDisplayed(LeftPanelAWSDriveButton);
	//			clickWebElement(LeftPanelAWSDriveButton);
	//			doubleClickUsingActionClass(aWSDriveFolderSelectionRoot);
	//			doubleClickUsingActionClass(aWSDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In AWS--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In AWS. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting AWS Drive Data To Delete ");	
	//			}
	//
	//			explicitWaitInSeconds(5);
	//
	//			isWebElementDisplayed(LeftPanelBoxDriveButton);
	//			clickWebElement(LeftPanelBoxDriveButton);
	//			doubleClickUsingActionClass(boxDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In BOX  --> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In BOX. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting Box Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(5);
	//
	//			isWebElementDisplayed(LeftPanelDropBoxDriveButton);
	//			clickWebElement(LeftPanelDropBoxDriveButton);
	//			doubleClickUsingActionClass(dropBoxDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In DROPBOX --> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In DROPBOX. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting DropBox Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelFTPDriveButton);
	//			clickWebElement(LeftPanelFTPDriveButton);
	//			doubleClickUsingActionClass(fTPFolderSelectionRoot);
	//			doubleClickUsingActionClass(fTPDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In FTP --> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In FTP. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting FTP Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelGoogeCloudDriveButton);
	//			clickWebElement(LeftPanelGoogeCloudDriveButton);
	//			doubleClickUsingActionClass(googleCloudFolderSelectionRoot);
	//			doubleClickUsingActionClass(googleCloudFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In GOOGLE CLOUD--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(6);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In GOOGLE CLOUD. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting Google Cloud Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelGoogeDriveButton);
	//			clickWebElement(LeftPanelGoogeDriveButton);
	//			doubleClickUsingActionClass(googleDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete in GOOGLE --> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In GOOGLE. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting Google Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelAzureDriveButton);
	//			clickWebElement(LeftPanelAzureDriveButton);
	//			doubleClickUsingActionClass(azureFolderSelectionRoot);
	//			doubleClickUsingActionClass(azureFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete AZURE--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In AZURE. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting Azure Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelOneDriveButton);
	//			clickWebElement(LeftPanelOneDriveButton);
	//			doubleClickUsingActionClass(oneDriveFolderSelectionRoot);
	//			doubleClickUsingActionClass(oneDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete in ONEDRIVE--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In ONEDRIVE. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting One Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelSFTPDriveButton);
	//			clickWebElement(LeftPanelSFTPDriveButton);
	//			doubleClickUsingActionClass(sftpDriveFolderSelectionRoot);
	//			doubleClickUsingActionClass(sftpDriveFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete in SFTP DRIVE--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In SFTP DRIVE. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting SFTP Drive Data To Delete ");
	//			}
	//
	//			explicitWaitInSeconds(3);
	//
	//			isWebElementDisplayed(LeftPanelSharePointDriveButton);
	//			clickWebElement(LeftPanelSharePointDriveButton);
	//			clickWebElement(sharePointFolderSelectonRoot);
	//			clickWebElement(switchToGridViewButton);
	//			explicitWaitInSeconds(3);
	//			isWebElementDisplayed(sharePointFolderSelectionL1);
	//			doubleClickUsingActionClass(sharePointFolderSelectionL1);
	//			doubleClickUsingActionClass(sharePointFolderSelectionCopy);
	//			if (isWebElementDisplayed(noDataAvailableOnDriveLable)) {
	//				logPassStepInExtentReportWithScreenshot("No Data Available To Delete In SHAREPOINT--> Checking on other Drive");
	//				assertTrue(true);
	//				explicitWaitInSeconds(3);
	//			} else if (isWebElementDisplayed(ioCloudSelectAllButton)) {
	//				logPassStepInExtentReportWithScreenshot("Old Data Is Present In SHAREPOINT. Attempting to clear the Data");
	//				clickWebElement(ioCloudSelectAllButton);
	//				clickWebElement(ioCloudDeleteButton);
	//				acceptSingleAlertIfPresent();
	//				logPassStepInExtentReportWithScreenshot(" Selecting SharePoint Drive Data To Delete ");
	//			}
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			logFailStepInExtentReport(
	//					"Failed In verifyErasingTheCopiedDataSucccessFullyFromIoHubDrives Method. Failure Exception: " + e);
	//			assertTrue(false);
	//		}
	//	}
}
