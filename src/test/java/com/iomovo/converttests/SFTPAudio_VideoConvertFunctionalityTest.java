package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.SFTPAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SFTPAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	SFTPAudio_VideoConvertFunctionality SFTP;
     
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SFTP = new SFTPAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInSFTP() {
		
		try {
			
			loginPage.loginMethod();
			
			SFTP.verifyAudioConvertFunctionalityInSFTP();
			
			SFTP.verifyVideoConvertFunctionalityInSFTP();
			
			SFTP.verifyVideo2AudioConvertFunctionalityInSFTP();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

