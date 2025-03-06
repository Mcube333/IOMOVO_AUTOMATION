package com.iomovo.pagespackage.EncodeFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class AWSS3VideoEncodeFunctionality extends BaseClass{

	public AWSS3VideoEncodeFunctionality(WebDriver driver, WebDriverWait wait) {
		BaseClass.driver = driver;
        BaseClass.wait = wait;
	}

	String automationFolder = "//a[text()='automationfolder']";
	String convertFolder = "//a[text()='Convert Folder']";
	String encodeVideoFolder = "//a[text()='Encode Video Folder']";
	String videoFileSelection = "//td[a[text()='VideoFile.mp4']]/preceding-sibling::td//input[@type='checkbox']";
	String videoFileEllipseButton = "//button[@aria-controls='simple-menu']";
	String ellipseMenuConvertButton = "//li[@data-id='Convert' and contains(@class, 'MuiMenuItem-root')]";
	String encodeDropdownButton = "(//div[contains(@class, 'MuiSelect-root') and @role='button'])[6]";
	String resolution1080P = "//li[@role='option' and @name='HD 1080p']";
	String resolution720P = "//li[@role='option' and @name='HD 720p']";
	String resolution480P = "//li[@role='option' and @name='480p']";
	String resolution360P = "//li[@role='option' and @name='360p']";
	String resolution240P = "//li[@role='option' and @name='240p']";
	
	String uploadNewFileCheckbox = "//input[@type='checkbox' and @name='createNewFile']";
	
	String transcodeButton = "//p[text()='Transcode']";
	String formatInputField = "//div/button[@type='button' and @title='Open']";
	String formatsListDropdownButton = "//button[@title='Open']";
	String formatPastingField = "//input[@type='text']";
	String resolutionDropdownButton = "(//div[@aria-haspopup='listbox'])[7]";
	String resolutionSelection = "//span[text()='Same as Source']";
	String formatSelctionDropdown = "//div[text()=' Video']";
	String audioFormatSelection = "//li[text()=' Audio']";
	String convertButton = "//a[@role='button' and span[text()='Convert']]";

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
	String leftPanelIoFlowButton = "//div[@title='Workflow Status Report']";
	String leftPanelIOCloud_MyFiles = "//div[text()='My Files']";
	String ioCloudSelectAllButton = "//span[text()='Select All']";
	String ioCloudUpload = "//span[text()='Upload']";
	String ioCloudDeleteButton = "//span[text()='Delete']";
	String uploadingStatusBar = "//div[@id='panel1a-header']";
	String topPanelNotificationButton = "//button[@aria-label='notifications']";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String MultipleFileSelectionFolder = "//td[3]/div/a[text()='Multiple Avi Files ']";

	String noDataAvailableOnDriveLable = "//div/strong[text()=' No data found in the directory']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");
	
	String fileConvertedLabel = "//p[starts-with(text(), 'Completed:')]";

	
	public void verifyVideoEncoding(String resolutionXPath, String testCaseName) throws Exception {
	    try {
	        logPassStepInExtentReport(testCaseName);

	        clickWebElement(leftPanelIoHubButton);
	        clickWebElement(LeftPanelAWSDriveButton);
	        doubleClickUsingActionClassWithoutScrolling(automationFolder);
	        doubleClickUsingActionClassWithoutScrolling(convertFolder);
	        doubleClickUsingActionClassWithoutScrolling(encodeVideoFolder);
	        
	        clickWebElementWithoutScrolling(videoFileSelection);
//	        assertTrue(isWebElementDisplayed(videoFileSelection), "MP4 Video File Selection Failed!");

	        clickWebElementWithoutScrolling(videoFileEllipseButton);
	        clickWebElementWithoutScrolling(ellipseMenuConvertButton);
	        clickWebElement(encodeDropdownButton);

	        clickWebElement(resolutionXPath);  // Pass resolution dynamically
	        logPassStepInExtentReport("Selected resolution: " + resolutionXPath);
	        
	        clickWebElement(uploadNewFileCheckbox);
	        clickWebElement(convertButton);
	        clickWebElement(topPanelNotificationButton);

	        waitUntilElementGetsAppeared(fileConvertedLabel);

	        if (isWebElementDisplayed(fileConvertedLabel)) {
	            logPassStepInExtentReportWithScreenshot("File encoded successfully to " + resolutionXPath);
	        } else {
	            logFailStepInExtentReport("File encoding Failed");
	            assertTrue(false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        logFailStepInExtentReport("Exception: " + e.getMessage());
	        assertTrue(false);
	    } finally {
	        clickWebElement(closeNotificationButton);
	    }
	}

	public void VerifyVideoEncodeFunctionalityto1080pinAWSS3Drive() throws Exception {
	    verifyVideoEncoding(resolution1080P, "TC 001: Verify Video Encode Functionality to 1080p in AWSS3 Drive");
	}

	public void VerifyVideoEncodeFunctionalityto720pinAWSS3Drive() throws Exception {
	    verifyVideoEncoding(resolution720P, "TC 002: Verify Video Encode Functionality to 720p in AWSS3 Drive");
	}

	public void VerifyVideoEncodeFunctionalityto480pinAWSS3Drive() throws Exception {
	    verifyVideoEncoding(resolution480P, "TC 003: Verify Video Encode Functionality to 480p in AWSS3 Drive");
	}
	
	public void VerifyVideoEncodeFunctionalityto360pinAWSS3Drive() throws Exception {
	    verifyVideoEncoding(resolution360P, "TC 004: Verify Video Encode Functionality to 360p in AWSS3 Drive");
	}
	
	public void VerifyVideoEncodeFunctionalityto240pinAWSS3Drive() throws Exception {
	    verifyVideoEncoding(resolution240P, "TC 005: Verify Video Encode Functionality to 240p in AWSS3 Drive");
	}

}
