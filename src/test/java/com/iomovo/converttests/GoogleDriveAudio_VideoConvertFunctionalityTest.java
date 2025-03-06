package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.GoogleDriveAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleDriveAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleDriveAudio_VideoConvertFunctionality GoogleDrive;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleDrive = new GoogleDriveAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInGoogleDrive() {
		
		try {
			
			loginPage.loginMethod();
			
			GoogleDrive.verifyAudioConvertFunctionalityInGoogleDrive();
			
			GoogleDrive.verifyVideoConvertFunctionalityInGoogleDrive();
			
			GoogleDrive.verifyVideo2AudioConvertFunctionalityInGoogleDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}