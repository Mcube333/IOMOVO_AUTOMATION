package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.BoxVideoEncodeFunctionality;

public class BoxVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	BoxVideoEncodeFunctionality Box;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Box = new BoxVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			Box.VerifyVideoEncodeFunctionalityto1080pinBoxDrive();
			
			Box.VerifyVideoEncodeFunctionalityto720pinBoxDrive();
			
			Box.VerifyVideoEncodeFunctionalityto480pinBoxDrive();
			
			Box.VerifyVideoEncodeFunctionalityto360pinBoxDrive();
			
			Box.VerifyVideoEncodeFunctionalityto240pinBoxDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
