package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.FtpDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class FTPToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	FtpDriveCopyFunctionality FTP;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        FTP = new FtpDriveCopyFunctionality(driver, wait);
    }
	
	//These Below Methods are for Login Functionality tests
	
	@Test
	public void verifyCopyFilesFunctionalityFromFTPToOtherDrives() {
		try {
			loginPage.loginMethod();

			FTP.verifyCopyFilesFunctionalityFromFTPToIoCloudDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToAWSDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToBOXDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToDropBoxDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToFTPDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToGoogleCloudDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToGoogleDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToAzureDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToOneDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToSFTPDrive();
			
			FTP.verifyCopyFilesFunctionalityFromFTPToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


