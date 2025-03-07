package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.IoCloudAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class IoCloudAudio_VideoConvertFunctionalityTest extends BaseTestClass {

	LoginPage loginPage;
	IoCloudAudio_VideoConvertFunctionality IoCloud;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        IoCloud = new IoCloudAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInIoCloud() {
		
		try {
			
			loginPage.loginMethod();
			
			IoCloud.verifyAudioConvertFunctionalityInIoCloud();
			
//			IoCloud.verifyVideoConvertFunctionalityInIoCloud();
//			
//			IoCloud.verifyVideo2AudioConvertFunctionalityInIoCloud();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
