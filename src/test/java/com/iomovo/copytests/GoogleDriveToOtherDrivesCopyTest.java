package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.GoogleDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleDriveToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleDriveCopyFunctionality GoogleDrive;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleDrive = new GoogleDriveCopyFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromGoogleDriveToOtherDrives() {
		try {
			loginPage.loginMethod();

			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToIoCloudDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToAWSDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToBoxDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToDropBoxDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToFTPDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToGoogleCloudDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToGoogleDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToAzureDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToOneDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToSFTPDrive();
			
			GoogleDrive.verifyCopyFilesFunctionalityFromGoogleDriveToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

