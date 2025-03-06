package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.DropBoxAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class DropBoxAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	DropBoxAudio_VideoConvertFunctionality DropBox;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        DropBox = new DropBoxAudio_VideoConvertFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests

	@Test
	public void verifyAudio_VideoConvertFunctionalityInDropBox() {
		
		try {
			
			loginPage.loginMethod();
			
			DropBox.verifyAudioConvertFunctionalityInDropBox();
			
			DropBox.verifyVideoConvertFunctionalityInDropBox();
			
			DropBox.verifyVideo2AudioConvertFunctionalityInDropBox();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}