package com.iomovo.copytests;

import java.io.FileNotFoundException;
import java.time.Duration;
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
import com.iomovo.pagespackage.CopyFunctionality.Optimised_BoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_BoxToOtherDrivesCopyTest extends BaseClass 
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	public void verifyCopyFilesFunctionalityFromBOXToOtherDrives() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			Optimised_BoxDriveCopyFunctionality IoCloudDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			IoCloudDrive.verifyCopyFilesFunctionalityFromBoxToIoCloudDrive();
			
			Optimised_BoxDriveCopyFunctionality AWSDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			AWSDrive.verifyCopyFilesFunctionalityFromBoxToAWSDrive();
			
			Optimised_BoxDriveCopyFunctionality BOXDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			BOXDrive.verifyCopyFilesFunctionalityFromBoxToBoxDrive();
			
			Optimised_BoxDriveCopyFunctionality DropBoxDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			DropBoxDrive.verifyCopyFilesFunctionalityFromBoxToDropBoxDrive();
			
			Optimised_BoxDriveCopyFunctionality FTPDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			FTPDrive.verifyCopyFilesFunctionalityFromBoxToFTPDrive();
			
			Optimised_BoxDriveCopyFunctionality GoogleCloudDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			GoogleCloudDrive.verifyCopyFilesFunctionalityFromBoxToGoogleCloudDrive();
			
			Optimised_BoxDriveCopyFunctionality GoogleDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			GoogleDrive.verifyCopyFilesFunctionalityFromBoxToGoogleDrive();
			
			Optimised_BoxDriveCopyFunctionality AzureDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			AzureDrive.verifyCopyFilesFunctionalityFromBoxToAzureDrive();
			
			Optimised_BoxDriveCopyFunctionality OneDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			OneDrive.verifyCopyFilesFunctionalityFromBoxToOneDrive();
			
			Optimised_BoxDriveCopyFunctionality OOSDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			OOSDrive.verifyCopyFilesFunctionalityFromBoxToOOSDrive();
			
			Optimised_BoxDriveCopyFunctionality SFTPDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			SFTPDrive.verifyCopyFilesFunctionalityFromBoxToOOSDrive();
			
			Optimised_BoxDriveCopyFunctionality SharePointDrive = new Optimised_BoxDriveCopyFunctionality(driver, wait);
			SharePointDrive.verifyCopyFilesFunctionalityFromBoxToSharePointDrive();

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

