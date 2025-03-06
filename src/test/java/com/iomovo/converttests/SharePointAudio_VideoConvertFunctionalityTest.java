package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.SharePointAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SharePointAudio_VideoConvertFunctionalityTest extends BaseTestClass 
{
	
	LoginPage loginPage;
	SharePointAudio_VideoConvertFunctionality SharePoint;
     
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SharePoint = new SharePointAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInSharePoint() {
		
		try {
			
			loginPage.loginMethod();
			
			SharePoint.verifyAudioConvertFunctionalityInSharePoint();
			
			SharePoint.verifyVideoConvertFunctionalityInSharePoint();
			
			SharePoint.verifyVideo2AudioConvertFunctionalityInSharePoint();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}

