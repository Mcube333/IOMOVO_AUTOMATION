package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.AzureDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AzureToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	AzureDriveCopyFunctionality Azure;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Azure = new AzureDriveCopyFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests

	@Test
	public void verifyCopyFilesFunctionalityFromAzureToOtherDrives() {
		try {
			loginPage.loginMethod();

			Azure.verifyCopyFilesFunctionalityFromAzureToIoCloudDrive();
			
			Azure.verifyCopyFilesFunctionalityFromAzureToAWSDrive();
			
			Azure.verifyCopyFilesFunctionalityFromAzureToBoxDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToDropBoxDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToFTPDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToGoogleCloudDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToGoogleDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToAzureDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToOneDrive();

			Azure.verifyCopyFilesFunctionalityFromAzureToSFTPDrive();
			
			Azure.verifyCopyFilesFunctionalityFromAzureToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}