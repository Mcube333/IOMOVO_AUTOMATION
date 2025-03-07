package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.OOSDriveMoveFunctionality;


public class OosDriveToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	OOSDriveMoveFunctionality Oracle;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Oracle = new OOSDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromOneDriveToOtherDrives() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();

			Oracle.verifyMoveFilesFunctionalityFromOosToIoCloudDrive();

			Oracle.verifyMoveFilesFunctionalityFromOosToAwsDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToBoxDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToDropBoxDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToFTPDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToGoogleCloudDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToGoogleDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToMSAzureDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToOneDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToSftpDrive();
			
			Oracle.verifyMoveFilesFunctionalityFromOosToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
