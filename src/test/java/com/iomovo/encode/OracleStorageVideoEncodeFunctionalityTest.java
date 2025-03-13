package com.iomovo.encode;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.EncodeFunctionality.OracleStorageVideoEncodeFunctionality;

public class OracleStorageVideoEncodeFunctionalityTest extends BaseClass {
	
	private LoginPage loginPage;
    private OracleStorageVideoEncodeFunctionality Oracle;

    /**
     * Setup method runs before each test.
     * Initializes WebDriver, logs in, and sets up required page objects.
     */
    @BeforeMethod
    public void setUp() {
        driver = getDriver(); // ✅ Use inherited WebDriver from BaseClass
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in DropBoxToIoHubMoveTest. Check BaseClass initialization.");
        }

        loginPage = new LoginPage(driver, getWait());
		Oracle = new OracleStorageVideoEncodeFunctionality(driver, getWait());

        performLogin(); // ✅ Ensures user is logged in before each test
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
    public void verifyVideoEncodeFunctionalityTo1080pInOracleDrive() throws Exception {
        Oracle.VerifyVideoEncodeFunctionalityto1080pinOraleDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo720pInOracleDrive() throws Exception {
        Oracle.VerifyVideoEncodeFunctionalityto720pinOraleDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo480pInOracleDrive() throws Exception {
        Oracle.VerifyVideoEncodeFunctionalityto480pinOraleDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo360pInOracleDrive() throws Exception {
        Oracle.VerifyVideoEncodeFunctionalityto360pinOraleDrive();
    }

    @Test
    public void verifyVideoEncodeFunctionalityTo240pInOracleDrive() throws Exception {
        Oracle.VerifyVideoEncodeFunctionalityto240pinOraleDrive();
    }
}
