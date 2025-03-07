package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.SharePointCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SharePointToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	SharePointCopyFunctionality SharePoint;
  
	
 @BeforeMethod
 public void setUp() {
     if (driver == null) {
         throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
     }
     loginPage = new LoginPage();
     SharePoint = new SharePointCopyFunctionality(driver, wait);
 }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromSharePointToOtherDrives() {
		try {
			loginPage.loginMethod();

			SharePoint.verifyCopyFilesFunctionalityFromSharePointToIoCloudDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToAWSDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToBoxDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToDropBoxDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToFTPDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToGoogleCloudDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToGoogleDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToAzureDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToOneDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToSFTPDrive();
			
			SharePoint.verifyCopyFilesFunctionalityFromSharePointToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.LoginTest();
//
//			SharePointCopyFunctionality SharePoint = new SharePointCopyFunctionality(driver, wait);
//			SharePoint.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}

