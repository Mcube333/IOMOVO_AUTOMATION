package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.OracleStorageVideoEncodeFunctionality;

public class OracleStorageVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	OracleStorageVideoEncodeFunctionality Oracle;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Oracle = new OracleStorageVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			Oracle.VerifyVideoEncodeFunctionalityto1080pinOraleDrive();
			
			Oracle.VerifyVideoEncodeFunctionalityto720pinOraleDrive();
			
			Oracle.VerifyVideoEncodeFunctionalityto480pinOraleDrive();
			
			Oracle.VerifyVideoEncodeFunctionalityto360pinOraleDrive();
			
			Oracle.VerifyVideoEncodeFunctionalityto240pinOraleDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
