package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AwsToOtherDrivesCopyTest extends BaseTestClass 
{
	LoginPage loginPage;
	AwsDriveCopyFunctionality AWSS3;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        AWSS3 = new AwsDriveCopyFunctionality(driver, wait);
    }
	
	@Test
	public void verifyCopyFilesFunctionalityFromAWSToOtherDrives() {
		try {
			loginPage.loginMethod();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToOneDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToOOSDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
			
			AWSS3.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//	@Test
//	public void verifyErasingTheCopiedDataSucccessfullyFromIoHubDrives2() {
//		try {
//			loginPage.loginMethod();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
