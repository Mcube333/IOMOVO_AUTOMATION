package com.iomovo.ioportaltests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.IoPortalFunctionality.CreateIoPortalFunctionality;


public class CreateIoPortalFunctionalityTests extends BaseTestClass {
	
	LoginPage loginPage;
	CreateIoPortalFunctionality IoPortal;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        IoPortal = new CreateIoPortalFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyCreatePortalFunctionality() {
		try {
			loginPage.loginMethod();
						
			IoPortal.verifyCreatePortalFunctionality();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
