package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.AzureDriveMoveFunctionality;


public class AzureToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	AzureDriveMoveFunctionality Azure;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Azure = new AzureDriveMoveFunctionality(driver, wait);
    }
	
	
	@Test
	public void verifyCopyFilesFunctionalityFromAzureToOtherDrives() {
		try {
			loginPage.loginMethod();

			Azure.verifyMoveFilesFunctionalityFromAzureToIoCloudDrive();
			
			Azure.verifyMoveFilesFunctionalityFromAzureToAWSDrive();
			
			Azure.verifyMoveFilesFunctionalityFromAzureToBOXDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToDropBoxDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToFTPDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToGoogleCloudDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToGoogleDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToAzureDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToOneDrive();

			Azure.verifyMoveFilesFunctionalityFromAzureToSFTPDrive();
			
			Azure.verifyMoveFilesFunctionalityFromAzureToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
