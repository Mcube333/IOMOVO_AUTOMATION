package com.iomovo.pagespackage.IoPortalFunctionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.iomovo.basepackage.BaseClass;

public class CreateIoPortalFunctionality extends BaseClass {

	WebDriver driver;
	WebDriverWait wait;

	public CreateIoPortalFunctionality(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;	}

	String copyDataFolderSelection = "//a[text()='automationfolder']";
	String moveDataFolderSelectionRoot = "//a[text()='automationfolder']";
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
	String oracleToIocloudCopyDataPaste = "//tr/td/div/a[text()='OracleToIoCloud']";
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
	String oracleToAwsCopyDataPaste = "//tr/td/div/a[text()='OracleToAWS']";
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
	String LeftPanelOracleDriveButton = "(//div[@class='tile'])[9]";
	String LeftPanelSFTPDriveButton = "(//div[@class='tile'])[10]";
	String LeftPanelSharePointDriveButton = "(//div[@class='tile'])[11]";

	String leftPanelHomeButton = "//span[text()=' Home']";
	String leftPanelIoAIButton = "//li[@title='Advance Media Services']";
	String leftPanelIoCloudButton = "//li[@title='Digital Asset Management']";
	String leftPanelIoHubButton = "//li[@id='ioHUB-drives']";
	String leftPanelIoPortalButton = "//li[@title='Web Portal Services']";
	String leftPanelIoFlowButton = "//li[@title='Workflow Status Report']";
	String leftPanelIoReports = "//li[@title='Reports']";
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
	String createPortalButton = "//span[text()='Create Portal']";
	String addfolderButton = "//span[text()='Add Folder']";
	String addfolderNameTextBox = "(//input[@type='text'])[2]";
	String FolderSaveButton = "//span[text()='Save']";
	String createdFolderSelection = "//span[text()='TestProject']";
	String folderselection = "//span[text()='TestProject']";
	String nextButton = "//span[text()='Next']";
	String portalConfirmation = "//div/p/*[contains (text(),'Created successfully')]";
	String roleSelectionButton = "//div[@id='mui-component-select-selectRole']";
	String readerRole = "//li[text()='Reader']";
	String readerDescription = "//p[text()='The Reader is only allowed to read.']";
	String commenterRole = "//li[text()='Commenter']";
	String commenterRoleDescription = "//p[text()='The Commenter is allowed to leave comments on any file.']";
	String editorRole = "//li[text()='Editor']";
	String editorRoleDescription = "//p[text()='The Editor can update files insights and also leave comments.']";
	String enablepasswordCheckBox = "(//input[@type='checkbox'])[1]";
	String passwordTextBox = "//input[@type='password']";
	String emptyPasswordError = "//p[text()='Password is required.']";
	String characterLimitError = "//div[2]/div[2]/div[2]/div/p[text()]";
	String allowGuestUploadCheckBox = "(//input[@type='checkbox'])[2]";
	String allowDataUploadlist = "//div[@id='gballowedsize']";
	String openListView = "//ul[contains(@role,'listbox')]";
	String addPortalButton = "//span[text()='Add']";
	String existingPortalErrorMsg = "(//div[@class='MuiAlert-message'])";
	String emptyPasswordErrorMsg = "(//p[text()='Password is required.'])";
	String duplicatePortalName = "//span[text()='Automation']";

	String errorMsg = "//p[@id='standard-basic-helper-text']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");
	String strPortalName = prop.getProperty("strPortalName");
	String strExistingPortalName = prop.getProperty("strExistingPortalName");
	String strCharlimit = prop.getProperty("strCharlimit");
	String strDuplicatePortalName = prop.getProperty("strDuplicatePortalName");


	// All other Variables
	String audioFilesPath = projectDirectory + "\\FilesToUpload\\AudioFiles\\";
	String docFilesPath = projectDirectory + "\\FilesToUpload\\DocFiles\\";
	String videoFilesPath = projectDirectory + "\\FilesToUpload\\VideoFiles\\";
	String videoFileName = "Test42MB.avi";

	/**
	 *This Method Navigates to the IoPortal section
	 *
	 * @author Mudassir
	 */
	public void navigateToIoPortal(String caseName) {
		try {
			logPassStepInExtentReport(caseName);
			clickWebElement(leftPanelIoPortalButton);
			logPassStepInExtentReportWithScreenshot("IoPortal button clicked successfully");
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String copiedSuccessOrFailureMessage = "";
	String failureMessage = "";
	String DescriptionMessage = "";

	/**
	 *This section 
	 *
	 * @author Mudassir
	 */
	public void verifyCreatePortalFunctionality() throws Exception {
		try {
			navigateToIoPortal("TC 001 : Verify Create Portal Function");
			clickWebElement(createPortalButton);
			logPassStepInExtentReportWithScreenshot(" Create Portal button is functional and redirects to the correct page.");
			clickWebElement(addfolderButton);

			/**
			 *This Section of code verifies folder gets added without any name.
			 */
			logPassStepInExtentReport(" Adding The Folder Without Any Name");
			clickWebElement(FolderSaveButton);
			if (isWebElementDisplayed(errorMsg)) {
				failureMessage = getTextFromWeb(errorMsg);
				logPassStepInExtentReportWithScreenshot("Empty Name Notification : " + failureMessage);
				logPassStepInExtentReport(" Empty Name validation is working.");
			} else {
				logPassStepInExtentReport(" Validation failed for Empty Name.");
			}

			/**
			 *This Section of code verifies Existing Folder name gets added or not.
			 */
			logPassStepInExtentReport(" Adding The Folder Name Which already Exists ");
			setTextInTextField(addfolderNameTextBox, strExistingPortalName);
			clickWebElement(FolderSaveButton);
			if (isWebElementDisplayed(errorMsg)) {
				failureMessage = getTextFromWeb(errorMsg);
				logPassStepInExtentReportWithScreenshot("Existing Folder Notification : " + failureMessage);
				logPassStepInExtentReport(" Existing Folder validation is working.");
			} else {
				logPassStepInExtentReport(" Validation failed for Existing Folder.");
			}

			/**
			 *This Section of code verifies Exceeding Character Limits is allowed or not.
			 */
			logPassStepInExtentReport(" Adding The Folder Name Exceeding Character Limits ");
			setTextInTextField(addfolderNameTextBox, strCharlimit);
			clickWebElement(FolderSaveButton);
			if (isWebElementDisplayed(errorMsg)) {
				failureMessage = getTextFromWeb(errorMsg);
				logPassStepInExtentReportWithScreenshot("Character Limit Notification : " + failureMessage);
				logPassStepInExtentReport(" Character Limit validation is working.");
			} else {
				logPassStepInExtentReport(" Validation failed for Character Limit.");
			}	

			/**
			 *This Section of code verifies after selecting the roles the description is Visible or not.
			 */
			refreshWebPage();
			logPassStepInExtentReport(" Verify the Roles and Description are visible. ");
			clickWebElement(createPortalButton);
			clickWebElementWithoutScrolling(duplicatePortalName);
			clickWebElement(nextButton);
			clickWebElement(roleSelectionButton);
			isWebElementDisplayed(readerRole);
			clickWebElement(readerRole);
			logPassStepInExtentReport(" Selected The Reader Role ");
			if (isWebElementDisplayed(readerDescription)) {
				DescriptionMessage = getTextFromWeb(readerDescription);
				logPassStepInExtentReportWithScreenshot("Reader Role Description : " + DescriptionMessage);
				logPassStepInExtentReport(" Description shows as per Reader role. ");
			} else {
				logPassStepInExtentReport(" Description is not visible ");
			}
			explicitWaitInSeconds(3);

			clickWebElement(roleSelectionButton);
			isWebElementDisplayed(commenterRole);
			clickWebElement(commenterRole);
			logPassStepInExtentReport(" Selected The Commenter Role ");
			if (isWebElementDisplayed(commenterRoleDescription)) {
				DescriptionMessage = getTextFromWeb(commenterRoleDescription);
				logPassStepInExtentReportWithScreenshot("Commenter Role Description : " + DescriptionMessage);
				logPassStepInExtentReport(" Description shows as per Commenter role. ");
			} else {
				logPassStepInExtentReport(" Description is not visible ");
			}
			explicitWaitInSeconds(3);

			clickWebElement(roleSelectionButton);
			isWebElementDisplayed(editorRole);
			clickWebElement(editorRole);
			logPassStepInExtentReport(" Selected The Editor Role ");
			if (isWebElementDisplayed(editorRoleDescription)) {
				DescriptionMessage = getTextFromWeb(editorRoleDescription);
				logPassStepInExtentReportWithScreenshot("Editor Role Description : " + DescriptionMessage);
				logPassStepInExtentReport(" Description shows as per Editor role. ");
			} else {
				logPassStepInExtentReport(" Description is not visible ");
			}

			/**
			 *This Section of code verifies the password section Validations.
			 */

			refreshWebPage();
			logPassStepInExtentReport(" Verify the Roles and Description are visible. ");
			clickWebElement(createPortalButton);
			clickWebElementWithoutScrolling(duplicatePortalName);
			clickWebElement(nextButton);
			clickWebElement(enablepasswordCheckBox);
			clickWebElement(addPortalButton);
			if (isWebElementDisplayed(emptyPasswordErrorMsg)) {
				DescriptionMessage = getTextFromWeb(emptyPasswordErrorMsg);
				logPassStepInExtentReportWithScreenshot("Empty password Description : " + DescriptionMessage);
				logPassStepInExtentReport(" Empty Password validation is working. ");
			} else {
				logPassStepInExtentReport(" Validation failed for Empty Password. ");
			}
			clickWebElement(passwordTextBox);
			setTextInTextField(passwordTextBox, strCharlimit);
			if (isWebElementDisplayed(characterLimitError)) {
				DescriptionMessage = getTextFromWeb(characterLimitError);
				logPassStepInExtentReportWithScreenshot("Exceeding Character Description : " + DescriptionMessage);
				logPassStepInExtentReport(" Exceeding Character validation is working. ");
			} else {
				logPassStepInExtentReport(" Validation failed for Exceeding Character. ");
			}

			/**
			 *This Section of code verifies the Guest upload Validations.
			 */

			clickWebElement(createPortalButton);
			clickWebElementWithoutScrolling(duplicatePortalName);
			clickWebElement(nextButton);
			logPassStepInExtentReport(" Verify the Guest upload Validations and the list upload data value. ");
			clickWebElement(allowGuestUploadCheckBox);
			logPassStepInExtentReport("Guest Upload Checkbox clicked successfully.");

			clickWebElement(allowDataUploadlist);
			if (isWebElementDisplayed(allowDataUploadlist)) {
				logPassStepInExtentReport("Dropdown is displayed.");
			} else {
				logPassStepInExtentReport("Dropdown is not displayed.");
			}

			/**
			 *This Section of code verifies existing portal name is added or not.
			 */
			refreshWebPage();
			logPassStepInExtentReport(" Creating a Portal With The Protal Name Which already Exists ");
			clickWebElement(createPortalButton);
			clickWebElementWithoutScrolling(duplicatePortalName);
			clickWebElement(nextButton);
			clickWebElement(addPortalButton);

			if (isWebElementDisplayed(existingPortalErrorMsg)) {
				failureMessage = getTextFromWeb(existingPortalErrorMsg);
				logPassStepInExtentReportWithScreenshot("Portal Creation Notification : " + failureMessage);
				logPassStepInExtentReport(" Existing Portal validation is working.");
			} else {
				logPassStepInExtentReport(" Validation failed for Existing Portal.");
			}

			/**
			 *This Section of code adds the portal and verifies its completion.
			 */
			refreshWebPage();
			clickWebElement(createPortalButton);
			clickWebElement(addfolderButton);
			logPassStepInExtentReport("Add Folder Button Clicked Successfully");

			setTextInTextField(addfolderNameTextBox, strPortalName);
			logPassStepInExtentReport("Folder Name Added Successfully");
			explicitWaitInMilliSeconds(2);
			clickWebElement(FolderSaveButton);
			logPassStepInExtentReportWithScreenshot("Clicked on Save Button");
			clickWebElement(folderselection);
			logPassStepInExtentReport("Folder Selected Successfully");
			clickWebElement(nextButton);       
			explicitWaitInSeconds(2);
			clickWebElement(addPortalButton);

			clickWebElement(topPanelNotificationButton);
			logPassStepInExtentReportWithScreenshot(" Checking for Portal Creation Status ");

			String commonNotificationLabel = "//*[text()='Notifications']//following::p[contains(text(),'created successfully')][1]";
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(commonNotificationLabel)) {
				copiedSuccessOrFailureMessage = getTextFromWeb(commonNotificationLabel);
				logPassStepInExtentReportWithScreenshot("Portal Creation Notification : " + copiedSuccessOrFailureMessage);

				copiedSuccessOrFailureMessage.contains("created successfully");
				logPassStepInExtentReport("Portal was created successfully.");

				clickWebElement(closeNotificationButton);
				logPassStepInExtentReportWithScreenshot("Notification Tab Closed Successfully");
			} else {
				copiedSuccessOrFailureMessage = "Portal creation notification not found.";
				logFailStepInExtentReport("Failed to find portal creation notification.");
				throw new AssertionError("Portal creation failed: " + copiedSuccessOrFailureMessage);
			}

		} catch (Exception e) {
			logFailStepInExtentReport("Exception occurred during portal creation: " + e.getMessage());
			throw new RuntimeException("Portal creation failed.", e); 
		}
	}
}


