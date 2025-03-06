package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.FTPAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class FTPAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	FTPAudio_VideoConvertFunctionality FTP;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        FTP = new FTPAudio_VideoConvertFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInFTP() {
		
		try {
			
			loginPage.loginMethod();
			
			FTP.verifyAudioConvertFunctionalityInFTP();
			
			FTP.verifyVideoConvertFunctionalityInFTP();
			
			FTP.verifyVideo2AudioConvertFunctionalityInFTP();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}