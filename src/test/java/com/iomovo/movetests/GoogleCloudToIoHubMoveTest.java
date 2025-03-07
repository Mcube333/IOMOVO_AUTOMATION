package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.GoogleCloudDriveMoveFunctionality;


public class GoogleCloudToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	GoogleCloudDriveMoveFunctionality GoogleCloud;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        GoogleCloud = new GoogleCloudDriveMoveFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromGoogleCloudToOtherDrives() {
		try {
			loginPage.loginMethod();

			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToIoCloudDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToAWSDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToBOXDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToDropBoxDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToFTPDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToGoogleCloudDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToGoogleDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToAzureDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToOneDrive();
			
			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToSFTPDrive();

			GoogleCloud.verifyMoveFilesFunctionalityFromGoogleCloudToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
