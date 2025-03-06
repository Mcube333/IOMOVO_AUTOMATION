package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.GoogleCloudVideoEncodeFunctionality;

public class GoogleCloudVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleCloudVideoEncodeFunctionality GoogleCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleCloud = new GoogleCloudVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			GoogleCloud.VerifyVideoEncodeFunctionalityto1080pinGoogleCloudDrive();
			
			GoogleCloud.VerifyVideoEncodeFunctionalityto720pinGoogleCloudDrive();
			
			GoogleCloud.VerifyVideoEncodeFunctionalityto480pinGoogleCloudDrive();
			
			GoogleCloud.VerifyVideoEncodeFunctionalityto360pinGoogleCloudDrive();
			
			GoogleCloud.VerifyVideoEncodeFunctionalityto240pinGoogleCloudDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
