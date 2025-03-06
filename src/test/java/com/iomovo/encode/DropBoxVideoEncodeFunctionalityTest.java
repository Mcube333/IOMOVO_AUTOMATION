package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.DropBoxVideoEncodeFunctionality;

public class DropBoxVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	DropBoxVideoEncodeFunctionality DropBox;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        DropBox = new DropBoxVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			DropBox.VerifyVideoEncodeFunctionalityto1080pinDropBoxDrive();
			
			DropBox.VerifyVideoEncodeFunctionalityto720pinDropBoxDrive();
			
			DropBox.VerifyVideoEncodeFunctionalityto480pinDropBoxDrive();
			
			DropBox.VerifyVideoEncodeFunctionalityto360pinDropBoxDrive();
			
			DropBox.VerifyVideoEncodeFunctionalityto240pinDropBoxDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
