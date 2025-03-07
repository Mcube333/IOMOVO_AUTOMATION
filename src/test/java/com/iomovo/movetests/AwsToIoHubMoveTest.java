package com.iomovo.movetests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.MoveFunctionality.AwsDriveMoveFunctionality;


public class AwsToIoHubMoveTest extends BaseTestClass {
	
	LoginPage loginPage;
	AwsDriveMoveFunctionality AWSS3;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        AWSS3 = new AwsDriveMoveFunctionality(driver, wait);
    }
	
	@Test
	public void verifyMoveFilesFunctionalityFromAWSToOtherDrives() {
		try {
			loginPage.loginMethod();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToIoCloudDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAwsToAwsDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToBOXDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToDropBoxDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToFTPDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToGoogleCloudDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToGoogleDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToAzureDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToOneDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToOOSDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToSFTPDrive();
			
			AWSS3.verifyMoveFilesFunctionalityFromAWSToSharePointDrive();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
