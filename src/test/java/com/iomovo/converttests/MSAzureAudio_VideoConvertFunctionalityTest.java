package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.MSAzureAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class MSAzureAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	MSAzureAudio_VideoConvertFunctionality MSAzure;
     
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        MSAzure = new MSAzureAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInMSAzure() {
		
		try {
			
			loginPage.loginMethod();
			
			MSAzure.verifyAudioConvertFunctionalityInMSAzure();
			
			MSAzure.verifyVideoConvertFunctionalityInMSAzure();
			
			MSAzure.verifyVideo2AudioConvertFunctionalityInMSAzure();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

