package com.iomovo.basepackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.iomovo.utilspackage.ExtentReportManager;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	
	public void click(WebElement element) {
	    flashElement(element);
	    element.click();
	}
	
	private static final Logger log = LogManager.getLogger(BaseClass.class);

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
	public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	public static ExtentReports extent;
	public static ExtentTest extReport;
	public static Properties prop;
	public static int numOfAttemptsToFindWebElement;
	public static String projectDirectory = System.getProperty("user.dir");

	// All Variables which fetches data from config.properties file
	public static String strUrl = "";
	public static String strUsername = "";
	public static String strPassword = "";

	public static String strEnv = "";

	public static String strUrlProd = "";
	public static String strUsernameProd = "";
	public static String strPasswordProd = "";

	public static String strUrlDev = "";
	public static String strUsernameDev = "";
	public static String strPasswordDev = "";

	public static String strUrlProdStaging = "";
	public static String strUsernameProdStaging = "";
	public static String strPasswordProdStaging = "";

	/**
	 * Runs before the test suite to initialize logging, reports, and config properties.
	 */
	@BeforeSuite
	public void beforeSuite() {
		try {
			log.info("Starting Test Suite...");
			loadPropertiesFile(); // Ensure properties are loaded
			ExtentReportManager.getExtentReports();

		} catch (Exception e) {
			throw new RuntimeException("❌ Failed to initialize test suite. Error: " + e.getMessage());
		}
	}

	/**
	 * Initializes WebDriver before each test and sets up Extent Reports.
	 */
	@Parameters({"browser", "os"})
	@BeforeMethod
	public void testSetUp(Method method, @Optional("chrome") String browser, @Optional("windows") String os) {
		log.info("Initializing WebDriver for browser: " + browser);

		WebDriver driver = initializeDriver(browser, os);
		if (driver != null) {
			tdriver.set(driver);
			wait.set(new WebDriverWait(driver, Duration.ofSeconds(30)));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} else {
			throw new RuntimeException("❌ WebDriver initialization failed for browser: " + browser);
		}

		// ✅ Ensure ExtentReports is initialized
		if (ExtentReportManager.getExtentReports() == null) {
			throw new RuntimeException("❌ ExtentReports is not initialized. Ensure it is set up in @BeforeSuite.");
		}

		// ✅ Start test in Extent Report
		ExtentTest test = ExtentReportManager.startTest(method.getName(), "Executing: " + method.getName());

		if (test == null) {
			throw new RuntimeException("❌ ExtentTest instance is null for: " + method.getName());
		}

		extTest.set(test); // ✅ Set the ExtentTest for logging
	}


	/**
	 * Initializes WebDriver for execution (local or remote).
	 */
	private WebDriver initializeDriver(String browser, String os) {
		WebDriver driver = null;
		String executionEnv = System.getProperty("execution_env", "local");

		try {
			if ("remote".equalsIgnoreCase(executionEnv)) {
				driver = initializeRemoteDriver(os, browser);
			} else {
				switch (browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					driver = new ChromeDriver(options);
					break;

				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;

				default:
					log.error("Invalid browser: " + browser);
					throw new IllegalArgumentException("Invalid browser: " + browser);
				}
			}
		} catch (Exception e) {
			log.error("Error initializing WebDriver: ", e);
			throw new RuntimeException("WebDriver initialization failed: " + e.getMessage());
		}

		if (driver == null) {
			log.error("WebDriver initialization failed.");
			throw new RuntimeException("WebDriver instance is null.");
		}

		tdriver.set(driver);
		return driver;
	}

	/**
	 * Initializes WebDriver for Remote Execution (Selenium Grid).
	 */
	private WebDriver initializeRemoteDriver(String os, String browser) {
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setPlatform(Platform.valueOf(os.toUpperCase()));
			capabilities.setBrowserName(browser);
			return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		} catch (Exception e) {
			log.error("Error initializing Remote WebDriver", e);
			throw new WebDriverException("Remote WebDriver initialization failed", e);
		}
	}

	/**
	 * Runs after each test method execution.
	 * Captures a screenshot on failure and quits WebDriver.
	 */
	@AfterMethod
	public void tearDown(ITestResult result) {
		ExtentTest test = ExtentReportManager.getCurrentTest(); // ✅ Fetch the current test instance

		if (test != null) {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = ExtentReportManager.captureScreenshot(getDriver());
				test.log(LogStatus.FAIL, "❌ Test Failed: " + result.getName());

				if (screenshotPath != null) {
					test.log(LogStatus.INFO, "📸 Screenshot: " + test.addScreenCapture(screenshotPath));
				}
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(LogStatus.PASS, "✅ Test Passed: " + result.getName());
			} else if (result.getStatus() == ITestResult.SKIP) {
				test.log(LogStatus.SKIP, "⚠️ Test Skipped: " + result.getName());
			}

			ExtentReportManager.endCurrentTest(); // ✅ Ensure the test is properly ended
		}

		// ✅ Ensure WebDriver is closed properly
		if (getDriver() != null) {
			getDriver().quit();
			tdriver.remove();
			wait.remove();
		}

		if (extTest.get() != null) {
			extTest.remove();
		}

		ExtentReportManager.flushReports(); // ✅ Ensure reports are updated
	}


	/**
	 * Captures a screenshot of the current browser view.
	 */
	public void captureScreenshot(String testName) {
		try {
			WebDriver driver = getDriver();
			if (driver != null) {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");

				if (!dest.getParentFile().exists() && !dest.getParentFile().mkdirs()) {
					log.error("Failed to create screenshot directory.");
					return;
				}

				Files.copy(src.toPath(), dest.toPath());
				log.info("Screenshot saved: " + dest.getAbsolutePath());
			} else {
				log.warn("WebDriver is null. Cannot capture screenshot.");
			}
		} catch (IOException e) {
			log.error("Failed to capture screenshot", e);
		}
	}

	/**
	 * Returns the WebDriver instance for the current thread.
	 */
	public static WebDriver getDriver() {
		return tdriver.get();
	}

	/**
	 * Returns the WebDriverWait instance for the current thread.
	 */
	public static WebDriverWait getWait() {
		return wait.get();
	}

	/**
	 * This method initializes and loads the property files
	 * 
	 * @author Mohammed_Mudassir
	 * @return
	 */
	public static void loadPropertiesFile() {
		try {
			log.info("Loading Test Data Properties File...");
			prop = new Properties();
			File file = new File("src/test/resources/TestData.Properties");

			if (!file.exists()) {
				log.error("❌ Properties file not found: " + file.getAbsolutePath());
				throw new RuntimeException("Properties file not found.");
			}

			try (FileReader reader = new FileReader(file)) {
				prop.load(reader);
			}

			// Get environment, defaulting to PROD if missing
			strEnv = prop.getProperty("strEnv", "PROD").toUpperCase();

			// Fetch properties with validation
			strUrlProd = prop.getProperty("strUrlProd", "");
			strUsernameProd = prop.getProperty("strUsernameProd", "");
			strPasswordProd = prop.getProperty("strPasswordProd", "");

			strUrlDev = prop.getProperty("strUrlDev", "");
			strUsernameDev = prop.getProperty("strUsernameDev", "");
			strPasswordDev = prop.getProperty("strPasswordDev", "");

			strUrlProdStaging = prop.getProperty("strUrlProdStaging", "");
			strUsernameProdStaging = prop.getProperty("strUsernameProdStaging", "");
			strPasswordProdStaging = prop.getProperty("strPasswordProdStaging", "");

			// Assign the correct environment values
			switch (strEnv) {
			case "PROD":
				strUrl = strUrlProd;
				strUsername = strUsernameProd;
				strPassword = strPasswordProd;
				break;
			case "PROD_STAGING":
				strUrl = strUrlProdStaging;
				strUsername = strUsernameProdStaging;
				strPassword = strPasswordProdStaging;
				break;
			case "DEV":
				strUrl = strUrlDev;
				strUsername = strUsernameDev;
				strPassword = strPasswordDev;
				break;
			default:
				String errorMsg = "❌ Incorrect Environment! Please specify a correct environment & try again.";
				log.error(errorMsg);
				throw new IllegalArgumentException(errorMsg);
			}
		} catch (IOException e) {
			log.error("❌ Error loading properties file: " + e.getMessage(), e);
			throw new RuntimeException("Failed to load properties file.", e);
		}
	}

	/**
	 * This is a Generic Method For Logging Passed Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param passReportMessage
	 */
	public static void logPassStepInExtentReport(String passReportMessage) {
		ExtentTest test = ExtentReportManager.getCurrentTest(); // ✅ Fetch the current ExtentTest instance
		if (test == null) {
			throw new RuntimeException("❌ Cannot log test step: No active ExtentTest found.");
		}
		test.log(LogStatus.PASS, passReportMessage); // ✅ Use the correct ExtentTest instance
		System.out.println("\n**************************************************");
		System.out.println(passReportMessage);
		System.out.println("**************************************************\n");
	}


	/**
	 * This is a Generic Method For Logging Passed Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param reportMessage
	 */
	public static void logPassStepInExtentReportWithScreenshot(String reportMessage) {
		ExtentTest extReport = ExtentReportManager.getCurrentTest();

		if (extReport != null) {
			extReport.log(LogStatus.PASS, reportMessage);
			WebDriver driver = tdriver.get(); // Assuming you have a thread-local WebDriver
			if (driver != null) {
				String screenshotPath = ExtentReportManager.captureScreenshot(driver);
				if (screenshotPath != null) {
					extReport.log(LogStatus.PASS, extReport.addScreenCapture(screenshotPath));
				}
			}
			System.out.println("\n**************************************************");
			System.out.println(reportMessage);
			System.out.println("**************************************************\n");
		} else {
			System.err.println("❌ No active ExtentTest found for logging.");
		}
	}


	/**
	 * This is a Generic Method For Logging Failed Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param reportMessage
	 */
	public static void logFailStepInExtentReport(String reportMessage) {
		ExtentTest extReport = ExtentReportManager.getCurrentTest();

		if (extReport != null) {
			extReport.log(LogStatus.FAIL, reportMessage);
			WebDriver driver = tdriver.get(); // Get WebDriver from thread-local storage

			if (driver != null) {
				String screenshotPath = ExtentReportManager.captureScreenshot(driver);
				if (screenshotPath != null) {
					extReport.log(LogStatus.FAIL, extReport.addScreenCapture(screenshotPath));
				}
			}
			System.err.println("\n**************************************************");
			System.err.println(reportMessage);
			System.err.println("**************************************************\n");
		} else {
			System.err.println("❌ No active ExtentTest found for logging failure.");
		}
	}


	/**
	 * This is a Generic Method For Logging Info Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param reportMessage
	 */
	public static void logInfoStepInExtentReport(String reportMessage) {
		ExtentTest test = ExtentReportManager.getCurrentTest(); // ✅ Fetch the active ExtentTest instance
		if (test == null) {
			throw new RuntimeException("❌ Cannot log test step: No active ExtentTest found.");
		}
		test.log(LogStatus.INFO, reportMessage); // ✅ Use the correct ExtentTest instance
		System.out.println("\n**************************************************");
		System.out.println(reportMessage);
		System.out.println("**************************************************\n");
	}


	/**
	 * This is a Generic Method For Logging Console Message (System.err.println)
	 * 
	 * @author Mohammed_Mudassir
	 * @param consoleOutputMessage
	 */
	public static void logConsoleOutputMessage(String consoleOutputMessage) {
		// ✅ Log to the console
		System.out.println("\n**************************************************");
		System.out.println(consoleOutputMessage);
		System.out.println("**************************************************\n");
		// ✅ Log to Extent Reports (if available)
		ExtentTest test = ExtentReportManager.getCurrentTest();
		if (test != null) {
			test.log(LogStatus.INFO, consoleOutputMessage);
		}
	}


	/**
	 * This is a Generic Method to Verify Web Element's Presence With Log In Extent
	 * Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void verifyIfElementIsPresent(String xpath) throws Exception {
		if (isWebElementDisplayed(xpath)) {
			logPassStepInExtentReportWithScreenshot("{" + xpath
					+ "} ==> [Expected : This locator must be present] :: [Actual : This locator is present]");
		} else {
			logFailStepInExtentReport("{" + xpath
					+ "} ==> [Expected : This locator must be present] :: [Actual : This locator is not present]");
		}
	}

	/**
	 * This is a Generic Method to Verify if Web Element Is Not Present With Log In
	 * Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void verifyIfElementIsNotPresent(String xpath) throws Exception {
		if (!isWebElementDisplayed(xpath)) {
			logPassStepInExtentReportWithScreenshot("{" + xpath
					+ "} ==> [Expected : This locator must not be present] :: [Actual : This locator is not present]");
		} else {
			logFailStepInExtentReport("{" + xpath
					+ "} ==> [Expected : This locator must not be present] :: [Actual : This locator is present]");
		}
	}

	/**
	 * This is a Generic Method to Verify List Of Web Element's Presence With Log In
	 * Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpathsArray
	 * @throws Exception
	 */
	public static void verifyIfListOfElementsArePresent(String[] xpathsArray) throws Exception {
		for (String xpath : xpathsArray) {
			if (isWebElementDisplayed(xpath)) {
				logPassStepInExtentReport("{" + xpath
						+ "} ==> [Expected : This locator must be present] :: [Actual : This locator is present]");
			} else {
				logFailStepInExtentReport("{" + xpath
						+ "} ==> [Expected : This locator must be present] :: [Actual : This locator is not present]");
			}
		}
	}

	/**
	 * This is a Generic Method to Verify if List Of Web Elements Are Not Present
	 * With Log In Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpathsArray
	 * @throws Exception
	 */
	public static void verifyIfListOfElementsAreNotPresent(String[] xpathsArray) throws Exception {
		for (String xpath : xpathsArray) {
			if (!isWebElementDisplayed(xpath)) {
				logPassStepInExtentReport("{" + xpath
						+ "} ==> [Expected : This locator must not be present] :: [Actual : This locator is not present]");
			} else {
				logFailStepInExtentReport("{" + xpath
						+ "} ==> [Expected : This locator must not be present] :: [Actual : This locator is present]");
			}
		}
	}

	/**
	 * This method refreshes the web page
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void refreshWebPage() {
		explicitWaitInSeconds(1);
		try {
			WebDriver driver = tdriver.get(); // Fetch thread-local WebDriver
			if (driver != null) {
				driver.navigate().refresh();
			} else {
				throw new RuntimeException("❌ WebDriver instance is null! Cannot refresh the page.");
			}
		} catch (Exception e) {
			log.error("❌ Error refreshing the page: " + e.getMessage(), e);
		}
		explicitWaitInSeconds(3);
	}

	/**
	 * This method fetches the title of the web application
	 * 
	 * @author Mohammed_Mudassir
	 * @return
	 */
	public static String getTitleFromUI() {
		String title = "";
		try {
			WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
			if (driver != null) {
				title = driver.getTitle();
			} else {
				throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch the title.");
			}
		} catch (Exception e) {
			log.error("❌ Error getting page title: " + e.getMessage(), e);
		}
		return title;
	}


	/**
	 * This method returns true if the actual title fetched from the web application
	 * is same as expected title
	 * 
	 * @author Mohammed_Mudassir
	 * @param expectedTitle
	 * @return
	 */
	public static boolean isTitleValid(String expectedTitle) {
		boolean isTitleValid = false;
		try {
			String actualTitle = getTitleFromUI();
			logConsoleOutputMessage("actualTitle: " + actualTitle);
			logConsoleOutputMessage("expectedTitle: " + expectedTitle);
			if (actualTitle.toLowerCase().contains(expectedTitle)) {
				isTitleValid = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isTitleValid;
	}

	/**
	 * This method gets timeout details from config file.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void numberOfAttemptsToFindWebElements() {
		try {
			numOfAttemptsToFindWebElement = Integer.parseInt(prop.getProperty("numOfAttemptsToFindWebElement"));
		} catch (Exception e) {
			numOfAttemptsToFindWebElement = 30;
		}
		System.out.println("numOfAttemptsToFindWebElement: " + numOfAttemptsToFindWebElement);
	}

	/**
	 * This is a Generic Method which Scroll to the element.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void scrollToElement(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot perform scroll action.");
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", uiElement(xpath));
	}


	/**
	 * This is a generic method for web element mouse hover operations without any
	 * exceptions. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static WebElement waitForElementForMouseHoverOps(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot locate element.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < 3) {
				try {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					WebElement element = driver.findElement(By.xpath(xpath));
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

					if (element.isDisplayed()) {
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(100); // Small wait before retrying
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					WebElement element = driver.findElement(By.xpath(xpath));
					if (element.isDisplayed() && element.isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Element Having Xpath: " + xpath, e);
					throw new Exception("Unable to locate Web Element Having Xpath: " + xpath);
				}
			}
			count++;
		}

		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * This is a generic method for web element operations without any exceptions.
	 * This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */

	public static WebElement uiElement(String xpath) throws Exception {
	    WebDriver driver = tdriver.get(); // ✅ Get WebDriver instance
	    if (driver == null) {
	        throw new RuntimeException("❌ WebDriver instance is null! Cannot locate element.");
	    }

	    int maxAttempts = 3; // ✅ Define retry limit
	    int attempt = 0;
	    WebElement element = null;

	    while (attempt < maxAttempts) {
	        try {
	            explicitWaitInMilliSeconds(500);

	            // ✅ Wait for the element to be present
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	            // ✅ Scroll element into view
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

	            // ✅ Highlight the element (Temporary)
	            jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);

	            if (element.isDisplayed() && element.isEnabled()) {
	                return element; // ✅ Return once found
	            }

	        } catch (Exception e) {
	            explicitWaitInMilliSeconds(500); // ✅ Small wait before retry
	        }
	        attempt++;
	    }

	    // ❌ If element is not found after retries, log and throw an exception
	    System.out.println("❌ Unable to locate Web Element after " + maxAttempts + " attempts: " + xpath);
	    throw new NoSuchElementException("Element not found: " + xpath);
	}


	/**
	 * This is a generic method for web element operations without any exceptions.
	 * This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static WebElement uiElementWithoutScrolling(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot locate element.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					WebElement element = driver.findElement(By.xpath(xpath));

					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					if (element.isDisplayed() && element.isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500); // Retry after a small wait
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					WebElement element = driver.findElement(By.xpath(xpath));
					if (element.isDisplayed() && element.isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Element Having Xpath: " + xpath, e);
					throw new Exception("Unable to locate Web Element Having Xpath: " + xpath);
				}
			}
			count++;
		}

		return driver.findElement(By.xpath(xpath));
	}

	/**
	 * This is a generic method for web element operations without any exceptions.
	 * This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static WebElement uiElement(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot locate element.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					WebElement element = driver.findElement(byLocator);

					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

					if (element.isDisplayed() && element.isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500); // Retry after a small wait
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					WebElement element = driver.findElement(byLocator);
					if (element.isDisplayed() && element.isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Element: " + byLocator, e);
					throw new Exception("Unable to locate Web Element: " + byLocator);
				}
			}
			count++;
		}

		return driver.findElement(byLocator);
	}


	/**
	 * This is a generic method for web element operations without any exceptions.
	 * This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static WebElement uiElement(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot interact with the element.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);

					if (webElement.isDisplayed() && webElement.isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500); // Retry after a small wait
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (webElement.isDisplayed() && webElement.isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Element: " + webElement, e);
					throw new Exception("Unable to locate Web Element: " + webElement);
				}
			}
			count++;
		}

		return webElement;
	}

	/**
	 * This is a generic method for list of web elements operations without any
	 * exceptions. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static List<WebElement> uiElements(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot locate elements.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					List<WebElement> elements = driver.findElements(By.xpath(xpath));

					if (!elements.isEmpty() && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elements.get(0));
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", elements.get(0));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500); // Retry after a small wait
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Elements");
				flag = false;
				try {
					List<WebElement> elements = driver.findElements(By.xpath(xpath));
					if (!elements.isEmpty() && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
						System.out.println("Able to locate Web Elements after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Elements Having Xpath: " + xpath, e);
					throw new Exception("Unable to locate Web Elements Having Xpath: " + xpath);
				}
			}
			count++;
		}

		return driver.findElements(By.xpath(xpath));
	}

	/**
	 * This is a generic method for list of web elements operations without any
	 * exceptions. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static List<WebElement> uiElements(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot locate elements.");
		}

		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					List<WebElement> elements = driver.findElements(byLocator);

					if (!elements.isEmpty() && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].scrollIntoView(true);", elements.get(0));
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", elements.get(0));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500); // Retry after a small wait
				}
			} else {
				System.out.println(count + " Attempts Over");
				System.out.println("Unable to locate Web Elements");
				flag = false;
				try {
					List<WebElement> elements = driver.findElements(byLocator);
					if (!elements.isEmpty() && elements.get(0).isDisplayed() && elements.get(0).isEnabled()) {
						System.out.println("Able to locate Web Elements after " + count + " attempts");
					}
				} catch (Exception e) {
					log.error("❌ Unable to locate Web Elements Using Locator: " + byLocator, e);
					throw new Exception("Unable to locate Web Elements Using Locator: " + byLocator);
				}
			}
			count++;
		}

		return driver.findElements(byLocator);
	}

	/**
	 * This generic method waits until a web element gets displayed. This Method
	 * accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayed(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}

		boolean isElementPresent = false;
		boolean flag = true;
		int count = 1;

		logConsoleOutputMessage("Checking element with XPath: " + xpath);

		while (flag) {
			if (count < 2) {
				try {
					explicitWaitInMilliSeconds(250);
					WebElement element = driver.findElement(By.xpath(xpath));

					if (element.isDisplayed()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
						isElementPresent = true;
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250); // Retry after a small wait
				}
			} else {
				flag = false;
			}
			count++;
		}
		return isElementPresent;
	}

	/**
	 * This generic method waits until a web element gets displayed. This Method
	 * accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayed(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}

		boolean isElementPresent = false;
		boolean flag = true;
		int count = 1;

		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);
					WebElement element = driver.findElement(byLocator);

					if (element.isDisplayed()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element);
						isElementPresent = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250); // Retry after a small wait
				}
			} else {
				flag = false;
			}
			count++;
		}
		return isElementPresent;
	}

	/**
	 * This generic method waits until a web element gets displayed. This Method
	 * accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayed(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementPresent = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (webElement.isDisplayed()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
						isElementPresent = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250);
				}
			} else {
				flag = false;
			}
			count = count + 1;
		}
		return isElementPresent;
	}

	/**
	 * This generic method waits until a web element gets displayed and enabled.
	 * This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayedAndEnabled(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementPresentAndEnabled = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						isElementPresentAndEnabled = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250);
				}
			} else {
				flag = false;
			}
			count = count + 1;
		}
		return isElementPresentAndEnabled;
	}

	/**
	 * This generic method returns true if a web element gets displayed and
	 * disabled. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayedAndDisabled(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementPresentAndEnabled = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& !driver.findElement(By.xpath(xpath)).isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						isElementPresentAndEnabled = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250);
				}
			} else {
				flag = false;
			}
			count = count + 1;
		}
		return isElementPresentAndEnabled;
	}

	/**
	 * This generic method waits until a web element gets displayed and enabled.
	 * This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayedAndEnabled(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementPresentAndEnabled = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (driver.findElement(byLocator).isDisplayed() && driver.findElement(byLocator).isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(byLocator));
						isElementPresentAndEnabled = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250);
				}
			} else {
				flag = false;
			}
			count = count + 1;
		}
		return isElementPresentAndEnabled;
	}

	/**
	 * This generic method waits until a web element gets displayed and enabled.
	 * This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayedAndEnabled(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementPresentAndEnabled = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (webElement.isDisplayed() && webElement.isEnabled()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);
						isElementPresentAndEnabled = true;
						flag = false;
					} else {
						explicitWaitInMilliSeconds(250);
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(250);
				}
			} else {
				flag = false;
			}
			count = count + 1;
		}
		return isElementPresentAndEnabled;
	}

	/**
	 * This method waits until a web element gets disappeared. This Method accepts
	 * String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisappeared(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementDisappeared = true;
		boolean flag = true;

		explicitWaitInMilliSeconds(5000);

		while (flag) {
			try {
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		if (flag) {
			isElementDisappeared = false;
		}
		return isElementDisappeared;
	}

	/**
	 * This method waits until a web element gets disappeared. This Method accepts
	 * String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static void waitUntilElementGetsDisappeared(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean flag = true;

		logConsoleOutputMessage("xpath: " + xpath);

		while (flag) {
			try {
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					flag = true;
					logConsoleOutputMessage(xpath + " Element is still visible");
				} else {
					flag = false;
					logConsoleOutputMessage(xpath + " Element is Now Disappeared");
				}
			} catch (Exception e) {
				flag = false;
				logConsoleOutputMessage(xpath + " Element is Now Disappeared");
			}
		}
	}

	/**
	 * This method waits until a web element gets disappeared. This Method accepts
	 * String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static void waitUntilElementGetsAppeared(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean flag = true;

		explicitWaitInSeconds(2);
		logConsoleOutputMessage("xpath: " + xpath);

		while (flag) {
			try {
				if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
					flag = false;
					logConsoleOutputMessage(xpath + " Element is now visible");
				} else {
					flag = true;
					logConsoleOutputMessage(xpath + " Element is not visible yet");
				}
			} catch (Exception e) {
				flag = true;
				logConsoleOutputMessage(xpath + " Element is not visible yet");
			}
		}
	}

	/**
	 * This method waits until a web element gets disappeared. This Method accepts
	 * By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisappeared(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementDisappeared = true;
		boolean flag = true;

		explicitWaitInMilliSeconds(5000);

		while (flag) {
			try {
				if (driver.findElement(byLocator).isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		if (flag) {
			isElementDisappeared = false;
		}
		return isElementDisappeared;
	}

	/**
	 * This method waits until a web element gets disappeared. This Method accepts
	 * WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisappeared(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isElementDisappeared = true;
		boolean flag = true;

		explicitWaitInMilliSeconds(5000);

		while (flag) {
			try {
				if (webElement.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		if (flag) {
			isElementDisappeared = false;
		}
		return isElementDisappeared;
	}

	/**
	 * This is a generic method for click operations. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void clickWebElement(String xpath) throws Exception {
		explicitWaitInSeconds(1);
		uiElement(xpath).click();
	}

	/**
	 * This is a generic method for click operations. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void clickWebElementWithoutScrolling(String xpath) throws Exception {
		explicitWaitInSeconds(1);
		uiElementWithoutScrolling(xpath).click();
	}

	/**
	 * This is a generic method for click operations. This Method accepts By Locator
	 * as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @throws Exception
	 */
	public static void clickWebElement(By byLocator) throws Exception {
		uiElement(byLocator).click();
	}

	/**
	 * This is a generic method for click operations. This Method accepts WebElement
	 * as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @throws Exception
	 */
	public static void clickWebElement(WebElement webElement) throws Exception {
		uiElement(webElement).click();
	}

	/**
	 * This is a generic method for click operations with JavaScript Executor. This
	 * Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void clickWithJavaScriptExecutor(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uiElement(xpath));
	}

	/**
	 * This is a generic method for click operations with JavaScript Executor. This
	 * Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @throws Exception
	 */
	public static void clickWithJavaScriptExecutor(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uiElement(byLocator));
	}

	/**
	 * This is a generic method for click operations with JavaScript Executor. This
	 * Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @throws Exception
	 */
	public static void clickWithJavaScriptExecutor(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uiElement(webElement));
	}

	/**
	 * This is a generic method to click a WebElement using Action Class
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @throws Exception
	 */
	public static void clickUsingActionClass(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (isWebElementDisplayed(webElement)) {
			Actions actions = new Actions(driver);
			actions.click(uiElement(webElement)).build().perform();
		}
	}

	/**
	 * This is a generic method to click a WebElement using Action Class
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void clickUsingActionClass(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (isWebElementDisplayed(xpath)) {
			Actions actions = new Actions(driver);
			actions.click(uiElement(xpath)).build().perform();
		}
	}

	/**
	 * This is a generic method to click a WebElement using Action Class
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void doubleClickUsingActionClass(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		Actions actions = new Actions(driver);
		actions.doubleClick(uiElement(xpath)).build().perform();
	}

	/**
	 * This is a generic method to click a WebElement using Action Class
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void doubleClickUsingActionClassWithoutScrolling(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		Actions actions = new Actions(driver);
		actions.doubleClick(uiElementWithoutScrolling(xpath)).build().perform();
	}

	/**
	 * This is a generic method to mouse hover. This Method accepts String (Xpath)
	 * as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void mouseHoverUsingActionClass(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (isWebElementDisplayed(xpath)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(waitForElementForMouseHoverOps(xpath)).build().perform();
		}
	}

	/**
	 * This is a generic method to mouse hover and click. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void mouseHoverAndClickUsingActionClass(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (isWebElementDisplayed(xpath)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(waitForElementForMouseHoverOps(xpath)).click().build().perform();
		}
	}

	/**
	 * This is a generic method to mouse hover and click on 2nd element. This Method
	 * accepts two String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath1
	 * @param xpath2
	 * @throws Exception
	 */
	public static void mouseHoverElementAndClickSecondElementUsingActionClass(String xpath1, String xpath2)
			throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (isWebElementDisplayed(xpath1)) {
			Actions actions = new Actions(driver);
			actions.moveToElement(waitForElementForMouseHoverOps(xpath1))
			.moveToElement(waitForElementForMouseHoverOps(xpath2)).click().build().perform();
		}
	}

	/**
	 * This is a generic method to mouse hover and click on 3rd element. This Method
	 * accepts three String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath1
	 * @param xpath2
	 * @param xpath3
	 * @throws Exception
	 */
	public static void mouseHoverElementAndClickThirdElementUsingActionClass(String xpath1, String xpath2,
			String xpath3) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		Actions actions = new Actions(driver);
		actions.moveToElement(waitForElementForMouseHoverOps(xpath1))
		.moveToElement(waitForElementForMouseHoverOps(xpath2))
		.moveToElement(waitForElementForMouseHoverOps(xpath3)).click().build().perform();
	}

	/**
	 * This is a generic method to Select The Radio-Button Or Check-Box If It Is Not
	 * Selected By Default. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void selectRadioButtonOrCheckBoxIfNotSelectedByDefault(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (!uiElement(xpath).isSelected()) {
			uiElement(xpath).click();
		}
	}

	/**
	 * This is a generic method to Select The Radio-Button Or Check-Box If It Is Not
	 * Selected By Default. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @throws Exception
	 */
	public static void selectRadioButtonOrCheckBoxIfNotSelectedByDefault(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (!uiElement(byLocator).isSelected()) {
			uiElement(byLocator).click();
		}
	}

	/**
	 * This is a generic method to Select The Radio-Button Or Check-Box If It Is Not
	 * Selected By Default. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @throws Exception
	 */
	public static void selectRadioButtonOrCheckBoxIfNotSelectedByDefault(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (!uiElement(webElement).isSelected()) {
			uiElement(webElement).click();
		}
	}

	/**
	 * This is a generic method to DeSelect The Radio-Button Or Check-Box If It Is
	 * Selected By Default. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @throws Exception
	 */
	public static void deselectRadioButtonOrCheckBoxIfSelectedByDefault(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (uiElement(xpath).isSelected()) {
			uiElement(xpath).click();
		}
	}

	/**
	 * This is a generic method to DeSelect The Radio-Button Or Check-Box If It Is
	 * Selected By Default. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @throws Exception
	 */
	public static void deselectRadioButtonOrCheckBoxIfSelectedByDefault(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (uiElement(byLocator).isSelected()) {
			uiElement(byLocator).click();
		}
	}

	/**
	 * This is a generic method to DeSelect The Radio-Button Or Check-Box If It Is
	 * Selected By Default. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @throws Exception
	 */
	public static void deselectRadioButtonOrCheckBoxIfSelectedByDefault(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (uiElement(webElement).isSelected()) {
			uiElement(webElement).click();
		}
	}

	/**
	 * This is a generic method which returns true when a Radio-Button Or Check-Box
	 * is selected. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public static boolean isRadioButtonOrCheckBoxSelected(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isRadioButtonOrCheckBoxSelected = false;
		if (uiElement(xpath).isSelected()) {
			isRadioButtonOrCheckBoxSelected = true;
		}
		return isRadioButtonOrCheckBoxSelected;
	}

	/**
	 * This is a generic method which returns true when a Radio-Button Or Check-Box
	 * is selected. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static boolean isRadioButtonOrCheckBoxSelected(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isRadioButtonOrCheckBoxSelected = false;
		if (uiElement(byLocator).isSelected()) {
			isRadioButtonOrCheckBoxSelected = true;
		}
		return isRadioButtonOrCheckBoxSelected;
	}

	/**
	 * This is a generic method which returns true when a Radio-Button Or Check-Box
	 * is selected. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isRadioButtonOrCheckBoxSelected(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		boolean isRadioButtonOrCheckBoxSelected = false;
		if (uiElement(webElement).isSelected()) {
			isRadioButtonOrCheckBoxSelected = true;
		}
		return isRadioButtonOrCheckBoxSelected;
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextField(String xpath, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				explicitWaitInMilliSeconds(500);
				uiElement(xpath).click();
				uiElement(xpath).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(xpath).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextField(By byLocator, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				explicitWaitInMilliSeconds(500);
				uiElement(byLocator).click();
				uiElement(byLocator).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(byLocator).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextField(WebElement webElement, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				explicitWaitInMilliSeconds(500);
				uiElement(webElement).click();
				uiElement(webElement).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(webElement).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area Using JavaScriptExecutor. This Method accepts String (Xpath) as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextFieldUsingJavaScriptExecuter(String xpath, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				clickWithJavaScriptExecutor(xpath);
				explicitWaitInMilliSeconds(500);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].value='" + textData + "'", xpath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area Using JavaScriptExecutor. This Method accepts By Locator as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextFieldUsingJavaScriptExecuter(By byLocator, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				clickWithJavaScriptExecutor(byLocator);
				explicitWaitInMilliSeconds(500);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].value='" + textData + "'", byLocator);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data In The Text Box Or
	 * Text Area Using JavaScriptExecutor. This Method accepts WebElement as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextInTextFieldUsingJavaScriptExecuter(WebElement webElement, String textData)
			throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				clickWithJavaScriptExecutor(webElement);
				explicitWaitInMilliSeconds(500);
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].value='" + textData + "'", webElement);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndClickEnterInTextField(String xpath, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(xpath).click();
				uiElement(xpath).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(xpath).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
				uiElement(xpath).sendKeys(Keys.ENTER);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndClickEnterInTextField(By byLocator, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(byLocator).click();
				uiElement(byLocator).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(byLocator).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
				uiElement(byLocator).sendKeys(Keys.ENTER);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndClickEnterInTextField(WebElement webElement, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(webElement).click();
				uiElement(webElement).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(webElement).sendKeys(textData);
				explicitWaitInMilliSeconds(500);
				uiElement(webElement).sendKeys(Keys.ENTER);
				explicitWaitInMilliSeconds(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area Using Robot Class. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndRobotClickEnterInTextField(String xpath, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(xpath).click();
				uiElement(xpath).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(xpath).sendKeys(textData);
				explicitWaitInMilliSeconds(500);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area Using Robot Class. This Method accepts By Locator
	 * as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndRobotClickEnterInTextField(By byLocator, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(byLocator).click();
				uiElement(byLocator).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(byLocator).sendKeys(textData);
				explicitWaitInMilliSeconds(500);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method To Clear And Enter The Input Data And Click Enter In
	 * The Text Box Or Text Area Using Robot Class. This Method accepts WebElement
	 * as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static void setTextAndRobotClickEnterInTextField(WebElement webElement, String textData) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		if (textData != null && !textData.isEmpty()) {
			try {
				uiElement(webElement).click();
				uiElement(webElement).clear();
				explicitWaitInMilliSeconds(500);
				uiElement(webElement).sendKeys(textData);
				explicitWaitInMilliSeconds(500);

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			throw new Exception("Data Error!!! - Please Enter Valid Data That Has To Be Entered In The Text Field");
		}
	}

	/**
	 * This is a generic method to Clear The Text Box Or Text Area. This Method
	 * accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static void clearTextInTextBoxOrTextArea(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		try {
			explicitWaitInMilliSeconds(500);
			uiElement(xpath).clear();
			explicitWaitInMilliSeconds(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a generic method to Clear The Text Box Or Text Area. This Method
	 * accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static void clearTextInTextBoxOrTextArea(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		try {
			explicitWaitInMilliSeconds(500);
			uiElement(byLocator).clear();
			explicitWaitInMilliSeconds(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a generic method to Clear The Text Box Or Text Area. This Method
	 * accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static void clearTextInTextBoxOrTextArea(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		try {
			explicitWaitInMilliSeconds(500);
			uiElement(webElement).clear();
			explicitWaitInMilliSeconds(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a generic method To get the text from UI. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @throws Exception
	 */
	public static String getTextFromWeb(String xpath) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		return uiElement(xpath).getText();
	}

	/**
	 * This is a generic method To get the text from UI. This Method accepts By
	 * Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static String getTextFromWeb(By byLocator) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		return uiElement(byLocator).getText();
	}

	/**
	 * This is a generic method To get the text from UI. This Method accepts
	 * WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static String getTextFromWeb(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get(); // Fetch the thread-local WebDriver
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check element visibility.");
		}
		return uiElement(webElement).getText();
	}

	/**
	 * This is a generic method To get any attribute value from UI. This Method
	 * accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param textData
	 * @param attribute
	 * @throws Exception
	 */
	public static String getAnyAttributeFromWeb(String xpath, String attribute) throws Exception {
		WebElement element = uiElement(xpath);

		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", element, attribute);
	}


	/**
	 * This is a generic method To get any attribute value from UI. This Method
	 * accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param textData
	 * @throws Exception
	 */
	public static String getAnyAttributeFromWeb(By byLocator, String attribute) throws Exception {
		WebElement element = uiElement(byLocator);

		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", element, attribute);
	}

	/**
	 * This is a generic method To get any attribute value from UI. This Method
	 * accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param textData
	 * @throws Exception
	 */
	public static String getAnyAttributeFromWeb(WebElement webElement, String attribute) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", webElement, attribute);
	}


	/**
	 * This is generic method for select box. This Method accepts String (Xpath) as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return Select
	 * @throws Exception
	 */
	public static Select selectDropDownElement(String xpath) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Select select = new Select(uiElement(xpath));
		return select;
	}

	/**
	 * This is generic method for selecting a dropdown option having partial visible
	 * text from a Select Dropdown. This Method accepts two String (Xpath) as
	 * parameters.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param optionWithPartialVisibleText
	 * @throws Exception
	 */
	public static void selectDropdownOptionByPartialVisibleText(String xpath, String optionWithPartialVisibleText)
			throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		List<WebElement> options = uiElements(xpath + "/option");
		logConsoleOutputMessage("Dropdown Options: " + options);
		logConsoleOutputMessage(
				"Partial Visible Text Of Dropdown Option To Be Selected: " + optionWithPartialVisibleText);

		for (WebElement option : options) {
			if (option.getText().toUpperCase().contains(optionWithPartialVisibleText.toUpperCase())) {
				logConsoleOutputMessage("Dropdown Option To Be Selected: " + getTextFromWeb(option));
				// clickWithJavaScriptExecutor(option);
				// clickWebElement(option);
				clickUsingActionClass(option);
				break;
			}
		}
	}

	/**
	 * This is generic method for select box. This Method accepts By Locator as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return Select
	 * @throws Exception
	 */
	public static Select selectDropDownElement(By byLocator) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Select select = new Select(uiElement(byLocator));
		return select;
	}

	/**
	 * This is generic method for select box. This Method accepts WebElement as
	 * parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return Select
	 * @throws Exception
	 */
	public static Select selectDropDownElement(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Select select = new Select(uiElement(webElement));
		return select;
	}

	/**
	 * This is a generic method which returns true if the expected option is present
	 * in a select box. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param option
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isExpectedOptionPresentInSelectBox(String xpath, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check dropdown options.");
		}

		boolean isSelectBoxOptionPresent = false;
		Select selectElement = selectDropDownElement(xpath); // Fetch Select element once
		List<WebElement> optionsList = selectElement.getOptions(); // Store options list once

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement optionElement : optionsList) {
			// Fetch attributes dynamically using JavaScript
			String currentOptionValue = (String) js.executeScript("return arguments[0].getAttribute('value');", optionElement);
			String currentOptionText = (String) js.executeScript("return arguments[0].textContent;", optionElement); // Fetch inner text

			if ((currentOptionValue != null && currentOptionValue.equalsIgnoreCase(option))
					|| (currentOptionText != null && currentOptionText.equalsIgnoreCase(option))) {
				isSelectBoxOptionPresent = true;
				break;
			}
		}

		return isSelectBoxOptionPresent;
	}


	/**
	 * This is a generic method which returns true if the expected option is present
	 * in a select box. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param option
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isExpectedOptionPresentInSelectBox(By byLocator, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check dropdown options.");
		}

		boolean isSelectBoxOptionPresent = false;
		Select selectElement = selectDropDownElement(byLocator); // Fetch the Select element once
		List<WebElement> optionsList = selectElement.getOptions(); // Store options list once

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement optionElement : optionsList) {
			// Fetch attributes dynamically using JavaScript
			String currentOptionValue = (String) js.executeScript("return arguments[0].getAttribute('value');", optionElement);
			String currentOptionText = (String) js.executeScript("return arguments[0].textContent;", optionElement); // Fetch inner text

			if ((currentOptionValue != null && currentOptionValue.equalsIgnoreCase(option))
					|| (currentOptionText != null && currentOptionText.equalsIgnoreCase(option))) {
				isSelectBoxOptionPresent = true;
				break;
			}
		}

		return isSelectBoxOptionPresent;
	}


	/**
	 * This is a generic method which returns true if the expected option is present
	 * in a select box. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param option
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean isExpectedOptionPresentInSelectBox(WebElement webElement, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot check dropdown options.");
		}

		boolean isSelectBoxOptionPresent = false;
		Select selectElement = new Select(webElement); // Create Select instance once
		List<WebElement> optionsList = selectElement.getOptions(); // Store options list once

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (WebElement optionElement : optionsList) {
			// Fetch attributes dynamically using JavaScript
			String currentOptionValue = (String) js.executeScript("return arguments[0].getAttribute('value');", optionElement);
			String currentOptionText = (String) js.executeScript("return arguments[0].textContent;", optionElement); // Fetch inner text

			if ((currentOptionValue != null && currentOptionValue.equalsIgnoreCase(option))
					|| (currentOptionText != null && currentOptionText.equalsIgnoreCase(option))) {
				isSelectBoxOptionPresent = true;
				break;
			}
		}

		return isSelectBoxOptionPresent;
	}

	/**
	 * This is generic method to get value of default selected option from select
	 * box. This Method accepts String (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @return String
	 * @throws Exception
	 */
	public static String getDefaultSelectedValueFromSelectBox(String xpath) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		return selectDropDownElement(xpath).getFirstSelectedOption().getText();
	}

	/**
	 * This is generic method to get value of default selected option from select
	 * box. This Method accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return String
	 * @throws Exception
	 */
	public static String getDefaultSelectedValueFromSelectBox(By byLocator) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		return selectDropDownElement(byLocator).getFirstSelectedOption().getText();
	}

	/**
	 * This is generic method to get value of default selected option from select
	 * box. This Method accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return String
	 * @throws Exception
	 */
	public static String getDefaultSelectedValueFromSelectBox(WebElement webElement) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		return selectDropDownElement(webElement).getFirstSelectedOption().getText();
	}

	/**
	 * This is generic method for mandatory select boxes. This Method accepts String
	 * (Xpath) as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param xpath
	 * @param option
	 * @throws Exception
	 */
	public static void mandatorySelectBox(String xpath, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot interact with the dropdown.");
		}

		Select select = selectDropDownElement(xpath); // Fetch the Select element once
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (option != null && !option.isEmpty()) {
			try {
				select.selectByVisibleText(option);
			} catch (Exception e) {
				select.selectByIndex(1);
			}
		} else {
			select.selectByIndex(0);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String selectedText = (String) js.executeScript("return arguments[0].textContent;", firstSelectedOption);

			if (selectedText.contains("Select")) {
				select.selectByIndex(1);
			}
		}
	}

	/**
	 * This is generic method for mandatory select boxes. This Method accepts By
	 * Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @param option
	 * @throws Exception
	 */
	public static void mandatorySelectBox(By byLocator, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot interact with the dropdown.");
		}

		Select select = selectDropDownElement(byLocator); // Fetch the Select element once
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (option != null && !option.isEmpty()) {
			try {
				select.selectByVisibleText(option);
			} catch (Exception e) {
				select.selectByIndex(1);
			}
		} else {
			select.selectByIndex(0);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String selectedText = (String) js.executeScript("return arguments[0].textContent;", firstSelectedOption);

			if (selectedText.contains("Select")) {
				select.selectByIndex(1);
			}
		}
	}

	/**
	 * This is generic method for mandatory select boxes. This Method accepts
	 * WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @param option
	 * @throws Exception
	 */
	public static void mandatorySelectBox(WebElement webElement, String option) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot interact with the dropdown.");
		}

		Select select = new Select(webElement); // Fetch the Select element once
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (option != null && !option.isEmpty()) {
			try {
				select.selectByVisibleText(option);
			} catch (Exception e) {
				select.selectByIndex(1);
			}
		} else {
			select.selectByIndex(0);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			String selectedText = (String) js.executeScript("return arguments[0].textContent;", firstSelectedOption);

			if (selectedText.contains("Select")) {
				select.selectByIndex(1);
			}
		}
	}


	/**
	 * This is generic method to get random dropdown option by visible text
	 * 
	 * @author Mohammed_Mudassir
	 * @param selectBoxDropdownXpath
	 * @return String
	 * @throws Exception
	 */
	public static String getRandomOptionTextFromDropdown(String selectBoxDropdownXpath) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		String randomOptionText = "";
		try {
			int optionsSize = selectDropDownElement(selectBoxDropdownXpath).getOptions().size();
			logConsoleOutputMessage("optionsSize: " + optionsSize);

			int randomOptionIndex = getRandomNumberFromZeroToSpecificNumber(optionsSize);
			logConsoleOutputMessage("randomOptionIndex: " + randomOptionIndex);

			randomOptionText = selectDropDownElement(selectBoxDropdownXpath).getOptions().get(randomOptionIndex)
					.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomOptionText;
	}

	/**
	 * This is generic method to select random dropdown option by visible text
	 * 
	 * @author Mohammed_Mudassir
	 * @param selectBoxDropdownXpath
	 * @throws Exception
	 */
	public static void selectRandomOptionByVisibleTextFromDropdown(String selectBoxDropdownXpath) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			String randomOptionVisibleText = getRandomOptionTextFromDropdown(selectBoxDropdownXpath);
			logConsoleOutputMessage("randomOptionVisibleText: " + randomOptionVisibleText);
			selectDropDownElement(selectBoxDropdownXpath).selectByVisibleText(randomOptionVisibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is generic method for handling browser windows. This Method accepts
	 * String as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param title
	 */
	public static void swithToWindowBasedOnTitle(String title) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		boolean flag = true;
		while (flag) {
			try {
				Set<String> handles = driver.getWindowHandles();
				for (String handle : handles) {
					driver.switchTo().window(handle);
					if (driver.getTitle().contains(title)) {
						flag = false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This is generic method for switching to new window. This Method accepts
	 * String as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void swithToNextNewWindow() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();
			while (iterator.hasNext()) {
				driver.switchTo().window(iterator.next());
				driver.manage().window().maximize();
				System.out.println("Switched to next window");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This generic method returns true if an alert is present.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static boolean isAlertPresent() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			explicitWaitInSeconds(3);
			driver.switchTo().alert();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}

	/**
	 * This is generic method for accepting multiple alerts if present.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void acceptMultipleAlertsIfPresent() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			int count = 1;
			while (isAlertPresent()) {
				logConsoleOutputMessage("Alert Count Number: " + count);
				driver.switchTo().alert().accept();
				explicitWaitInSeconds(3);
				count = count + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is generic method for accepting a single alert if present.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static void acceptSingleAlertIfPresent() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
				explicitWaitInSeconds(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is generic method for getting text from alerts if present.
	 * 
	 * @author Mohammed_Mudassir
	 */
	public static String getTextFromAlert() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		String textFromAlert = "";
		try {

			if (isAlertPresent()) {
				textFromAlert = driver.switchTo().alert().getText();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return textFromAlert;
	}

	/**
	 * This is generic method for Scrolling Using JavaScript Executor. This Method
	 * accepts two integers as parameters.
	 * 
	 * @author Mohammed_Mudassir
	 * @param horizontal
	 * @param vertical
	 */
	public static void scrollWithJavaScriptExecutor(int horizontal, int vertical) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")");
	}

	/**
	 * Generic Method To Extract Required Data From A String Using Regular
	 * Expression. This Method accepts two Strings as parameters.
	 * 
	 * @author Mohammed_Mudassir
	 * @param regexExpression
	 * @param inputTextData
	 * @return String
	 */
	public static String getTextUsingRegex(String regexExpression, String inputTextData) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		String extractedContent = "";
		Matcher m = Pattern.compile(regexExpression).matcher(inputTextData);
		while (m.find()) {
			extractedContent = m.group(1);
		}
		return extractedContent;
	}

	/**
	 * Generic Method To Get Current Date In Any Format. This Method accepts String
	 * as parameter. Sample Date Formats {dd/MM/yyyy or dd/MMM/yyyy or MM/dd/yyyy or
	 * yyyy/MM/dd or MMM dd, yyyy} and so on...
	 * 
	 * @author Mohammed_Mudassir
	 * @return String
	 */
	public static String getCurrentDate(String dateFormat) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		String strDate = formatter.format(date);
		return strDate;
	}

	public static String convertDateFromCurrentFormatToAnyFormat(String sourceDate, String sourceDateFormat,
			String targetDateFormat) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		String targetDate = "";

		try {
			DateFormat srcDf = new SimpleDateFormat(sourceDateFormat);

			// parse the date string into Date object
			Date date = srcDf.parse(sourceDate);

			DateFormat destDf = new SimpleDateFormat(targetDateFormat);

			// format the date into another format
			targetDate = destDf.format(date);

			logConsoleOutputMessage("sourceDate: " + sourceDate);
			logConsoleOutputMessage("targetDate : " + targetDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return targetDate;
	}

	/**
	 * This Method Is To Give Explicit Timeout In Seconds. This Method accepts
	 * integer as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param seconds
	 */
	public static void explicitWaitInSeconds(int seconds) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		seconds = seconds * 1000;
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e1) {
		}
	}

	/**
	 * This Method Is To Give Explicit Timeout In Seconds. This Method accepts
	 * integer as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param milliSeconds
	 */
	public static void explicitWaitInMilliSeconds(int milliSeconds) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e1) {
		}
	}

	/**
	 * This method is used for uploading files using Robot Class. This Method
	 * accepts two Strings as parameters.
	 * 
	 * @param fullFilePath
	 * @param fileNameWithExtension
	 * @throws Exception
	 */
	public static void uploadFileUsingRobotClass(String fullFilePath, String fileNameWithExtension) throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		// String filepath = projectDrectory + "\\files\\";
		System.out.println("filepath: " + fullFilePath);
		// creating object of Robot class
		Robot rb = new Robot();

		// copying File path to Clipboard
		StringSelection str = new StringSelection(fullFilePath + fileNameWithExtension);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This method is used for pressing enter using Robot Class
	 * 
	 * @author Mohammed_Mudassir
	 * @throws Exception
	 */
	public static void pressEnterKeyUsingRobotClass() throws Exception {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * This a generic method which returns 5 digit Random Number In String Format
	 * 
	 * @author Mohammed_Mudassir
	 * @return String
	 */
	public static String getFiveDigitRandomNumberString() {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Random rnd = new Random();
		int number = rnd.nextInt(99999);
		return String.valueOf(number);
	}

	/**
	 * This a generic method which returns 5 digit Random Number In String Format
	 * 
	 * @author Mohammed_Mudassir
	 * @return int
	 */
	public static int getRandomNumberFromZeroToSpecificNumber(int number) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Random r = new Random();
		return r.nextInt((number - 0) + 1) + 0;
	}

	/**
	 * This a generic method which returns 5 digit Random Number In String Format
	 * 
	 * @author Niyaz
	 * @return int
	 */
	public static int getRandomNumberWithinRange(int lowerBoundNumber, int higherBoundNumber) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		Random r = new Random();
		return r.nextInt((higherBoundNumber - lowerBoundNumber) + 1) + lowerBoundNumber;
	}

	/**
	 * This a generic method which returns Random String Element From An Array Of
	 * String Elements
	 * 
	 * @author Mohammed_Mudassir
	 * @param arrayOfItems
	 * @return
	 */
	public String getRandomElementFromArrayOfItems(String[] arrayOfItems) {
		WebDriver driver = tdriver.get();
		if (driver == null) {
			throw new RuntimeException("❌ WebDriver instance is null! Cannot fetch attribute.");
		}
		String randomElement = "";
		try {
			List<String> myList = Arrays.asList(arrayOfItems);

			Random r = new Random();
			int randomitem = r.nextInt(myList.size());
			randomElement = myList.get(randomitem);
			logConsoleOutputMessage("randomElement: " + randomElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomElement;
	}
	
	// ✅ Method to highlight element with flashing effect
    public void flashElement(WebElement element) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 3; i++) {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            try {
                Thread.sleep(200); // ✅ Pause to make the highlight visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            js.executeScript("arguments[0].style.border=''", element);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
