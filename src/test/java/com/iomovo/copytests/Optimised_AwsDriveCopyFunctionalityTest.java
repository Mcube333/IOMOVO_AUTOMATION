package com.iomovo.copytests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.CopyFunctionality.Optimised_AwsDriveCopyFunctionality;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;


public class Optimised_AwsDriveCopyFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private Optimised_AwsDriveCopyFunctionality  OAWSS3;
	
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
        OAWSS3 = new Optimised_AwsDriveCopyFunctionality(driver, getWait());

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
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToIoCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToAWSDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToAWSDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToBoxDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToDropBoxDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToDropBoxDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToFTPDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleCloudDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToGoogleDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToGoogleDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToAzureDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToAzureDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToOneDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToOneDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToSFTPDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToSFTPDrive();
    }

    @Test
    public void verifyCopyFilesFunctionalityFromAWSToSharePointDrive() throws Exception {
        OAWSS3.verifyCopyFilesFunctionalityFromAWSToSharePointDrive();
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
