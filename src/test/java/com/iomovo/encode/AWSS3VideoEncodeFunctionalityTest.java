package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.AWSS3VideoEncodeFunctionality;

public class AWSS3VideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	AWSS3VideoEncodeFunctionality AWSS3;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        AWSS3 = new AWSS3VideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			AWSS3.VerifyVideoEncodeFunctionalityto1080pinAWSS3Drive();
			
			AWSS3.VerifyVideoEncodeFunctionalityto720pinAWSS3Drive();
			
			AWSS3.VerifyVideoEncodeFunctionalityto480pinAWSS3Drive();
			
			AWSS3.VerifyVideoEncodeFunctionalityto360pinAWSS3Drive();
			
			AWSS3.VerifyVideoEncodeFunctionalityto240pinAWSS3Drive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
