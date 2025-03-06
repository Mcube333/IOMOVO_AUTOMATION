package com.iomovo.encode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.IoCloudVideoEncodeFunctionality;

public class IoCloudVideoEncodeFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	IoCloudVideoEncodeFunctionality IoCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        IoCloud = new IoCloudVideoEncodeFunctionality(driver, wait);
    }
	
	@Test
	public void AWSS3VideoEncodeFunctionality() {
		
		try {
			
			loginPage.loginMethod();
			
			IoCloud.VerifyVideoEncodeFunctionalityto1080pinIoCloudDrive();
			
			IoCloud.VerifyVideoEncodeFunctionalityto720pinIoCloudDrive();
			
			IoCloud.VerifyVideoEncodeFunctionalityto480pinIoCloudDrive();
			
			IoCloud.VerifyVideoEncodeFunctionalityto360pinIoCloudDrive();
			
			IoCloud.VerifyVideoEncodeFunctionalityto240pinIoCloudDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
