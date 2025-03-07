package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.DropBoxDriveMoveFunctionality;


public class DropBoxToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	DropBoxDriveMoveFunctionality DropBox;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        DropBox = new DropBoxDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromDropBoxToOtherDrives() {
		try {
			loginPage.loginMethod();

			DropBox.verifyMoveFilesFunctionalityFromDropBoxToIoCloudDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToAWSDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToBOXDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToDropBoxDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToFTPDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToGoogleCloudDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToGoogleDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToAzureDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToOneDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToSFTPDrive();
			
			DropBox.verifyMoveFilesFunctionalityFromDropBoxToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
