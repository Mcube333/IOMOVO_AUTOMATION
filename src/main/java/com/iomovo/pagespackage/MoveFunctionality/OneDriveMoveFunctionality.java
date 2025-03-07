package com.iomovo.pagespackage.MoveFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class OneDriveMoveFunctionality extends BaseClass {

	public OneDriveMoveFunctionality(WebDriver driver, WebDriverWait wait) {
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
	String ioCloudToIocloudMoveDataPaste = "//tr/td/div/a[text()='IoCloudtoIoCloud']";
	String awsToIocloudMoveDataPaste = "//tr/td/div/a[text()='AWStoIoCloud']";
	String boxToIocloudMoveDataPaste = "//tr/td/div/a[text()='BoxDrivetoIoCloud']";
	String dropBoxToIocloudMoveDataPaste = "//tr/td/div/a[text()='DropBoxtoIoCloud']";
	String ftpToIocloudMoveDataPaste = "//tr/td/div/a[text()='FTPtoIoCloud']";
	String googleCloudToIocloudMoveDataPaste = "//tr/td/div/a[text()='GoogleCloudtoIoCloud']";
	String googleDriveToIocloudMoveDataPaste = "//tr/td/div/a[text()='GoogleDrivetoIoCloud']";
	String azureToIocloudMoveDataPaste = "//tr/td/div/a[text()='AzuretoIoCloud']";
	String oneDriveToIocloudMoveDataPaste = "//tr/td/div/a[text()='OneDrivetoIoCloud']";
	String sftpToIocloudMoveDataPaste = "//tr/td/div/a[text()='SFTPtoIoCloud']";
	String sharePointToIocloudMoveDataPaste = "//tr/td/div/a[text()='SharePointtoIoCloud']";

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
	String ioCloudToAwsMoveDataPaste = "//tr/td[*]/a[text()='IoCloudtoAWS']";
	String awsToAwsMoveDataPaste = "//tr/td[*]/a[text()='AWStoAWS']";
	String boxToAwsMoveDataPaste = "//tr/td[*]/a[text()='BoxDrivetoAWS']";
	String dropBoxToAwsMoveDataPaste = "//tr/td[*]/a[text()='DropBoxtoAWS']";
	String ftpToAwsMoveDataPaste = "//tr/td[*]/a[text()='FTPtoAWS']";
	String googleCloudToAwsMoveDataPaste = "//tr/td[*]/a[text()='GoogleCloudtoAWS']";
	String googleDriveToAwsMoveDataPaste = "//tr/td[*]/a[text()='GoogleDrivetoAWS']";
	String azureToAwsMoveDataPaste = "//tr/td[*]/a[text()='AzuretoAWS']";
	String oneDriveToAwsMoveDataPaste = "//tr/td[*]/a[text()='OneDrivetoAWS']";
	String sftpToAwsMoveDataPaste = "//tr/td[*]/a[text()='SFTPtoAWS']";
	String sharePointToAwsMoveDataPaste = "//tr/td[*]/a[text()='SharePointtoAWS']";

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
	String ioCloudToBoxMoveDataPaste = "//tr/td/a[text()='IoCloudToBox']";
	String awsToBoxMoveDataPaste = "//tr/td/a[text()='AWSToBox']";
	String boxToBoxMoveDataPaste = "//tr/td/a[text()='BoxToBox']";
	String dropBoxToBoxMoveDataPaste = "//tr/td/a[text()='DropBoxToBox']";
	String ftpToBoxMoveDataPaste = "//tr/td/a[text()='FTPToBox']";
	String googleCloudToBoxMoveDataPaste = "//tr/td/a[text()='GoogleCloudToBox']";
	String googleDriveToBoxMoveDataPaste = "//tr/td/a[text()='GoogleDriveToBox']";
	String azureToBoxMoveDataPaste = "//tr/td/a[text()='AzureToBox']";
	String oneDriveToBoxMoveDataPaste = "//tr/td/a[text()='OneDriveToBox']";
	String sftpToBoxMoveDataPaste = "//tr/td/a[text()='SFTPToBox']";
	String sharePointToBoxMoveDataPaste = "//tr/td/a[text()='SharePointToBox']";
	
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
	String ioCloudToDropBoxMoveDataPaste = "//tr/td/a[text()='IoCloudToDropBox']";
	String awsToDropBoxMoveDataPaste = "//tr/td/a[text()='AWSToDropBox']";
	String boxToDropBoxMoveDataPaste = "//tr/td/a[text()='BoxToDropBox']";
	String dropBoxToDropBoxMoveDataPaste = "//tr/td/a[text()='DropBoxToDropBox']";
	String ftpToDropBoxMoveDataPaste = "//tr/td/a[text()='FTPToDropBox']";
	String googleCloudToDropBoxMoveDataPaste = "//tr/td/a[text()='GoogleCloudToDropBox']";
	String googleDriveToDropBoxMoveDataPaste = "//tr/td/a[text()='GoogleDriveToDropBox']";
	String azureToDropBoxMoveDataPaste = "//tr/td/a[text()='AzureToDropBox']";
	String oneDriveToDropBoxMoveDataPaste = "//tr/td/a[text()='OneDriveToDropBox']";
	String sftpToDropBoxMoveDataPaste = "//tr/td/a[text()='SFTPToDropBox']";
	String sharePointToDropBoxMoveDataPaste = "//tr/td/a[text()='SharePointToDropBox']";

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
	String ioCloudToFtpMoveDataPaste = "//tr/td/a[text()='IoCloudToFtp']";
	String awsToFtpMoveDataPaste = "//tr/td/a[text()='AWSToFtp']";
	String boxToFtpMoveDataPaste = "//tr/td/a[text()='BoxToFtp']";
	String dropBoxToFtpMoveDataPaste = "//tr/td/a[text()='DropBoxToFtp']";
	String ftpToFtpMoveDataPaste = "//tr/td/a[text()='FTPToFtp']";
	String googleCloudToFtpMoveDataPaste = "//tr/td/a[text()='GoogleCloudToFtp']";
	String googleDriveToFtpMoveDataPaste = "//tr/td/a[text()='GoogleDriveToFtp']";
	String azureToFtpMoveDataPaste = "//tr/td/a[text()='AzureToFtp']";
	String oneDriveToFtpMoveDataPaste = "//tr/td/a[text()='OneDriveToFtp']";
	String sftpToFtpMoveDataPaste = "//tr/td/a[text()='SFTPToFtp']";
	String sharePointToFtpMoveDataPaste = "//tr/td/a[text()='SharePointToFtp']";

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
	String ioCloudToGoogleCloudMoveDataPaste = "//tr/td/a[text()='IoCloudToGoogleCloud']";
	String awsToGoogleCloudMoveDataPaste = "//tr/td/a[text()='AWSToGoogleCloud']";
	String boxToGoogleCloudMoveDataPaste = "//tr/td/a[text()='BoxToGoogleCloud']";
	String dropBoxToGoogleCloudMoveDataPaste = "//tr/td/a[text()='DropBoxToGoogleCloud']";
	String ftpToGoogleCloudMoveDataPaste = "//tr/td/a[text()='FTPToGoogleCloud']";
	String googleCloudToGoogleCloudMoveDataPaste = " //tr/td/a[text()='GoogleCloudToGoogleCloud']"; 
	String googleDriveToGoogleCloudMoveDataPaste = "//tr/td/a[text()='GoogleDriveToGoogleCloud']";
	String azureToGoogleCloudMoveDataPaste = "//tr/td/a[text()='AzureToGoogleCloud']";
	String oneDriveToGoogleCloudMoveDataPaste = "//tr/td/a[text()='OneDriveToGoogleCloud']";
	String sftpToGoogleCloudMoveDataPaste = "//tr/td/a[text()='SFTPToGoogleCloud']";
	String sharePointToGoogleCloudMoveDataPaste = "//tr/td/a[text()='SharePointToGoogleCloud']";
	
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
	String ioCloudToGoogleDriveMoveDataPaste = "//tr/td/a[text()='IoCloudToGoogleDrive']";
	String awsToGoogleDriveMoveDataPaste = "//tr/td/a[text()='AWSToGoogleDrive']";
	String boxToGoogleDriveMoveDataPaste = "//tr/td/a[text()='BoxToGoogleDrive']";
	String dropBoxToGoogleDriveMoveDataPaste = "//tr/td/a[text()='DropBoxToGoogleDrive']";
	String ftpToGoogleDriveMoveDataPaste = "//tr/td/a[text()='FTPToGoogleDrive']";
	String googleCloudToGoogleDriveMoveDataPaste = "//tr/td/a[text()='GoogleCloudToGoogleDrive']";
	String googleDriveToGoogleDriveMoveDataPaste = "//tr/td/a[text()='GoogleDriveToGoogleDrive']";
	String azureToGoogleDriveMoveDataPaste = "//tr/td/a[text()='AzureToGoogleDrive']";
	String oneDriveToGoogleDriveMoveDataPaste = "//tr/td/a[text()='OneDriveToGoogleDrive']";
	String sftpToGoogleDriveMoveDataPaste = "//tr/td/a[text()='SFTPToGoogleDrive']";
	String sharePointToGoogleDriveMoveDataPaste = "//tr/td/a[text()='SharePointToGoogleDrive']";

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
	String ioCloudToAzureMoveDataPaste = "//tr/td/a[text()='IocloudToAzure']";
	String awsToAzureMoveDataPaste = "//tr/td/a[text()='AwsToAzure']";
	String boxToAzureMoveDataPaste = "//tr/td/a[text()='BoxToAzure']";
	String dropBoxToAzureMoveDataPaste = "//tr/td/a[text()='DropBoxToAzure']";
	String ftpToAzureMoveDataPaste = "//tr/td/a[text()='FtpToAzure']";
	String googleCloudToAzureMoveDataPaste = "//tr/td/a[text()='GoogleCloudToAzure']";
	String googleDriveToAzureMoveDataPaste = "//tr/td/a[text()='GloogleDriveToAzure']";
	String azureToAzureMoveDataPaste = "//tr/td/a[text()='AzureToAzure']";
	String oneDriveToAzureMoveDataPaste = "//tr/td/a[text()='OneDriveToAzure']";
	String sftpToAzureMoveDataPaste = "//tr/td/a[text()='SftpToAzure']";
	String sharePointToAzureMoveDataPaste = "//tr/td/a[text()='SharePointToAzure']";

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
	String ioCloudToOneDriveMoveDataPaste = "//tr/td/a[text()='IoCloudToOneDrive']";
	String awsToOneDriveMoveDataPaste = "//tr/td/a[text()='AWSToOneDrive']";
	String boxToOneDriveMoveDataPaste = "//tr/td/a[text()='BoxToOneDrive']";
	String dropBoxToOneDriveMoveDataPaste = "//tr/td/a[text()='DropBoxToOneDrive']";
	String ftpToOneDriveMoveDataPaste = "//tr/td/a[text()='FTPToOneDrive']";
	String googleCloudToOneDriveMoveDataPaste = "//tr/td/a[text()='GoogleCloudToOneDrive']";
	String googleDriveToOneDriveMoveDataPaste = "//tr/td/a[text()='GoogleDriveToOneDrive']";
	String azureToOneDriveMoveDataPaste = "//tr/td/a[text()='AzureToOneDrive']";
	String oneDriveToOneDriveMoveDataPaste = "//tr/td/a[text()='OneDriveToOneDrive']";
	String sftpToOneDriveMoveDataPaste = "//tr/td/a[text()='SFTPToOneDrive']";
	String sharePointToOneDriveMoveDataPaste = "//tr/td/a[text()='SharePointToOneDrive']";

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
	String ioCloudToSftpMoveDataPaste = "//tr/td/a[text()='IoCloudToSftp']";
	String awsToSftpMoveDataPaste = "//tr/td/a[text()='AWSToSftp']";
	String boxToSftpMoveDataPaste = "//tr/td/a[text()='BoxToSftp']";
	String dropBoxToSftpMoveDataPaste = "//tr/td/a[text()='DropBoxToSftp']";
	String ftpToSftpMoveDataPaste = "//tr/td/a[text()='FTPToSftp']";
	String googleCloudToSftpMoveDataPaste = "//tr/td/a[text()='GoogleCloudToSftp']";
	String googleDriveToSftpMoveDataPaste = "//tr/td/a[text()='GoogleDriveToSftp']";
	String azureToSftpMoveDataPaste = "//tr/td/a[text()='AzureToSftp']";
	String oneDriveToSftpMoveDataPaste = "//tr/td/a[text()='OneDriveToSftp']";
	String sftpToSftpMoveDataPaste = "//tr/td/a[text()='SFTPToSftp']";
	String sharePointToSftpMoveDataPaste = "//tr/td/a[text()='SharePointToSftp']";

	String sharePointDriveDropDownSelection = "//li[text()='Fish SP Drive']";
//	String sharePointFolderSelectonRoot = "//span[text()='ioMoVoQATeam']";
	String sharePointFolderSelectonRoot = "//a[text()='ioMoVoQATeam']";
	String switchToGridViewButton = "//button[@title='Switch to Grid View']";
	String switchToListViewButton = "//button[@title='Switch to List View']";
//	String sharePointFolderSelectionL1 = "//span[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionL1 = "//*/td[3]/a[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionL1Grid = "//*/span[text()='Automationtestingfolder-DND']";
	String sharePointFolderSelectionCopy = "//p/span[text()='Copy Folder']";
	String sharePointFolderSelectionMove = "//tr/td/a[text()='Move Folder']";
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
	String ioCloudToSharePointMoveDataPaste = "//tr/td/a[text()='IoCloudToSharePoint']";
	String awsToSharePointMoveDataPaste = "//tr/td/a[text()='AWSToSharePoint']";
	String boxToSharePointMoveDataPaste = "//tr/td/a[text()='BoxToSharePoint']";
	String dropBoxToSharePointMoveDataPaste = "//tr/td/a[text()='DropBoxToSharePoint']";
	String ftpToSharePointMoveDataPaste = "//tr/td/a[text()='FTPToSharePoint']";
	String googleCloudToSharePointMoveDataPaste = "//tr/td/a[text()='GoogleCloudToSharePoint']";
	String googleDriveToSharePointMoveDataPaste = "//tr/td/a[text()='GoogleDriveToSharePoint']";
	String azureToSharePointMoveDataPaste = "//tr/td/a[text()='AzureToSharePoint']";
	String oneDriveToSharePointMoveDataPaste = "//tr/td/a[text()='OneDriveToSharePoint']";
	String sftpToSharePointMoveDataPaste = "//tr/td/a[text()='SFTPToSharePoint']";
	String sharePointToSharePointMoveDataPaste = "//tr/td/a[text()='SharePointToSharePoint']";

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
	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String ioCloudSelectAllButton = "//span[text()='Select All']";
	String ioCloudUpload = "//span[text()='Upload']";
	String ioCloudDeleteButton = "//span[text()='Delete']";
	String uploadingStatusBar = "//div[@id='panel1a-header']";
	String topPanelNotificationButton = "//button[@aria-label='notifications']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String MultipleFileSelectionFolder = "//td[3]/div/a[text()='Multiple Avi Files ']";
	
	String moveFilesConfirmation = "//div/p/*[contains (text(),'Moved successfully')]";
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
	 *This Method Navigates to the OneDrive
	 *
	 * @author Mudassir
	 */
	public void navigateToOneDrive(String caseName) {
		try {
			logPassStepInExtentReport(caseName);
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelOneDriveButton);
			logPassStepInExtentReportWithScreenshot("OneDrive button clicked successfully");
			explicitWaitInSeconds(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *This Method Moves Data From OneDrive Source Folder
	 *
	 * @author Mudassir
	 */
	public void moveFilesFromSourceFolder() {
		try {
			doubleClickUsingActionClass(commonFolderXpathLeftPanel("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("Data Folder"));
			explicitWaitInSeconds(3);
			clickWebElement(selectingFiles);
			logPassStepInExtentReportWithScreenshot(" Selecting The Files from OneDrive ");	
			explicitWaitInSeconds(3);
			clickWebElement(ioCloudMoveButton);
			logPassStepInExtentReportWithScreenshot(" Move Butoon clicked Successfully ");
			explicitWaitInSeconds(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *This Method Pastes the Data Moved From OneDrive Source Folder
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
			
			waitUntilElementGetsAppeared(moveFilesConfirmation); 
			String commonNotificationLabel = "//*[text()='Notifications']//following::p[contains(text(),'Moved')][1]";
			explicitWaitInSeconds(5);

			clickWebElement(topPanelNotificationButton);

			if (isWebElementDisplayed(commonNotificationLabel)) {
				copiedSuccessOrFailureMessage = getTextFromWeb(commonNotificationLabel);
				clickWebElement(closeNotificationButton);
				logPassStepInExtentReportWithScreenshot(" Closing The Notification Tab ");
				explicitWaitInSeconds(5);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return copiedSuccessOrFailureMessage;
	}

	public void verifyMoveFilesFunctionalityFromOneDriveToIoCloudDrive() throws Exception {
		try {
			navigateToOneDrive("TC 001 : Verify Move Files Functionality From OneDrive To ioCloud Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoCloudButton);
			logPassStepInExtentReportWithScreenshot(" Selecting IoCloud Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("OneDriveToIoCloud"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To IoCloud Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToIoCloudDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToAWSDrive() throws Exception {
		try {
			navigateToOneDrive("TC 002 : Verify Move Files Functionality From OneDrive To Aws Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelAWSDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting AWS Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioHub("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("OneDrivetoAWS"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To Aws Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToAwsDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToBOXDrive() throws Exception {
		try {
			navigateToOneDrive("TC 003 : Verify Move Function From OneDrive To Box Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelBoxDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Box Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoBox"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To Box Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToBOXDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToDropBoxDrive() throws Exception {
		try {
			navigateToOneDrive("TC 004 : Verify Move Function From OneDrive To DropBox Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelDropBoxDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting DropBox Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoDropBox"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To DropBox Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToDropBoxDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToFTPDrive() throws Exception {
		try {
			navigateToOneDrive("TC 005 : Verify Move Function From OneDrive To FTP Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelFTPDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting FTP Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoFtp"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To FTP Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToFTPDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToGoogleCloudDrive() throws Exception {
		try {
			navigateToOneDrive("TC 006 : Verify Move Function From OneDrive To GoogleCloud Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelGoogleCloudDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting GoogleCloud Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoGoogleCloud"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To GoogleCloud Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToGoogleCloudDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToGoogleDrive() throws Exception {
		try {
			navigateToOneDrive("TC 007 : Verify Move Function From OneDrive To Google Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelGoogleDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Google Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoGoogleDrive"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To Google Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToGoogleDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToAzureDrive() throws Exception {
		try {
			navigateToOneDrive("TC 008 : Verify Move Function From OneDrive To Azure Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelAzureDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting Azure Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDrivetoAzure"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To Azure Drive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToAzureDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyMoveFilesFunctionalityFromOneDriveToOneDrive() throws Exception {
		try {
			navigateToOneDrive("TC 009 : Verify Move Function From OneDrive To OneDrive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelOneDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting OneDrive Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDriveToOneDrive"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To OneDrive");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToOneDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromAWSToOOSDrive() throws Exception {
		try {
			navigateToOneDrive("TC 010 : Verify Move Function From OneDrive To OOS Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelOracleDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting OOS Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDriveToOOS"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To OOS");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToOOSDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToSFTPDrive() throws Exception {
		try {
			navigateToOneDrive("TC 011 : Verify Move Function From OneDrive To SFTP Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelSFTPDriveButton);
			logPassStepInExtentReportWithScreenshot(" Selecting SFTP Drive ");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClass(commonFolderXpathioCloud("OneDriveToSftp"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To SFTP");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToSFTPDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
	
	public void verifyMoveFilesFunctionalityFromOneDriveToSharePointDrive() throws Exception {
		try {
			navigateToOneDrive("TC 012 : Verify Move Function From OneDrive To SharePoint Drive");
			moveFilesFromSourceFolder();
			clickWebElement(leftPanelIoHubButton);
			clickWebElement(LeftPanelSharePointDriveButton);
			logPassStepInExtentReportWithScreenshot("Selecting SharePoint Drive");
			explicitWaitInSeconds(5);
			doubleClickUsingActionClass(sharePointFolderSelectonRoot);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("automationfolder"));
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpath("Move Folder"));
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(commonFolderXpathioCloud("OneDriveToSharePoint"));
			explicitWaitInSeconds(3);
			pasteFilesToTargetFolder();

			String copiedSuccessOrFailureMessage = pasteFilesToTargetFolder();
			if (!copiedSuccessOrFailureMessage.contains("Failed")) {
				logPassStepInExtentReportWithScreenshot(" File Successfully Moved From OneDrive To SharePoint");
			} else {
				logFailStepInExtentReport(" Files Not Moved ");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyMoveFilesFunctionalityFromOneDriveToSharePointDrive Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
}