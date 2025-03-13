package com.iomovo.converttests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.ConvertFunctionality.SharePointAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SharePointAudio_VideoConvertFunctionalityTest extends BaseClass {
	
	LoginPage loginPage;
	SharePointAudio_VideoConvertFunctionality SharePoint;
     
	@BeforeMethod
    public void setUp() { // ✅ Correct method name & signature
        WebDriver driver = getDriver(); // ✅ Correct WebDriver retrieval
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in test setup.");
        }

        loginPage = new LoginPage(driver, getWait()); // ✅ Ensure proper initialization
        SharePoint = new SharePointAudio_VideoConvertFunctionality(driver, getWait()); // ✅ Ensure AWSS3 is initialized
    }
	
	@Test
    public void verifyAudioConvertFunctionalityInSharePoint() throws Exception {
		SharePoint.verifyAudioConvertFunctionalityInSharePoint();
    }

    @Test
    public void verifyVideoConvertFunctionalityInSharePoint() throws Exception {
    	SharePoint.verifyVideoConvertFunctionalityInSharePoint();
    }

    @Test
    public void verifyVideo2AudioConvertFunctionalityInSharePoint() throws Exception {
    	SharePoint.verifyVideo2AudioConvertFunctionalityInSharePoint();
    }
}
