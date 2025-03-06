package com.iomovo.converttests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.GoogleCloudAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleCloudAudio_VideoConvertFunctionalityTest extends BaseTestClass 
{
	
	LoginPage loginPage;
	GoogleCloudAudio_VideoConvertFunctionality GoogleCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleCloud = new GoogleCloudAudio_VideoConvertFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInGoogleCloud() {
		
		try {
			
			loginPage.loginMethod();
			
			GoogleCloud.verifyAudioConvertFunctionalityInGoogleCloud();
			
			GoogleCloud.verifyVideoConvertFunctionalityInGoogleCloud();
			
			GoogleCloud.verifyVideo2AudioConvertFunctionalityInGoogleCloud();
			
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

