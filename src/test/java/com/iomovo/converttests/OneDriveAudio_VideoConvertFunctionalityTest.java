package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.OneDriveAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OneDriveAudio_VideoConvertFunctionalityTest extends BaseTestClass 
{
	
	LoginPage loginPage;
	OneDriveAudio_VideoConvertFunctionality OneDrive;
     
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OneDrive = new OneDriveAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInOneDrive() {
		
		try {
			
			loginPage.loginMethod();
			
			OneDrive.verifyAudioConvertFunctionalityInOneDrive();
			
			OneDrive.verifyVideoConvertFunctionalityInOneDrive();
			
			OneDrive.verifyVideo2AudioConvertFunctionalityInOneDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

