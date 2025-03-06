package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.GoogleDriveVideoEncodeFunctionality;

public class GoogleDriveVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleDriveVideoEncodeFunctionality GoogleDrive;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleDrive = new GoogleDriveVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			GoogleDrive.VerifyVideoEncodeFunctionalityto1080pinGoogleDrive();
			
			GoogleDrive.VerifyVideoEncodeFunctionalityto720pinGoogleDrive();
			
			GoogleDrive.VerifyVideoEncodeFunctionalityto480pinGoogleDrive();
			
			GoogleDrive.VerifyVideoEncodeFunctionalityto360pinGoogleDrive();
			
			GoogleDrive.VerifyVideoEncodeFunctionalityto240pinGoogleDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
