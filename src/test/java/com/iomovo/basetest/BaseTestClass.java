package com.iomovo.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseTestClass extends BaseClass{
	protected static final Logger log = Logger.getLogger(BaseTestClass.class);

	protected static WebDriver driver;
	protected static Properties config;
	LoginPage loginpage;

	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException {
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		try {
			logInfoStepInExtentReport("********** Inside beforeSuite Method **********");
			loadPropertiesFile();  // Load configuration properties
			numberOfAttemptsToFindWebElements();  // Set retry attempts for locating elements
			extReport = extentReportsClass.startReport("IOMOVO App Automation");  // Start test report
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Parameters({"browser"})
	@BeforeMethod
	public void testSetUp(@Optional("chrome") String browser) throws InterruptedException {
		logInfoStepInExtentReport("********** Inside testSetUp Method **********");

		// Configure Chrome browser options
		logInfoStepInExtentReport("********** Initializing WebDriver **********");
		try {
			if (driver == null) {
				driver = initializeDriver(browser);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				logInfoStepInExtentReport("WebDriver initialized for browser: " + browser);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("WebDriver initialization failed in BaseTestClass.");
		}
	}

	private WebDriver initializeDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new ChromeDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			return new ChromeDriver();
		case "chrome":
		default:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.setAcceptInsecureCerts(true);
			return new ChromeDriver(options);
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			logInfoStepInExtentReport("Test Failed: Capturing Screenshot...");
		}
		if (driver != null) {
			driver.quit();
			driver = null; 
			logInfoStepInExtentReport("WebDriver session closed.");// Prevent stale WebDriver instance
		}
	}

	public void captureScreenshot(String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");
		try {
			Files.createDirectories(dest.getParentFile().toPath());
			Files.copy(src.toPath(), dest.toPath());
			logInfoStepInExtentReport("Screenshot saved: " + dest.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}