package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.AWSS3Audio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AWSS3Audio_VideoConvertFunctionalityTest extends BaseTestClass 
{
	
	LoginPage loginPage;
	AWSS3Audio_VideoConvertFunctionality AWSS3;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        AWSS3 = new AWSS3Audio_VideoConvertFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInAWSS3() {
		
		try {
			
			loginPage.loginMethod();
			
			AWSS3.verifyAudioConvertFunctionalityInAWSS3();
			
			AWSS3.verifyVideoConvertFunctionalityInAWSS3();
			
			AWSS3.verifyVideo2AudioConvertFunctionalityInAWSS3();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}