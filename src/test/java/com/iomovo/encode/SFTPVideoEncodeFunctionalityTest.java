package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.SFTPVideoEncodeFunctionality;

public class SFTPVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	SFTPVideoEncodeFunctionality SFTP;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SFTP = new SFTPVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			SFTP.VerifyVideoEncodeFunctionalityto1080pinSFTPDrive();
			
			SFTP.VerifyVideoEncodeFunctionalityto720pinSFTPDrive();
			
			SFTP.VerifyVideoEncodeFunctionalityto480pinSFTPDrive();
			
			SFTP.VerifyVideoEncodeFunctionalityto360pinSFTPDrive();
			
			SFTP.VerifyVideoEncodeFunctionalityto240pinSFTPDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
