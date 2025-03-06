package com.iomovo.copytests;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AwsToOtherDrivesCopyTest extends BaseClass 
{
	/**
	 * This Method Runs Before Suite. Logs, extent report and properties file are
	 * loaded and configured. Screen Recording is started to monitor the execution.
	 * 
	 * @author Mudassir
	 * @throws FileNotFoundException
	 */
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException {
		try {
			System.out.println("********** Inside beforeSuite Method **********");
			loadPropertiesFile();
			numberOfAttemptsToFindWebElements();
			extReport = extentReportsClass.startReport("IOMOVO App Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method Runs Before Each Method or TestCase. Here Web Driver is
	 * initialized and configured.
	 * 
	 * @author Mudassir
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void testSetUp() throws InterruptedException {
		System.out.println("********** Inside testSetUp Method **********");
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		System.out.println("********** After WebDriverManager **********");
		ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.addArguments("use-fake-ui-for-media-stream");
		handlingSSL.setAcceptInsecureCerts(true);
		handlingSSL.addArguments("--incognito");
		driver = new ChromeDriver(handlingSSL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void verifyCopyFilesFunctionalityFromAWSToOtherDrives() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();
			
//			AwsDriveCopyFunctionality IoCloudDrive = new AwsDriveCopyFunctionality(driver, wait);
//			IoCloudDrive.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
			
			AwsDriveCopyFunctionality AWSDrive = new AwsDriveCopyFunctionality(driver, wait);
			AWSDrive.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
			
//			AwsDriveCopyFunctionality BoxDrive = new AwsDriveCopyFunctionality(driver, wait);
//			BoxDrive.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
//			
//			AwsDriveCopyFunctionality DropBoxDrive = new AwsDriveCopyFunctionality(driver, wait);
//			DropBoxDrive.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
//			
//			AwsDriveCopyFunctionality FTPDrive = new AwsDriveCopyFunctionality(driver, wait);
//			FTPDrive.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
//			
//			AwsDriveCopyFunctionality GoogleCloudDrive = new AwsDriveCopyFunctionality(driver, wait);
//			GoogleCloudDrive.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
//			
//			AwsDriveCopyFunctionality GoogleDrive = new AwsDriveCopyFunctionality(driver, wait);
//			GoogleDrive.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
//			
//			AwsDriveCopyFunctionality AzureDrive = new AwsDriveCopyFunctionality(driver, wait);
//			AzureDrive.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
//			
//			AwsDriveCopyFunctionality OneDrive = new AwsDriveCopyFunctionality(driver, wait);
//			OneDrive.verifyCopyFilesFunctionalityFromAWSToOneDrive();
//			
//			AwsDriveCopyFunctionality OOSDrive = new AwsDriveCopyFunctionality(driver, wait);
//			OOSDrive.verifyCopyFilesFunctionalityFromAWSToOOSDrive();
//			
//			AwsDriveCopyFunctionality SFTPDrive = new AwsDriveCopyFunctionality(driver, wait);
//			SFTPDrive.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
//			
//			AwsDriveCopyFunctionality SharePointDrive = new AwsDriveCopyFunctionality(driver, wait);
//			SharePointDrive.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	
	@Test
	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method Closes all the Drivers (Browsers) after executing each test
	 * method
	 * 
	 * @author Mudassir
	 */
	@AfterMethod
	public void exitTest() {
		explicitWaitInSeconds(3);
		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This Method Runs After Suite. Extent report is ended. Screen Recording gets
	 * stopped and saved.
	 * 
	 * @author Mudassir
	 */
	@AfterSuite
	public void afterSuite() {
		extentReportsClass.endReport();
	}
}
