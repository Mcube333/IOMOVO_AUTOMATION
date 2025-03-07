package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.DropBoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class DropBoxToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	DropBoxDriveCopyFunctionality DropBox;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        DropBox = new DropBoxDriveCopyFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests

	@Test
	public void verifyCopyFilesFunctionalityFromDropBoxToOtherDrives() {
		try {
			loginPage.loginMethod();

			DropBox.verifyCopyFilesFunctionalityFromDropBoxToIoCloudDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToAWSDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToBOXDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToDropBoxDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToFTPDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToGoogleCloudDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToGoogleDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToAzureDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToOneDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToSFTPDrive();
			
			DropBox.verifyCopyFilesFunctionalityFromDropBoxToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

