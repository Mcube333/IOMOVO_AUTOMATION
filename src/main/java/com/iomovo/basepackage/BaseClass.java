package com.iomovo.basepackage;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.utilspackage.ExtentReportsClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	public static ExtentReportsClass extentReportsClass = new ExtentReportsClass();
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static ExtentTest extReport;
	public static Properties prop;
	public static int numOfAttemptsToFindWebElement;
	public static String projectDirectory = System.getProperty("user.dir");

	// All Variables which fetches data from config.properties file
	public static String strUrl = "";
	public static String strUsername = "";
	public static String strPassword = "";
	
	public static String strEnv = "";
	
	public static String strUrlOci = "";
	public static String strUsernameOci = "";
	public static String strPasswordOci = "";
	
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
	 * This is a Generic Method For Logging Passed Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param passReportMessage
	 */
	public static void logPassStepInExtentReport(String passReportMessage) {
		extReport.log(LogStatus.PASS, passReportMessage);
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
		extReport.log(LogStatus.PASS, reportMessage);
		extReport.log(LogStatus.PASS, extReport.addScreenCapture(extentReportsClass.capture(driver)));
		System.out.println("\n**************************************************");
		System.out.println(reportMessage);
		System.out.println("**************************************************\n");
	}

	/**
	 * This is a Generic Method For Logging Failed Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param reportMessage
	 */
	public static void logFailStepInExtentReport(String reportMessage) {
		extReport.log(LogStatus.FAIL, reportMessage);
		extReport.log(LogStatus.FAIL, extReport.addScreenCapture(extentReportsClass.capture(driver)));
		System.err.println("\n**************************************************");
		System.err.println(reportMessage);
		System.err.println("**************************************************\n");
	}

	/**
	 * This is a Generic Method For Logging Info Step In The Extent Report
	 * 
	 * @author Mohammed_Mudassir
	 * @param reportMessage
	 */
	public static void logInfoStepInExtentReport(String reportMessage) {
		extReport.log(LogStatus.INFO, reportMessage);
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
		System.out.println("\n**************************************************");
		System.out.println(consoleOutputMessage);
		System.out.println("**************************************************\n");
	}

	/**
	 * This method initializes and loads the property files
	 * 
	 * @author Mohammed_Mudassir
	 * @return
	 */
	public static void loadPropertiesFile() {
		try {
			System.out.println("********** Loading The Test Data Properties File **********");
			prop = new Properties();
			FileReader reader = new FileReader("PropertyFiles/TestData.Properties");
			prop.load(reader);
			
			strEnv = prop.getProperty("strEnv");
			 
			strUrlOci = prop.getProperty("strUrlOci");
			strUsernameOci = prop.getProperty("strUsernameOci");
			strPasswordOci = prop.getProperty("strPasswordOci");
					
			strUrlProd = prop.getProperty("strUrlProd");
			strUsernameProd = prop.getProperty("strUsernameProd");
			strPasswordProd = prop.getProperty("strPasswordProd");
			
			strUrlDev = prop.getProperty("strUrlDev");
			strUsernameDev = prop.getProperty("strUsernameDev");
			strPasswordDev = prop.getProperty("strPasswordDev");
			
			strUrlProdStaging = prop.getProperty("strUrlProdStaging");
			strUsernameProdStaging = prop.getProperty("strUsernameProdStaging");
			strPasswordProdStaging = prop.getProperty("strPasswordProdStaging");
			
			if (strEnv.equalsIgnoreCase("PROD")) {
				strUrl = strUrlProd;
				strUsername = strUsernameProd;
				strPassword = strPasswordProd;
			} else if (strEnv.equalsIgnoreCase("PROD_STAGING")) {
				strUrl = strUrlProdStaging;
				strUsername = strUsernameProdStaging;
				strPassword = strPasswordProdStaging;
			} else if (strEnv.equalsIgnoreCase("DEV")) {
				strUrl = strUrlDev;
				strUsername = strUsernameDev;
				strPassword = strPasswordDev;
			} else if (strEnv.equalsIgnoreCase("OCI")) {
				strUrl = strUrlOci;
				strUsername = strUsernameOci;
				strPassword = strPasswordOci;
			} else {
				logFailStepInExtentReport("Incorrect Environment!!!Please Specify Correct Environment & Try Again");
				assertTrue(false);
			}
		} catch (IOException e) {
			e.printStackTrace();
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
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
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
			title = driver.getTitle();
		} catch (Exception e) {
			e.printStackTrace();
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

	public static void scrollToElement(String xpath) throws Exception {
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
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < 3) {
				try {
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
					if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(100);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + xpath);
				}
			}
			count = count + 1;
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
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + xpath);
				}
			}
			count = count + 1;
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
	public static WebElement uiElementWithoutScrolling(String xpath) throws Exception {
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + xpath);
				}
			}
			count = count + 1;
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
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(byLocator));
					if (driver.findElement(byLocator).isDisplayed() && driver.findElement(byLocator).isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(byLocator));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(byLocator).isDisplayed() && driver.findElement(byLocator).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + byLocator);
				}
			}
			count = count + 1;
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
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (webElement.isDisplayed() && webElement.isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + webElement);
				}
			}
			count = count + 1;
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
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(By.xpath(xpath)).isDisplayed()
							&& driver.findElement(By.xpath(xpath)).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + xpath);
				}
			}
			count = count + 1;
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
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(500);
					JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(byLocator));
					if (driver.findElement(byLocator).isDisplayed() && driver.findElement(byLocator).isEnabled()) {
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(byLocator));
						flag = false;
					}
				} catch (Exception e) {
					explicitWaitInMilliSeconds(500);
				}
			} else {
				System.out.println(count + "Attempts Over");
				System.out.println("Unable to locate Web Element");
				flag = false;
				try {
					if (driver.findElement(byLocator).isDisplayed() && driver.findElement(byLocator).isEnabled()) {
						System.out.println("Able to locate the Web Element after " + count + " attempts");
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception("Unable to locate Web Element Having Xpath : " + byLocator);
				}
			}
			count = count + 1;
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
		boolean isElementPresent = false;
		boolean flag = true;
		int count = 1;
		logConsoleOutputMessage("xpath: " + xpath);
		while (flag) {
			if (count < 2) {
				try {
					explicitWaitInMilliSeconds(250);
					if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(By.xpath(xpath)));
						isElementPresent = true;
						flag = false;
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
	 * This generic method waits until a web element gets displayed. This Method
	 * accepts By Locator as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param byLocator
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayed(By byLocator) throws Exception {
		boolean isElementPresent = false;
		boolean flag = true;
		int count = 1;
		while (flag) {
			if (count < numOfAttemptsToFindWebElement) {
				try {
					explicitWaitInMilliSeconds(250);

					if (driver.findElement(byLocator).isDisplayed()) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
								driver.findElement(byLocator));
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
	 * This generic method waits until a web element gets displayed. This Method
	 * accepts WebElement as parameter.
	 * 
	 * @author Mohammed_Mudassir
	 * @param webElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isWebElementDisplayed(WebElement webElement) throws Exception {
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
	public static String getAnyAttributeFromWeb(WebDriver driver, String xpath, String attribute) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    if (element == null) {
	        throw new IllegalArgumentException("Element not found for XPath: " + xpath);
	    }
	    String attributeValue = element.getDomAttribute(attribute);
	    if (attributeValue == null) {
	        attributeValue = element.getDomProperty(attribute);
	    }
	    return attributeValue;
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
	public static String getAnyAttributeFromWeb(WebDriver driver, By byLocator, String attribute) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	    if (element == null) {
	        throw new IllegalArgumentException("Element not found for locator: " + byLocator.toString());
	    }
	    String attributeValue = element.getDomAttribute(attribute);
	    if (attributeValue == null) {
	        attributeValue = element.getDomProperty(attribute);
	    }
	    return attributeValue;
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
	    if (webElement == null) {
	        throw new IllegalArgumentException("WebElement cannot be null.");
	    }
	    String attributeValue = webElement.getDomAttribute(attribute);
	    if (attributeValue == null) {
	        attributeValue = webElement.getDomProperty(attribute);
	    }
	    return attributeValue;
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
	public static boolean isExpectedOptionPresentInSelectBox(WebDriver driver, String xpath, String option) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the dropdown is present and visible
	    WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

	    // Ensure the located element is a select dropdown
	    if (!dropdownElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided XPath does not point to a select dropdown.");
	    }

	    Select select = new Select(dropdownElement);

	    // Loop through options and check both 'value' and visible text
	    for (WebElement optionElement : select.getOptions()) {
	        String optionValue = optionElement.getDomAttribute("value"); // Correct: getDomAttribute() replaces deprecated getAttribute()
	        String optionText = optionElement.getText().trim(); // Correct: getText() has no parameters

	        if ((optionValue != null && optionValue.equalsIgnoreCase(option)) ||
	            (!optionText.isEmpty() && optionText.equalsIgnoreCase(option))) {
	            return true; // Option found
	        }
	    }
	    return false; // Option not found
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
	public static boolean isExpectedOptionPresentInSelectBox(WebDriver driver, By byLocator, String option) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	    if (!dropdownElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided By locator does not point to a select dropdown.");
	    }
	    Select select = new Select(dropdownElement);
	    for (WebElement optionElement : select.getOptions()) {
	        if (optionElement.getText().trim().equalsIgnoreCase(option)) {
	            return true; // Option found
	        }
	    }
	    return false; // Option not found
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
	    // Ensure the element is a valid select dropdown
	    if (!webElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided WebElement is not a select dropdown.");
	    }

	    Select select = new Select(webElement);
	    for (WebElement optionElement : select.getOptions()) {
	        if (optionElement.getText().trim().equalsIgnoreCase(option)) {
	            return true; // Option found
	        }
	    }
	    return false; // Option not found
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
	public static void mandatorySelectBox(WebDriver driver, String xpath, String option) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    if (!dropdownElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided XPath does not point to a select dropdown.");
	    }
	    Select select = new Select(dropdownElement);
	    try {
	        if (option != null && !option.isEmpty()) {
	            select.selectByVisibleText(option);
	        } else {
	            select.selectByIndex(0);
	            if (select.getFirstSelectedOption().getText().trim().equalsIgnoreCase("Select")) {
	                select.selectByIndex(1);
	            }
	        }
	    } catch (Exception e) {
	        select.selectByIndex(1);
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
	public static void mandatorySelectBox(WebDriver driver, By byLocator, String option) throws Exception {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement dropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	    if (!dropdownElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided By locator does not point to a select dropdown.");
	    }
	    Select select = new Select(dropdownElement);
	    try {
	        if (option != null && !option.isEmpty()) {
	            select.selectByVisibleText(option);
	        } else {
	            select.selectByIndex(0);
	            if (select.getFirstSelectedOption().getText().trim().equalsIgnoreCase("Select")) {
	                select.selectByIndex(1);
	            }
	        }
	    } catch (Exception e) {
	        select.selectByIndex(1);
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
	    if (!webElement.getTagName().equalsIgnoreCase("select")) {
	        throw new IllegalArgumentException("Provided WebElement is not a select dropdown.");
	    }
	    Select select = new Select(webElement);
	    try {
	        if (option != null && !option.isEmpty()) {
	            select.selectByVisibleText(option);
	        } else {
	            select.selectByIndex(0);
	            if (select.getFirstSelectedOption().getText().trim().equalsIgnoreCase("Select")) {
	                select.selectByIndex(1);
	            }
	        }
	    } catch (Exception e) {
	        select.selectByIndex(1);
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		String strDate = formatter.format(date);
		return strDate;
	}

	public static String convertDateFromCurrentFormatToAnyFormat(String sourceDate, String sourceDateFormat,
			String targetDateFormat) {
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

}
