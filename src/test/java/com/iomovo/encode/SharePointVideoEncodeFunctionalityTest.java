package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.SharePointVideoEncodeFunctionality;

public class SharePointVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	SharePointVideoEncodeFunctionality SharePoint;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SharePoint = new SharePointVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			SharePoint.VerifyVideoEncodeFunctionalityto1080pinSharePointDrive();
			
			SharePoint.VerifyVideoEncodeFunctionalityto720pinSharePointDrive();
			
			SharePoint.VerifyVideoEncodeFunctionalityto480pinSharePointDrive();
			
			SharePoint.VerifyVideoEncodeFunctionalityto360pinSharePointDrive();
			
			SharePoint.VerifyVideoEncodeFunctionalityto240pinSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
