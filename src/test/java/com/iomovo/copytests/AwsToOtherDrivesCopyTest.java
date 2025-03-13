package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class AwsToOtherDrivesCopyTest extends BaseClass {
	
	private LoginPage loginPage;
    private AwsDriveCopyFunctionality  AWSS3;
	
    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
    	driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in HomePageTopPanelTest. Check BaseTestClass initialization.");
        }

        loginPage = new LoginPage(driver, getWait());
        AWSS3 = new AwsDriveCopyFunctionality(driver, getWait());

        performLogin(); // Login before each test
    }

    /**
     * Perform login before executing test cases.
     */
    private void performLogin() {
        try {
            loginPage.loginMethod();
        } catch (Exception e) {
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }
	
    @Test
    public void verifyCopyFilesFunctionalityFromAWSToIoCloudDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToAWSDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToBoxDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToFTPDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToAzureDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToOneDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToOOSDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToOOSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
        AWSS3.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
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
