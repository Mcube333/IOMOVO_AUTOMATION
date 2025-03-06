package com.iomovo.utilspackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.iomovo.basepackage.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportsClass extends BaseClass {
	ExtentReports extentReports;
	ExtentTest extLog;

	public ExtentTest startReport(String testName) {
		extentReports = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/ExtentReport_IomovoApp_"
				+ getCurrentDate("ddMMMyyyy_HHmmss") + ".html", true);
		
		// Load Extent Report Config XML
		File configFile = new File(System.getProperty("user.dir") + "/PropertyFiles/extent-config.xml");
		if (configFile.exists()) {
			extentReports.loadConfig(configFile);
		} else {
			System.out.println("Warning: extent-config.xml not found at " + configFile.getAbsolutePath());
		}

		// Set system information
		extentReports.addSystemInfo("Environment", "QA");
		extentReports.addSystemInfo("User Name", "Mohammed Mudassir");

		extLog = extentReports.startTest(testName);
		return extLog;
	}

	public void endReport() {
		extentReports.endTest(extLog);
		extentReports.flush();
	}

	public String capture(WebDriver driver) {
		String errflpath = null;
		String projectPath = System.getProperty("user.dir");
		String dirNameforScreens = "ScreenShots";

		// Create screenshots directory if it doesn't exist
		File directory = new File(projectPath, dirNameforScreens);
		if (!directory.exists()) {
			directory.mkdir();
		}

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File Dest = new File(directory, System.currentTimeMillis() + ".png");
			errflpath = Dest.getAbsolutePath();
			FileUtils.copyFile(scrFile, Dest);
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
		}
		return errflpath;
	}
}
