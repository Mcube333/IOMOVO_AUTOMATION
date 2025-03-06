package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.MSAzureVideoEncodeFunctionality;

public class MSAzureVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	MSAzureVideoEncodeFunctionality MSAzure;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        MSAzure = new MSAzureVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			MSAzure.VerifyVideoEncodeFunctionalityto1080pinAzureDrive();
			
			MSAzure.VerifyVideoEncodeFunctionalityto720pinAzureDrive();
			
			MSAzure.VerifyVideoEncodeFunctionalityto480pinAzureDrive();
			
			MSAzure.VerifyVideoEncodeFunctionalityto360pinAzureDrive();
			
			MSAzure.VerifyVideoEncodeFunctionalityto240pinAzureDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
