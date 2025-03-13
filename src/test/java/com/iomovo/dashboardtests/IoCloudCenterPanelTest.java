package com.iomovo.dashboardtests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.iomovo.basepackage.BaseClass;
import com.iomovo.pagespackage.DashboardFunctionality.IoCloudCenterPanel;
import com.iomovo.pagespackage.DashboardFunctionality.LoginPage;

public class IoCloudCenterPanelTest extends BaseClass {
    
    private WebDriver driver;
    private LoginPage loginPage;
    private IoCloudCenterPanel ioCloud;

    /**
     * Setup method runs before each test to initialize WebDriver and log in.
     */
    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is null. Check BaseClass initialization.");
        }
        
        loginPage = new LoginPage(driver, getWait());
        ioCloud = new IoCloudCenterPanel(driver, getWait());

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

    // 🔹 IoCloud Functionality Tests
    
    @Test
    public void testAddFolder() throws Exception {
        ioCloud.verifyUserAbleToAddFolderFromIOCloudMyFilesFunctionalityTest("TestFolder");
    }

    @Test
    public void testAddProject() throws Exception {
        ioCloud.verifyUserAbleToAddProjectFromIOCloudMyFilesFunctionalityTest("AutoTestProject");
    }

    @Test
    public void testUploadMultipleDocuments() throws Exception {
        ioCloud.verifyUserAbleToUploadDocumentFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();
    }

    @Test
    public void testUploadMultipleAudioFiles() throws Exception {
        ioCloud.verifyUserAbleToUploadAudioFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();
    }

    @Test
    public void testUploadMultipleVideoFiles() throws Exception {
        ioCloud.verifyUserAbleToUploadVideoFileMultipleTimesFromIoCloudUploadSectionAndTakeCertainActionsTest();
    }

    @Test
    public void testCaptureImageWithoutAutoSync() throws Exception {
        ioCloud.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithoutAutoSyncTest();
    }

    @Test
    public void testCaptureImageWithAutoSync() throws Exception {
        ioCloud.verifyUserIsAbleToCaptureImageFromIoCloudCaptureSectionWithAutoSyncTest();
    }

    @Test
    public void testRecordVideoWithoutAutoSync() throws Exception {
        ioCloud.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithoutAutoSyncTest();
    }

    @Test
    public void testRecordVideoWithAutoSync() throws Exception {
        ioCloud.verifyUserIsAbleToRecordTheVideoFromIoCloudCaptureSectionWithAutoSyncTest();
    }

    @Test
    public void testZipAndUnzipFiles() throws Exception {
        ioCloud.verifyUserAbleToZipAndUnzipFilesFromIoCloudMyFiles();
    }

    @Test
    public void testSortRecords() throws Exception {
        ioCloud.verifyUserAbleToSortRecordsFromIoCloudMyFiles();
    }

    @Test
    public void testSwitchListAndGridView() throws Exception {
        ioCloud.verifyUserAbleToSwitchFilesToListAndGridViewFromIoCloudMyFiles();
    }

    @Test
    public void testRenameFile() throws Exception {
        ioCloud.verifyUserAbleToRenameFileFromIoCloudMyFiles();
    }

    @Test
    public void testRenameFolder() throws Exception {
        ioCloud.verifyUserAbleToRenameFolderFromIoCloudMyFiles();
    }

    @Test
    public void testDeleteFile() throws Exception {
        ioCloud.verifyUserAbleToDeleteFromIoCloudMyFiles();
    }
}