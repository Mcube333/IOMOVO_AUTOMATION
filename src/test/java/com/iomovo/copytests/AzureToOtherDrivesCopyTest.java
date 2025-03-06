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
import com.iomovo.pagespackage.CopyFunctionality.AzureDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AzureToOtherDrivesCopyTest extends BaseClass 
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
		//		handlingSSL.addArguments("--incognito");
		driver = new ChromeDriver(handlingSSL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}

	//These Below Methods are for Login Functionality tests

	@Test
	public void LoginTest() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyCopyFilesFunctionalityFromAzureToOtherDrives() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

//			AzureDriveCopyFunctionality IoCloudDrive = new AzureDriveCopyFunctionality(driver, wait);
//			IoCloudDrive.verifyCopyFilesFunctionalityFromAzureToIoCloudDrive();
//			
//			AzureDriveCopyFunctionality AWSDrive = new AzureDriveCopyFunctionality(driver, wait);
//			AWSDrive.verifyCopyFilesFunctionalityFromAzureToAWSDrive();
//			
//			AzureDriveCopyFunctionality BoxDrive = new AzureDriveCopyFunctionality(driver, wait);
//			BoxDrive.verifyCopyFilesFunctionalityFromAzureToBoxDrive();
//
//			AzureDriveCopyFunctionality DropBoxDrive = new AzureDriveCopyFunctionality(driver, wait);
//			DropBoxDrive.verifyCopyFilesFunctionalityFromAzureToDropBoxDrive();
//
//			AzureDriveCopyFunctionality FTPDrive = new AzureDriveCopyFunctionality(driver, wait);
//			FTPDrive.verifyCopyFilesFunctionalityFromAzureToFTPDrive();
//
//			AzureDriveCopyFunctionality GoogleCloudDrive = new AzureDriveCopyFunctionality(driver, wait);
//			GoogleCloudDrive.verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive();
//
//			AzureDriveCopyFunctionality GoogleDrive = new AzureDriveCopyFunctionality(driver, wait);
//			GoogleDrive.verifyCopyFilesFunctionalityFromAzureToGoogleDrive();
//
//			AzureDriveCopyFunctionality AzureDrive = new AzureDriveCopyFunctionality(driver, wait);
//			AzureDrive.verifyCopyFilesFunctionalityFromAzureToAzureDrive();
//
//			AzureDriveCopyFunctionality OneDrive = new AzureDriveCopyFunctionality(driver, wait);
//			OneDrive.verifyCopyFilesFunctionalityFromAzureToOneDrive();
//
//			AzureDriveCopyFunctionality SFTPDrive = new AzureDriveCopyFunctionality(driver, wait);
//			SFTPDrive.verifyCopyFilesFunctionalityFromAzureToSFTPDrive();
//			
//			AzureDriveCopyFunctionality SharePointDrive = new AzureDriveCopyFunctionality(driver, wait);
//			SharePointDrive.verifyCopyFilesFunctionalityFromAzureToSharePointDrive();

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

