package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.BoxDriveMoveFunctionality;


public class BoxToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	BoxDriveMoveFunctionality Box;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Box = new BoxDriveMoveFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromBOXToOtherDrives() {
		try {
			loginPage.loginMethod();

			Box.verifyMoveFilesFunctionalityFromBoxToIoCloudDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToAWSDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToBOXDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToDropBoxDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToFTPDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToGoogleCloudDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToGoogleDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToAzureDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToOneDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToSFTPDrive();
			
			Box.verifyMoveFilesFunctionalityFromBoxToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
