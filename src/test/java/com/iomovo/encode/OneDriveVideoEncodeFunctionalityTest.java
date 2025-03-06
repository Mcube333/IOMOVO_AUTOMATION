package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.OneDriveVideoEncodeFunctionality;

public class OneDriveVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	OneDriveVideoEncodeFunctionality OneDrive;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OneDrive = new OneDriveVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			OneDrive.VerifyVideoEncodeFunctionalityto1080pinOneDrive();
			
			OneDrive.VerifyVideoEncodeFunctionalityto720pinOneDrive();
			
			OneDrive.VerifyVideoEncodeFunctionalityto480pinOneDrive();
			
			OneDrive.VerifyVideoEncodeFunctionalityto360pinOneDrive();
			
			OneDrive.VerifyVideoEncodeFunctionalityto240pinOneDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
