package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.SftpDriveMoveFunctionality;


public class SFTPToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	SftpDriveMoveFunctionality SFTP;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SFTP = new SftpDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromSFTPToOtherDrives() {
		try {
			loginPage.loginMethod();

			SFTP.verifyMoveFilesFunctionalityFromSFTPToIoCloudDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToAWSDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToBOXDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToDropBoxDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToFTPDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToGoogleCloudDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToGoogleDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToAzureDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToOneDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToSFTPDrive();
			
			SFTP.verifyMoveFilesFunctionalityFromSFTPToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
