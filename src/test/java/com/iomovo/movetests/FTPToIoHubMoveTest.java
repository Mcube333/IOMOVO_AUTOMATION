package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.FtpDriveMoveFunctionality;


public class FTPToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	FtpDriveMoveFunctionality FTP;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        FTP = new FtpDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromFTPToOtherDrives() {
		try {
			loginPage.loginMethod();

			FTP.verifyMoveFilesFunctionalityFromFTPToIoCloudDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToAWSDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToBOXDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToDropBoxDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToFTPDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToGoogleCloudDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToGoogleDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToAzureDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToOneDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToSFTPDrive();
			
			FTP.verifyMoveFilesFunctionalityFromFTPToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
