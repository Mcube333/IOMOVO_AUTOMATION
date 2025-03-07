package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.GoogleCloudDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class GoogleCloudToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleCloudDriveCopyFunctionality GoogleCloud;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleCloud = new GoogleCloudDriveCopyFunctionality(driver, wait);
    }
	
	//These Below Methods are for Login Functionality tests

	
	@Test
	public void verifyCopyFilesFunctionalityFromGoogleCloudToOtherDrives() {
		try {
			loginPage.loginMethod();

			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToIoCloudDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToAWSDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToBoxDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToDropBoxDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToFTPDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToGoogleCloudDrive();
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToGoogleDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToAzureDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToOneDrive();
			
			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToSFTPDrive();

			GoogleCloud.verifyCopyFilesFunctionalityFromGoogleCloudToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

