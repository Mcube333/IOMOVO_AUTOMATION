package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_AzureDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_AzureToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	 Optimised_AzureDriveCopyFunctionality OAzure;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OAzure = new Optimised_AzureDriveCopyFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromAzureToOtherDrives() {
		try {
			loginPage.loginMethod();

			OAzure.verifyCopyFilesFunctionalityFromAzureToIoCloudDrive();
			
			OAzure.verifyCopyFilesFunctionalityFromAzureToAWSDrive();
			
			OAzure.verifyCopyFilesFunctionalityFromAzureToBoxDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToDropBoxDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToFTPDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToGoogleDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToAzureDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToOneDrive();

			OAzure.verifyCopyFilesFunctionalityFromAzureToOOSDrive();
			
			OAzure.verifyCopyFilesFunctionalityFromAzureToSFTPDrive();
			
			OAzure.verifyCopyFilesFunctionalityFromAzureToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

