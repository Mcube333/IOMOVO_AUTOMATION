package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.OneDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OneDriveToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	OneDriveCopyFunctionality OneDrive;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OneDrive = new OneDriveCopyFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromOneDriveToOtherDrives() {
		try {
			loginPage.loginMethod();

			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToIoCloudDrive();

			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToAWSDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToBoxDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToDropBoxDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToFTPDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToGoogleCloudDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToGoogleDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToAzureDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToOneDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToSFTPDrive();
			
			OneDrive.verifyCopyFilesFunctionalityFromOneDriveToSharePointDrive();
			
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
//			OneDriveCopyFunctionality OneDrive = new OneDriveCopyFunctionality(driver, wait);
//			OneDrive.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}

