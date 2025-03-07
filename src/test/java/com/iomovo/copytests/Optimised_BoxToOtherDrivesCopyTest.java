package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_BoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_BoxToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	 Optimised_BoxDriveCopyFunctionality OBox;
    
	
   @BeforeMethod
   public void setUp() {
       if (driver == null) {
           throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
       }
       loginPage = new LoginPage();
       OBox = new Optimised_BoxDriveCopyFunctionality(driver, wait);
   }
	
	@Test
	public void verifyCopyFilesFunctionalityFromBOXToOtherDrives() {
		try {
			loginPage.loginMethod();

			OBox.verifyCopyFilesFunctionalityFromBoxToIoCloudDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToAWSDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToBoxDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToDropBoxDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToFTPDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToGoogleCloudDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToGoogleDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToAzureDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToOneDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToOOSDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToOOSDrive();
			
			OBox.verifyCopyFilesFunctionalityFromBoxToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

