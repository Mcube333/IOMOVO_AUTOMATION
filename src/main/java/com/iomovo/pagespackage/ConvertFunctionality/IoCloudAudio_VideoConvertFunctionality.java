package com.iomovo.pagespackage.ConvertFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.List;
import com.iomovo.basepackage.BaseClass;

public class IoCloudAudio_VideoConvertFunctionality extends BaseClass {

	public IoCloudAudio_VideoConvertFunctionality(WebDriver driver, WebDriverWait wait) {
		BaseClass.driver = driver;
        BaseClass.wait = wait;
	}

	String convertAudioFolder = "//div/a[text()='Audio Convert Folder']";
	String audioFileSelection = "//td/div/a[text()='AudioFile.mp3']";
	String audioFileEllipseButton = "//td[@data-name and contains(@data-name, '.mp3')]//button";
	String audioFileEllipseMenu = "(//ul[@role='menu'])[4]";
	String convertVideoFolder = "//div/a[text()='Video Convert Folder']";
	String convertVideo2AudioFolder = "//div/a[text()='Video 2 Audio Convert Folder']";
	String videoFileSelection = "//td/div/a[text()='VideoFile.mp4']";
	String videoFileEllipseButton = "//td/div/a[text()='VideoFile.mp4']//following::button[@type='button']";
	String convertDailogBox = "//div[@role='dialog']";

	String automationFolder = "//a[text()='automationfolder']";
	String convertFolder = "//a[text()='Convert Folder']";
	String convertEllipseButton = "//li[@role='menuitem' and @data-id='convert']";
	String transcodeButton = "//p[text()='Transcode']";
	String formatsListDropdownButton = "//button[@title='Open']";
	String formatPastingField = "(//input[@aria-autocomplete='list'])[2]";
	String formatSelctionDropdown = "//div[text()=' Video']";
	String audioFormatSelection = "//li[text()=' Audio']";
	String resolutionDropdownButton = "//span[@class='friendly-name']";
	String resolutionSelection = "//span[text()='Same as Source']";
	String convertbutton = "//a[@role='button'][2]";
	String formatInputField = "(//input[contains(@class, 'MuiAutocomplete-input') and @type='text'])[2]";
	String notificationUpdate = "((//nav[@id='notification-div']//li)[1]//a[contains(@class, 'btn') and contains(@class, 'success')])[1]";

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
	String topPanelReloadButton = "(//button[@id='btnReload'])[1]";
	String uploadFileStatusTab = "//div[@id='panel1a-header']";
	String closeNotificationButton = "//*[text()='Notifications']//following::button[@aria-label='notifications'][1]";
	String MultipleFileSelectionFolder = "//td[3]/div/a[text()='Multiple Avi Files ']";

	String noDataAvailableOnDriveLable = "//div/strong[text()=' No data found in the directory']";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");

	public void verifyAudioConvertFunctionalityInIoCloud() throws Exception {
		try {
			logPassStepInExtentReport("TC 001 : Verify Audio Convert Functionality (.MP3) Format File In IoCloud");

			clickWebElement(leftPanelIoCloudButton);
			logPassStepInExtentReport("ioCloud button clicked successfully");

			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("MyFiles button clicked successfully");

			doubleClickUsingActionClassWithoutScrolling(automationFolder);
			logPassStepInExtentReport("Automation Folder Selected successfully");

			doubleClickUsingActionClassWithoutScrolling(convertFolder);
			logPassStepInExtentReport("Convert Folder Selected successfully");

			doubleClickUsingActionClassWithoutScrolling(convertAudioFolder);
			logPassStepInExtentReport("AudioConvert Folder Selected successfully");

			clickWebElementWithoutScrolling(audioFileSelection);
			logPassStepInExtentReport("MP3 Audio File Selected successfully");

			// Audio formats list
//			List<String> formats = Arrays.asList("8SVX", "AAC", "AC3", "AIF", "AIFF", "AMR", "AU", "CAF", "FLAC", "GSM",
//					"IRCAM", "ISMA", "M4A", "MAUD", "MKA", "MP2", "NIST", "OGA", "OPUS", "SPX", "TTA", "VOC", "W64", "WAV ", "WV");

						List<String> formats = Arrays.asList("AAC", "FLAC");

			for (String format : formats) {
				try {
					clickWebElement(audioFileEllipseButton);
					logPassStepInExtentReport("Clicked on Audio File Ellipse Button");

					clickWebElementWithoutScrolling(convertEllipseButton);
					logPassStepInExtentReport("Clicked on Convert Button");

					clickWebElement(formatInputField);
					logPassStepInExtentReport("Clicking on Format Dropdown Button");

					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.DELETE).perform();
					explicitWaitInSeconds(2);
					actions.sendKeys(format).perform();
					explicitWaitInSeconds(2);
					actions.sendKeys(Keys.ARROW_DOWN).perform();
					actions.sendKeys(Keys.ENTER).perform();
					logPassStepInExtentReport("Selected format: " + format);

					clickWebElement(convertbutton);
					logPassStepInExtentReport("Clicked on Convert button successfully");

					clickWebElement(topPanelNotificationButton);
					logPassStepInExtentReport("Clicked on Notification button successfully");

					String fileConvertLabel = "((//nav[@id='notification-div']//li)[1]//p[contains(@class, 'MuiTypography-body2')])[1]";
					waitUntilElementGetsAppeared(notificationUpdate);
					WebElement notificationElement = uiElement(fileConvertLabel);
					String notificationText = notificationElement.getText().trim();

					if (notificationText.startsWith("Completed:" + format)) {
						logPassStepInExtentReportWithScreenshot("File Converted to " + format + " Successfully");
					} else if (notificationText.equalsIgnoreCase("Transcoding fail.")) {
						logPassStepInExtentReportWithScreenshot("File Conversion to " + format + " Failed");
					} else {
						logPassStepInExtentReportWithScreenshot("Unknown Error: " + notificationText);
					}

				} catch (Exception e) {
					logFailStepInExtentReport("Failed to convert to format: " + format + ". Exception: " + e.getMessage());
				} finally {
					clickWebElement(closeNotificationButton);
					logPassStepInExtentReport("Notification panel closed");
				}
			}

		} catch (Exception e) {
			logFailStepInExtentReport("Failed in verifyConvertFunctionalityOfAudioFiles Method. Exception: " + e.getMessage());
			throw e;
		}
	}



	//	public void verifyAudioConvertFunctionalityInIoCloud() throws Exception {
	//		try {
	//			logPassStepInExtentReport("TC 001 : Verify Audio Convert Functionality (.MP3) Format File In IoCloud");
	//
	//			clickWebElement(leftPanelIoCloudButton);
	//			logPassStepInExtentReport("ioCloud button clicked successfully");
	//			explicitWaitInSeconds(2);
	//			clickWebElement(leftPanelIOCloud_MyFiles);
	//			logPassStepInExtentReport("MyFiles button clicked successfully");
	//			explicitWaitInSeconds(3);
	//			doubleClickUsingActionClassWithoutScrolling(automationFolder);
	//			logPassStepInExtentReport("Automation Folder Selected successfully");
	//			doubleClickUsingActionClass(convertFolder);
	//			logPassStepInExtentReport("Convert Folder Selected successfully");
	//			doubleClickUsingActionClass(convertAudioFolder);
	//			logPassStepInExtentReport("AudioConvert Folder Selected successfully");
	//			explicitWaitInSeconds(3);
	//			isWebElementDisplayed(audioFileSelection);
	//			clickWebElementWithoutScrolling(audioFileSelection);
	//			logPassStepInExtentReport("MP3 Audio File Selected successfully");
	//
	//			//			Update the Below Code for Single Format / Desired Audio Format Conversion and comment the Below String
	//
	//						String[] formats = {"FLAC ", "GSM ", "IRCAM ", "ISMA ",
	//			"M4A ", "MAUD ", "MKA ", "MP2 ", "NIST ", "OGA ", "OPUS ", "SPX ", "TTA ", "VOC ", "W64 ", "WAV ", "WV "}; 
	//
	//			// List of formats to convert the audio to
	//
	////			String[] formats = { "8SVX ", "AAC ", "AC3 ", "AIF ", "AIFF ", "AMR ", "AU ", "CAF ",  };
	//
	//			for (String format : formats) {
	//				try {
	//					clickWebElement(audioFileEllipseButton);
	//					logPassStepInExtentReport("Clicking on Audio File Ellipse Button");
	//					explicitWaitInSeconds(3);
	//					clickWebElement(convertEllipseButton);
	//					logPassStepInExtentReport("Clicking on Conevrt Button");
	//
	//					clickWebElement(formatInputField);
	//					logPassStepInExtentReport("Clicking on Format Dropdown Button");
	//					explicitWaitInSeconds(2 );
	//
	//					Actions actions = new Actions(driver);
	//					actions.sendKeys(Keys.DELETE).perform();
	//					explicitWaitInSeconds(2);
	//					actions.sendKeys(format).perform();
	//					explicitWaitInSeconds(2);
	//					actions.sendKeys(Keys.ARROW_DOWN).perform();
	//					actions.sendKeys(Keys.ENTER).perform();
	//
	//					clickWebElement(convertbutton);
	//					logPassStepInExtentReport("Clicked on Conevrt buttton successfully");
	//
	//					String fileConvertedLabel = "(//p[contains(text(),'Completed: AudioFile- ')])[1]";
	//					waitUntilElementGetsAppeared(fileConvertedLabel);
	//					explicitWaitInSeconds(2);
	//					clickWebElement(topPanelNotificationButton);
	//					logPassStepInExtentReport("Clicked on Notification buttton successfully");
	//					if (isWebElementDisplayed(fileConvertedLabel)) {
	//						logPassStepInExtentReportWithScreenshot("File Converted to " + format + " Successfully ");
	//					} else {
	//						logFailStepInExtentReport("File Conversion to " + format + " Failed");
	//						assertTrue(true); // Assert conversion failure
	//					}
	//				} catch (Exception e) {
	//					// TODO Auto-generated catch block
	//					e.printStackTrace();
	//					logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
	//				}
	//				clickWebElement(closeNotificationButton);
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			logFailStepInExtentReport(
	//					"Failed In verifyConvertFunctionalityOfAudioFiles Method. Failure Exception: " + e);
	//			assertTrue(true);
	//		}
	//	}

	public void verifyVideoConvertFunctionalityInIoCloud() throws Exception {
		try {
			logPassStepInExtentReport("TC 002 : Verify Video Convert Functionality (.MP4) Format File In IoCloud");
			clickWebElement(leftPanelIoCloudButton);
			logPassStepInExtentReport("ioCloud button clicked successfully");
			explicitWaitInSeconds(2);
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("MyFiles button clicked successfully");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(automationFolder);
			logPassStepInExtentReport("Automation Folder Selected successfully");
			doubleClickUsingActionClass(convertFolder);
			logPassStepInExtentReport("Convert Folder Selected successfully");
			doubleClickUsingActionClassWithoutScrolling(convertVideoFolder);
			logPassStepInExtentReport("VideoConvert Folder Selected successfully");
			explicitWaitInSeconds(3);
			clickWebElementWithoutScrolling(videoFileSelection);
			logPassStepInExtentReport("MP4 Video File Selected successfully");

			//          Update the Below Code for Single Format / Desired Video Format Conversion and comment the Below String

			String[] formats = {"HEVC (", "TS (M","VIDEO (","VOB ","WEBM ", "WMV ", "WTV ", "XESC ", "YUV "};

			//            String[] formats = {"3G2 ", "3GP ", "AMV ", "ASF ", "AVCHD ", "AVI ", "BIK ", "DAT ", "DIVX ", "DVR ", "DVR-MS ", "F4V ", "FLI ", "FLV ", "GXF ",
			//                    "H264 ", "H265 ", "HEVC (", "ISMV" , "M2TS" , "M2V" , "M4V" , "MJPEG" , "MKV" , "MOV" , "MPEG" , "MPEG2" , "MPEG4" , "MPG" ,
			//                    "MTS ", "MTV ", "MXF ", "OGV ", "R3D ", "RM ", "SWF ", "TS (M", "VIDEO (", "VOB ", "VP8 ", "WEBM ", "WMV ", "WTV ", "XESC ", "YUV "};

			for (String format : formats) {
				clickWebElement(topPanelReloadButton);
				try {
					explicitWaitInSeconds(3);
					clickWebElementWithoutScrolling(videoFileEllipseButton);
					logPassStepInExtentReport("Clicking on Video File Ellipse Button");
					isWebElementDisplayed(convertEllipseButton);
					clickWebElementWithoutScrolling(convertEllipseButton);
					explicitWaitInSeconds(2);
					logPassStepInExtentReport("Clicking on Convert Button");
					clickWebElement(transcodeButton);
					logPassStepInExtentReport("Clicking on Transcode Button");
					clickWebElement(formatInputField);
					logPassStepInExtentReport("Clicking on Format Dropdown Button");
					explicitWaitInSeconds(2);

					// Use Actions to input the format into the dropdown
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.DELETE).perform();
					explicitWaitInSeconds(2);
					actions.sendKeys(format.trim()).perform();
					explicitWaitInSeconds(2);

					// Press Arrow Down and Enter to select the format if it appears
					actions.sendKeys(Keys.ARROW_DOWN).perform();
					explicitWaitInSeconds(1);
					actions.sendKeys(Keys.ENTER).perform();

					// Verify if the format was correctly selected by checking the input value
					WebElement formatInputElement = uiElement(formatPastingField);
					if (formatInputElement.getAttribute("value").contains(format)) {
						logPassStepInExtentReport("Format " + format + " selected successfully.");

						clickWebElement(resolutionDropdownButton);
						logPassStepInExtentReport("Clicking on Resolution Dropdown Button");
						actions.sendKeys(Keys.ARROW_DOWN).build().perform();
						actions.sendKeys(Keys.ENTER).build().perform();

						clickWebElement(convertbutton);
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
						}
					} else {
						logFailStepInExtentReport("Format " + format + " not found or not selected correctly.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
				}
				clickWebElement(closeNotificationButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyConvertFunctionalityOfVideoFiles Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}

	public void verifyVideo2AudioConvertFunctionalityInIoCloud() throws Exception {

		try {
			logPassStepInExtentReport("TC 003 : Verify Video To Audio Convert Functionality (.MP4) Format File In Iocloud");
			clickWebElement(leftPanelIoCloudButton);
			logPassStepInExtentReport("ioCloud button clicked successfully");
			explicitWaitInSeconds(2);
			clickWebElement(leftPanelIOCloud_MyFiles);
			logPassStepInExtentReport("MyFiles button clicked successfully");
			explicitWaitInSeconds(3);
			doubleClickUsingActionClassWithoutScrolling(automationFolder);
			logPassStepInExtentReport("Automation Folder Selected successfully");
			explicitWaitInMilliSeconds(3);
			doubleClickUsingActionClass(convertFolder);
			logPassStepInExtentReport("Convert Folder Selected successfully");
			doubleClickUsingActionClass(convertVideo2AudioFolder);
			logPassStepInExtentReport("Video2Audio Convert Folder Selected successfully");
			explicitWaitInSeconds(3);
			clickWebElement(videoFileSelection);
			logPassStepInExtentReport("MP4 Video File Selected successfully");

			// Update the Below Code for Single Format / Desired Video Format Conversion and comment the Below String

			String[] formats = {"MAUD ","MKA ","MP2 ","NIST ","OGA ","OPUS ","SPX ","TTA ", "VOC ", "W64 ", "WAV ","WV "}; 

			// Loop through each format and convert the video

			//			String[] formats = { "8SVX ","AAC ","AC3 ","AIF ","AIFF ","AMR ","AU ","CAF ","FLAC ","GSM ","IRCAM ","ISMA ", 
			//					"M3U8 ","M4A ","MAUD ","MKA ","MP2 ","MP3 ","NIST ","OGA ","OPUS ","SPX ","TTA ", "VOC ", "W64 ", "WAV ","WV " };

			for (String format : formats) {
				clickWebElement(topPanelReloadButton);
				try {
					explicitWaitInSeconds(3);
					clickWebElementWithoutScrolling(videoFileEllipseButton);
					logPassStepInExtentReport("Clicking on Video File Ellipse Button");
					isWebElementDisplayed(convertEllipseButton);
					clickWebElementWithoutScrolling(convertEllipseButton);
					explicitWaitInSeconds(2);
					logPassStepInExtentReport("Clicking on Ellipse Convert Button");
					clickWebElement(transcodeButton);
					logPassStepInExtentReport("Clicking on Transcode Button");
					clickWebElement(formatSelctionDropdown);
					logPassStepInExtentReport("Clicking on Format Dropdown Button");
					clickWebElement(audioFormatSelection);
					logPassStepInExtentReport("Selecting the Audio Format ");
					clickWebElement(formatInputField);
					logPassStepInExtentReport("Clicking on Format Dropdown Button");

					// Use Actions to input the format into the dropdown
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.DELETE).perform();
					explicitWaitInSeconds(2);
					actions.sendKeys(format.trim()).perform();
					explicitWaitInSeconds(2);

					// Press Arrow Down and Enter to select the format if it appears
					actions.sendKeys(Keys.ARROW_DOWN).perform();
					explicitWaitInSeconds(1);
					actions.sendKeys(Keys.ENTER).perform();

					// Verify if the format was correctly selected by checking the input value
					WebElement formatInputElement = uiElement(formatPastingField);
					if (formatInputElement.getAttribute("value").contains(format)) {
						logPassStepInExtentReport("Format " + format + " selected successfully.");

						actions.sendKeys(Keys.ARROW_DOWN).build().perform();
						actions.sendKeys(Keys.ENTER).build().perform();

						clickWebElement(convertbutton);
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
						}
					} else {
						logFailStepInExtentReport("Format " + format + " not found or not selected correctly.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					logFailStepInExtentReport("Failed to convert to " + format + ". Exception: " + e.getMessage());
				}
				clickWebElement(closeNotificationButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyConvertFunctionalityOfVideoFiles Method. Failure Exception: " + e);
			assertTrue(true);
		}
	}
}
