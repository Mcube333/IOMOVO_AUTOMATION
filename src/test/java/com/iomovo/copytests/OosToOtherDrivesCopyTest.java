package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.OosDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class OosToOtherDrivesCopyTest extends BaseTestClass {
	
	LoginPage loginPage;
	OosDriveCopyFunctionality Oracle;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Oracle = new OosDriveCopyFunctionality(driver, wait);
    }


	
	@Test
	public void verifyCopyFilesFunctionalityFromAWSToOtherDrives() {
		try {
			LoginPage login = new LoginPage(driver, wait);
			login.loginMethod();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToIoCloudDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToAwsDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToBoxDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToDropBoxDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToFTPDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToGoogleCloudDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToGoogleDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToMSAzureDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToOneDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToSftpDrive();
			
			Oracle.verifyCopyFilesFunctionalityFromOosToSharePointDrive();
			
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
