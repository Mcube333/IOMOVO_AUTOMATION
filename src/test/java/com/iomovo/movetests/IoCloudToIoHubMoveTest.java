package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.IoCloudDriveMoveFunctionality;


public class IoCloudToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	IoCloudDriveMoveFunctionality IoCloud;
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        IoCloud = new IoCloudDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionFromIoCloudToIoCloud() {
		try {
			loginPage.loginMethod();

			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToIoCloudDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToAwsDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToBoxDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToDropbox();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToFTPDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToGoogleCloudDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToGoogleDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToAzureDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToOneDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToSFTPDrive();
			
			IoCloud.verifyMoveFilesFunctionalityFromIoCloudToSharepointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
