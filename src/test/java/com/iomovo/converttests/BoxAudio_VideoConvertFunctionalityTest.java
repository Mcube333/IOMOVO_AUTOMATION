package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.BoxAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class BoxAudio_VideoConvertFunctionalityTest extends BaseTestClass 
{
	
	LoginPage loginPage;
	BoxAudio_VideoConvertFunctionality Box;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Box = new BoxAudio_VideoConvertFunctionality(driver, wait);
    }
    
    
	//These Below Methods are for Login Functionality tests

	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInBox() {
		
		try {
			
			loginPage.loginMethod();
			
			Box.verifyAudioConvertFunctionalityInBox();
			
			Box.verifyVideoConvertFunctionalityInBox();
			
			Box.verifyVideo2AudioConvertFunctionalityInBox();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}