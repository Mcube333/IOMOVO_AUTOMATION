package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.IoCloudDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class IoCloudToIoHubCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	IoCloudDriveCopyFunctionality IoCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        IoCloud = new IoCloudDriveCopyFunctionality(driver, wait);
    }

	@Test
	public void verifyCopyFilesFunctionFromIoCloudToIoCloud() {
		try {
			loginPage.loginMethod();

			IoCloud.verifyCopyFilesFunctionalityFromIoCloudToIoCloudDrive();
			
			IoCloud.verifyCopyFilesFunctionalityFromIoCloudToAwsDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToBoxDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToDropbox();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToFTPDrive();

			IoCloud.verifyCopyFilesFunctionFromIoCloudToGoogleCloudDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToGoogleDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToAzureDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToOneDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToSFTPDrive();
			
			IoCloud.verifyCopyFilesFunctionFromIoCloudToSharepointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			IoCloudDriveCopyFunctionality ioCloud = new IoCloudDriveCopyFunctionality(driver, wait);
//			ioCloud.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
