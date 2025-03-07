package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.GoogleDriveMoveFunctionality;


public class GoogleDriveToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleDriveMoveFunctionality GoogleDrive;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleDrive = new GoogleDriveMoveFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromGoogleDriveToOtherDrives() {
		try {
			loginPage.loginMethod();

			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToIoCloudDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToAWSDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToBOXDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToDropBoxDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToFTPDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToGoogleCloudDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToGoogleDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToAzureDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToOneDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToSFTPDrive();
			
			GoogleDrive.verifyMoveFilesFunctionalityFromGoogleDriveToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
