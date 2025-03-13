package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;
import com.iomovo.pagespackage.DashboardFunctionality.ProfilePage;

public class ProfilePageTest extends BaseClass {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void setUp() {
        driver = getDriver(); // Fetch WebDriver from BaseClass
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null in ProfilePageTest. Check BaseClass initialization.");
        }
        loginPage = new LoginPage(driver, getWait());
        profilePage = new ProfilePage();

        performLogin(); // Perform login before each test
    }

    // Helper method to perform login before each test
    private void performLogin() {
        try {
            loginPage.loginMethod();
        } catch (Exception e) {
            Assert.fail("❌ Login failed before test execution. Exception: " + e.getMessage());
        }
    }

    @Test
    public void verifyUserAbleToSignOutFromCurrentAccountTest() {
        executeProfileTest("verifyUserAbleToSignOutFromCurrentAccountTest");
    }

    @Test
    public void verifyUserAbleToViewAccountTest() {
        executeProfileTest("verifyUserAbleToViewAccountTest");
    }

    @Test
    public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithWebCamTest() {
        executeProfileTest("verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithWebCamTest");
    }

    @Test
    public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithUploadImageTest() {
        executeProfileTest("verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithUploadImageTest");
    }

    @Test
    public void verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest() {
        executeProfileTest("verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest");
    }

    @Test
    public void verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest() {
        executeProfileTest("verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest");
    }

    @Test
    public void verifyUserIsAbleToDeactivateAccountTestTest() {
        executeProfileTest("verifyUserIsAbleToDeactivateAccountTestTest");
    }

    @Test
    public void verifyUserIsRedirectedToSupportPageFromProfileTest() {
        executeProfileTest("verifyUserIsRedirectedToSupportPageFromProfileTest");
    }

    @Test
    public void verifyUserAbleToSwitchAccountTest() {
        executeProfileTest("verifyUserAbleToSwitchAccountTest");
    }

    @Test
    public void verifyUserAbleToSignInFromDifferentAccountTest() {
        executeProfileTest("verifyUserAbleToSignInFromDifferentAccountTest");
    }

    @Test
    public void verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest() {
        executeProfileTest("verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest");
    }

    /**
     * Generic method to execute a profile test dynamically.
     * @param methodName The name of the test method to invoke
     */
    private void executeProfileTest(String methodName) {
        try {
            profilePage.getClass().getMethod(methodName).invoke(profilePage);
        } catch (Exception e) {
            Assert.fail("❌ Test failed: " + methodName, e);
        }
    }
}
