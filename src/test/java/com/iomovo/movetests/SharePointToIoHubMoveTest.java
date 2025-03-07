package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.SharePointDriveMoveFunctionality;


public class SharePointToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	SharePointDriveMoveFunctionality SharePoint;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        SharePoint = new SharePointDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromSharePointToOtherDrives() {
		try {
			loginPage.loginMethod();

			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToIoCloudDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToAWSDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToBOXDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToDropBoxDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToFTPDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToGoogleCloudDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToGoogleDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToAzureDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToOneDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToSFTPDrive();
			
			SharePoint.verifyMoveFilesFunctionalityFromSharePointDriveToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
