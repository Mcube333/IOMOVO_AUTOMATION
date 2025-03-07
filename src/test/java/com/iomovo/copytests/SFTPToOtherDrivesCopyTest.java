package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.SftpDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class SFTPToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	 SftpDriveCopyFunctionality SFTP;
   
	
  @BeforeMethod
  public void setUp() {
      if (driver == null) {
          throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
      }
      loginPage = new LoginPage();
      SFTP = new SftpDriveCopyFunctionality(driver, wait);
  }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromSFTPToOtherDrives() {
		try {
			loginPage.loginMethod();

			SFTP.verifyCopyFilesFunctionalityFromSFTPToIoCloudDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToAWSDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToBoxDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToDropBoxDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToFTPDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToGoogleCloudDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToGoogleDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToAzureDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToOneDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToSFTPDrive();
			
			SFTP.verifyCopyFilesFunctionalityFromSFTPToSharePointDrive();

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
//			SFTPDriveCopyFunctionality SFTPDrive = new SFTPDriveCopyFunctionality(driver, wait);
//			SFTPDrive.verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}

