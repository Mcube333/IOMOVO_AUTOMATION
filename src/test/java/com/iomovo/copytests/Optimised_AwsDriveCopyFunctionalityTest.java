package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_AwsDriveCopyFunctionalityTest extends BaseTestClass {
	
	LoginPage loginPage;
	Optimised_AwsDriveCopyFunctionality OAWSS3;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        OAWSS3 = new Optimised_AwsDriveCopyFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromAWSToOtherDrives() {
		try {
			loginPage.loginMethod();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToOneDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
			
			OAWSS3.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			LoginPage login = new LoginPage(driver, wait);
//			login.loginMethod();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
