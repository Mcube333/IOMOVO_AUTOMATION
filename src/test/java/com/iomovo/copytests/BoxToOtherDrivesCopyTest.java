package com.iomovo.copytests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basetest.BaseTestClass;
import com.iomovo.pagespackage.CopyFunctionality.BoxDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class BoxToOtherDrivesCopyTest extends BaseTestClass 
{
	LoginPage loginPage;
	BoxDriveCopyFunctionality Box;
     
	
    @BeforeMethod
    public void setUp() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null in IoCloudCenterPanelTest. Check BaseTestClass initialization.");
        }
        loginPage = new LoginPage();
        Box = new BoxDriveCopyFunctionality(driver, wait);
    }

	//These Below Methods are for Login Functionality tests

	
	@Test
	public void verifyCopyFilesFunctionalityFromBOXToOtherDrives() {
		try {
			loginPage.loginMethod();

			Box.verifyCopyFilesFunctionalityFromBOXToIoCloudDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToAWSDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToBOXDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToDropBoxDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToFTPDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToGoogleCloudDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToGoogleDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToAzureDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToOneDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToSFTPDrive();
			
			Box.verifyCopyFilesFunctionalityFromBOXToSharePointDrive();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

