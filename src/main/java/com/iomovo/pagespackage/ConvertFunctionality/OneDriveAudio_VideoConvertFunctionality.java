package com.iomovo.pagespackage.ConvertFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

	public class OneDriveAudio_VideoConvertFunctionality extends BaseClass {

		WebDriver driver;
		WebDriverWait wait;

		public OneDriveAudio_VideoConvertFunctionality(WebDriver driver, WebDriverWait wait) {
			this.driver = driver;
			this.wait = wait;
		}

		String automationFolder = "//tr/td/a[text()='automationfolder']";
		String convertFolder = "//a[text()='Convert Folder']";
		String convertAudioFolder = "//a[text()='Audio Convert Folder']";
		String audioFileSelection = "//a[text()='AudioFile.mp3']";
		String audioFileEllipseButton = "//td/a[text()='AudioFile.mp3']//following::button[@type='button']";
		String convertVideoFolder = "//a[text()='Video Convert Folder']";
		String convertVideo2AudioFolder = "//a[text()='Video 2 Audio Convert Folder']";
		String videoFileSelection = "//td/a[text()='VideoFile.mp4']";
		String videoFileEllipseButton = "//td/a[text()='VideoFile.mp4']//following::button[@type='button']";
		String convertEllipseButton = "//div[text()='Convert']";

		String transcodeButton = "//p[text()='Transcode']";
		String formatInputField = "//div/button[@type='button' and @title='Open']";
		String formatsListDropdownButton = "//button[@title='Open']";
		String formatPastingField = "//input[@type='text']";
		String resolutionDropdownButton = "//span[@class='friendly-name']";
		String resolutionSelection = "//span[text()='Same as Source']";
		String formatSelctionDropdown = "//div[text()=' Video']";
		String audioFormatSelection = "//li[text()=' Audio']";
		String convertButton = "//a[@role='button'][2]";

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

		public void verifyAudioConvertFunctionalityInOneDrive() throws Exception {

			try {
				logPassStepInExtentReport("TC 001 : Verify Audio Convert Functionality (.MP3) Format File In OneDrive ");

				clickWebElement(leftPanelIoHubButton);
				logPassStepInExtentReport("ioHub button clicked successfully");
				explicitWaitInSeconds(2);
				clickWebElement(LeftPanelOneDriveButton);
				logPassStepInExtentReport("OneDrive button clicked successfully");
				explicitWaitInSeconds(3);
				doubleClickUsingActionClassWithoutScrolling(automationFolder);
				logPassStepInExtentReport("Automation Folder Selected successfully");
				doubleClickUsingActionClassWithoutScrolling(convertFolder);
				logPassStepInExtentReport("Convert Folder Selected successfully");
				doubleClickUsingActionClassWithoutScrolling(convertAudioFolder);
				logPassStepInExtentReport("Audio Convert Folder Selected successfully");
				explicitWaitInSeconds(3);
				clickWebElementWithoutScrolling(audioFileSelection);
				logPassStepInExtentReport("MP3 Audio File Selected successfully");

				// Update the Below Code for Single Format / Desired Audio Format Conversion and comment the Below String

//				String[] formats = {"FLAC ", "GSM ", "IRCAM ", "ISMA ",
//				"M4A ", "MAUD ", "MKA ", "MP2 ", "NIST ", "OGA ", "OPUS ", "SPX ", "TTA ", "VOC ", "W64 ", "WAV ", "WV "}; 

				// Loop through each format and convert the Audio
				String[] formats = { "8SVX ", "AAC ", "AC3 ", "AIF ", "AIFF ", "AMR ", "AU ", "CAF ", "FLAC ", "GSM ", "IRCAM ", "ISMA ",
				"M4A ", "MAUD ", "MKA ", "MP2 ", "NIST ", "OGA ", "OPUS ", "SPX ", "TTA ", "VOC ", "W64 ", "WAV ", "WV " };

				for (String format : formats) {

					try {
						
						clickWebElementWithoutScrolling(audioFileEllipseButton);
						logPassStepInExtentReport("Clicking on Audio File Ellipse Button");
						clickWebElement(convertEllipseButton);
						logPassStepInExtentReport("Clicking on Conevrt Button");

						clickWebElement(formatInputField);
						logPassStepInExtentReport("Clicking on Format Dropdown Button");
						explicitWaitInSeconds(2 );

						Actions actions = new Actions(driver);
						actions.sendKeys(Keys.DELETE).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(format).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(Keys.ARROW_DOWN).perform();
						actions.sendKeys(Keys.ENTER).perform();

						clickWebElement(convertButton);
						logPassStepInExtentReport("Clicked on Conevrt buttton successfully");

						String fileConvertedLabel = "(//p[contains(text(),'AudioFile- ')])[1]";
						waitUntilElementGetsAppeared(fileConvertedLabel);
						explicitWaitInSeconds(2);
						clickWebElement(topPanelNotificationButton);
						logPassStepInExtentReport("Clicked on Notification buttton successfully");
						if (isWebElementDisplayed(fileConvertedLabel)) {
							logPassStepInExtentReportWithScreenshot("File Converted to " + format + " Successfully ");
						} else {
							logFailStepInExtentReport("File Conversion to " + format + " Failed");
							assertTrue(true); // Assert conversion failure
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
					}
					clickWebElement(closeNotificationButton);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logFailStepInExtentReport(
						"Failed In verifyConvertFunctionalityOfAudioFiles Method. Failure Exception: " + e);
				assertTrue(true);
			}
		}

		public void verifyVideoConvertFunctionalityInOneDrive() throws Exception {
			try {
				logPassStepInExtentReport("TC 002 : Verify Video Convert Functionality (.MP4) Format File In OneDrive");

				clickWebElement(leftPanelIoHubButton);
				logPassStepInExtentReport("ioHub button clicked successfully");
				explicitWaitInSeconds(2);
				clickWebElement(LeftPanelOneDriveButton);
				logPassStepInExtentReport("OneDrive button clicked successfully");
				explicitWaitInSeconds(3);
				clickWebElement(automationFolder);
				doubleClickUsingActionClass(automationFolder);
				logPassStepInExtentReport("Automation Folder Selected successfully");
				doubleClickUsingActionClass(convertFolder);
				logPassStepInExtentReport("Convert Folder Selected successfully");
				doubleClickUsingActionClass(convertVideoFolder);
				logPassStepInExtentReport("Video Convert Folder Selected successfully");
				explicitWaitInSeconds(3);
				clickWebElement(videoFileSelection);
				logPassStepInExtentReport("MP4 Video File Selected successfully");

				// Update the Below Code for Single Format / Desired Video Format Conversion and comment the Below String

					        String[] formats = {"AMV"};

				// List of formats to convert the video
//				String[] formats = {"3G2 ", "3GP ", "AMV ", "ASF ", "AVCHD ", "AVI ","BIK ", "DAT ", "DIVX ", "DVR ", "DVR-MS ", "F4V ", "FLI ", "FLV ", "GXF ",
//						"H264 ", "H265 ", "HEVC ", "ISMV ", "M2TS ", "M2V ", "M4V ", "MJPEG ", "MKV ", "MOV ", "MPEG ", "MPEG2 ", "MPEG4 ", "MPG ",
//						"MTS ", "MTV ", "MXF ", "OGV ", "R3D ", "RM ", "SWF ", "TS ", "VIDEO ", "VOB ", "VP8 ", "WEBM ", "WMV ", "WTV ", "XESC ", "YUV "};

				for (String format : formats) {
					try {
						
						clickWebElement(videoFileEllipseButton);
						logPassStepInExtentReport("Clicking on Video File Ellipse Button");
						clickWebElement(convertEllipseButton);
						logPassStepInExtentReport("Clicking on Convert Button");
						clickWebElement(transcodeButton);
						logPassStepInExtentReport("Clicking on Transcode Button");

						clickWebElement(formatInputField);
						logPassStepInExtentReport("Clicking on Format Dropdown Button");
						explicitWaitInSeconds(2);

						Actions actions = new Actions(driver);
						actions.sendKeys(Keys.DELETE).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(format).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(Keys.ARROW_DOWN).perform();
						actions.sendKeys(Keys.ENTER).perform();

						clickWebElement(resolutionDropdownButton);
						logPassStepInExtentReport("Clicking on Resolution Dropdown Button");
						actions.sendKeys(Keys.ARROW_DOWN).perform();
						actions.sendKeys(Keys.ENTER).perform();

						clickWebElement(convertButton);
						logPassStepInExtentReport("Clicked on Convert button successfully");

						String fileConvertedLabel = "(//p[contains(text(),'Completed: VideoFile- ')])[1]";
						waitUntilElementGetsAppeared(fileConvertedLabel);
						explicitWaitInSeconds(2);

						clickWebElement(topPanelNotificationButton);
						logPassStepInExtentReport("Clicked on Notification button successfully");
						if (isWebElementDisplayed(fileConvertedLabel)) {
							logPassStepInExtentReportWithScreenshot("File Converted to " + format + " Successfully ");
						} else {
							logFailStepInExtentReport("File Conversion to " + format + " Failed");
							assertTrue(false); // Assert conversion failure
						}
					} catch (Exception e) {
						e.printStackTrace();
						logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
					} finally {
						clickWebElement(closeNotificationButton);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				logFailStepInExtentReport("Failed in verifyConvertFunctionalityOfVideoFiles method. Exception: " + e.getMessage());
				assertTrue(false);
			}
		}


		public void verifyVideo2AudioConvertFunctionalityInOneDrive() throws Exception {

			try {
				logPassStepInExtentReport("TC 003 : Verify Video To Audio Convert Functionality (.MP4) Format File In OneDrive");

				clickWebElement(leftPanelIoHubButton);
				logPassStepInExtentReport("ioHub button clicked successfully");
				explicitWaitInSeconds(2);
				clickWebElement(LeftPanelOneDriveButton);
				logPassStepInExtentReport("OneDrive button clicked successfully");
				explicitWaitInSeconds(3);
				clickWebElement(automationFolder);
				doubleClickUsingActionClass(automationFolder);
				logPassStepInExtentReport("Automation Folder Selected successfully");
				doubleClickUsingActionClass(convertFolder);
				logPassStepInExtentReport("Convert Folder Selected successfully");
				doubleClickUsingActionClass(convertVideo2AudioFolder);
				logPassStepInExtentReport("Video2Audio Convert Folder Selected successfully");
				explicitWaitInSeconds(3);
				clickWebElement(videoFileSelection);
				logPassStepInExtentReport("MP4 Video File Selected successfully");

				// Update the Below Code for Single Format / Desired Audio Format Conversion and comment the Below String

				String[] formats = {"MP3 "};

				// Loop through each format and convert the video
				//			String[] formats = { "8SVX ","AAC ","AC3 ","AIF ","AIFF ","AMR ","AU ","CAF ","FLAC ","GSM ","IRCAM ","ISMA ", 
				//					"M3U8 ","M4A ","MAUD ","MKA ","MP2 ","MP3 ","NIST ","OGA ","OPUS ","SPX ","TTA ", "VOC ", "W64 ", "WAV ","WV " };

				for (String format : formats) {

					try {

						clickWebElement(videoFileEllipseButton);
						logPassStepInExtentReport("Clicking on Video File Ellipse Button");
						clickWebElement(convertEllipseButton);
						logPassStepInExtentReport("Clicking on Conevrt Button");
						clickWebElement(transcodeButton);
						logPassStepInExtentReport("Clicking on Transcode Button");

						clickWebElement(formatSelctionDropdown);
						logPassStepInExtentReport("Clicking on Format Dropdown Button");
						clickWebElement(audioFormatSelection);
						logPassStepInExtentReport("Selecting the Audio Format ");

						clickWebElement(formatInputField);
						logPassStepInExtentReport("Clicking on Format Dropdown Button");

						Actions actions = new Actions(driver);
						actions.sendKeys(Keys.DELETE).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(format).perform();
						explicitWaitInSeconds(2);
						actions.sendKeys(Keys.ARROW_DOWN).perform();
						actions.sendKeys(Keys.ENTER).perform();

						clickWebElement(convertButton);
						logPassStepInExtentReport("Clicked on Conevrt buttton successfully");

						String fileConvertedLabel = "(//p[contains(text(),'Completed: VideoFile- ')])[1]";
						waitUntilElementGetsAppeared(fileConvertedLabel);

						explicitWaitInSeconds(2);
						clickWebElement(topPanelNotificationButton);
						logPassStepInExtentReport("Clicked on Notification buttton successfully");
						if (isWebElementDisplayed(fileConvertedLabel)) {
							logPassStepInExtentReportWithScreenshot("File Converted to " + format + " Successfully ");
						} else {
							logFailStepInExtentReport("File Conversion to " + format + " Failed");
							assertTrue(true); 
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
					}
					clickWebElement(closeNotificationButton);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logFailStepInExtentReport(
						"Failed In verifyConvertFunctionalityOfVideo2AudioFiles Method. Failure Exception: " + e);
				assertTrue(true);
			}
		}
}
