package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.FTPVideoEncodeFunctionality;

public class FTPVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	FTPVideoEncodeFunctionality FTP;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        FTP = new FTPVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			FTP.VerifyVideoEncodeFunctionalityto1080pinFTPDrive();
			
			FTP.VerifyVideoEncodeFunctionalityto720pinFTPDrive();
			
			FTP.VerifyVideoEncodeFunctionalityto480pinFTPDrive();
			
			FTP.VerifyVideoEncodeFunctionalityto360pinFTPDrive();
			
			FTP.VerifyVideoEncodeFunctionalityto240pinFTPDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
