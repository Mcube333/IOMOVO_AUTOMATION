package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.OneDriveMoveFunctionality;


public class OneDriveToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	OneDriveMoveFunctionality OneDrive;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OneDrive = new OneDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromOneDriveToOtherDrives() {
		try {
			loginPage.loginMethod();

			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToIoCloudDrive();

			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToAWSDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToBOXDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToDropBoxDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToFTPDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToGoogleCloudDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToGoogleDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToAzureDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToOneDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToSFTPDrive();
			
			OneDrive.verifyMoveFilesFunctionalityFromOneDriveToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
