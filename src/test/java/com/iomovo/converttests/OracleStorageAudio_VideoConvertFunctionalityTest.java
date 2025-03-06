package com.iomovo.converttests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.ConvertFunctionality.OracleStorageAudio_VideoConvertFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OracleStorageAudio_VideoConvertFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	OracleStorageAudio_VideoConvertFunctionality Oracle;
     
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Oracle = new OracleStorageAudio_VideoConvertFunctionality(driver, wait);
    }
	
	@Test
	public void verifyAudio_VideoConvertFunctionalityInOracleStorage() {
		
		try {
			
			loginPage.loginMethod();
			
			Oracle.verifyAudioConvertFunctionalityInOracleStorage();
			
			Oracle.verifyVideoConvertFunctionalityInOracleStorage();
			
			Oracle.verifyVideo2AudioConvertFunctionalityInOracleStorage();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}