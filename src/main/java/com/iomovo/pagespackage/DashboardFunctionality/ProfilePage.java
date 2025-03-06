package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class ProfilePage extends BaseClass{

	WebDriver driver;
	WebDriverWait wait;

	public ProfilePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// All X-paths after clicking the PROFILE BUTTON.
	String profileButtonLink = "//button[@aria-label='Profile']";
	String signoutButtonLink = "//a[contains(text(),'Sign out')]";
	String logoutSuccessLink = "//form[@id='localAccountForm']//following::div[@class='intro']";
	String viewAccountButtonLink = "//a[contains(text(),'View Account')]";
	String accountViewDetailsConfirmation = "//h6/b[text()='Account Details']";

	String viewAccountButtonLink_GeneralButton = "//span[text()='General']";
	String viewAccountButtonLink_PlanlButton = "//span[text()='Plan']";
	String viewAccountButtonLink_MarketplaceButton = "//span[text()='Marketplace']";
	String viewAccountButtonLink_BillingButton = "//span[text()='Billing']";
	String viewAccountButtonLink_ActivitiesButton = "//span[text()='Activities']";
	String viewAccountButtonLink_ConnectorsButton = "//span[text()='Connectors']";
	String viewAccountButtonLink_SchedulerButton = "//span[text()='Scheduler']";
	String viewAccountButtonLink_PreferencesButton = "//span[text()='Preferences']";

	String viewAccountGeneralPageButton = "//span[text()='General']";
	String viewAccountPlanPageButton = "//span[text()='Plan']";
	String viewAccountPlanPageConfirmation = "//h6/b[text()='Plan Details']";
	String viewAccountMarketplacePageButton = "//span[text()='Marketplace']";
	String viewAccountMarketplacePageConfirmation = "//h6/b[text()='Marketplace']";
	String viewAccountBillingPageButton = "//span[text()='Billing']";
	String viewAccountBillingPageConfirmation = "//h6/b[text()='Billing']";
	String viewAccountActivitiesPageButton = "//span[text()='Activities']";
	String viewAccountActivitiesPageConfirmation = "//h6/b[text()='Activites']";
	String viewAccountSchedulerPageButton = "//span[text()='Scheduler']";
	String viewAccountSchedulerPageConfirmation = "//h6/b[text()='Scheduler']";
	String viewAccountConnectorsPageButton = "//span[text()='Connectors']";
	String viewAccountConnectorsPageConfirmation = "//h6/b[text()='Active Connectors']";
	String viewAccountSiteAdministrationPageButton = "//span[text()='Site Administration']";
	String viewAccountSiteAdministrationConfirmation = "//h6/b[text()='Site Administration']";
	String viewAccountUsersPageButton = "//span[text()='Users']";
	String viewAccountUsersPageConfirmation = "//h6/b[text()='Users List']";
	String viewAccountGroupsPageButton = "//span[text()='Groups']"; 
	String viewAccountGroupsPageConfirmation = "//h6/b[text()='Groups']";

	String supportButtonLink = "//a[text()='Support']";
	String supportPageDivTitleLabel = "//div[contains(text(),'ioMoVo Customer Support')]";

	String switchAccountButtonLink = "//a[contains(text(),'Switch Account')]";
	String PersonalAccountStatus = "//div[text()='ioMoVo Personal - Professional']";
	String TeamAccountStatus = "//div[text()='AutoTestTeam']";
	String accountSwitchingButton = "//Button[@id='custom-btn-Switch']";

	String signInWithDifferentAccountLInk = "//a[text()='Sign in with different account']";
	String settingsButton = "//button[@aria-label='Settings']";
	String settingsPage = "//h6[text()='Account Detail']";

	String settingsPageViewAccountGeneralButton = "//span[text()='General']";
	String viewAccountUploadProfilePictureButton = "//span[@aria-label='Upload Picture']";
	String viewAccountUploadProfilePictureButtonSuccessStatus = "//div[text()='Image Successfully Changed']";
	String viewAccountDeleteProfilePictureButton = "//span[@aria-label='Delete Picture']";
	String viewAccountNoPictureConfirmation = "//div[@class='MuiAvatar-root MuiAvatar-circle MuiAvatar-colorDefault']";
	String viewAccountUploadProfilePictureButtonDeleteStatus = "//div[text()='Image Successfully Deleted']";
	String viewAccountTakePictureButton = "//span[@aria-label='Take Picture']";
	String viewAccountClickPictureButton = "//span[text()='Take Picture']";
	String viewAccountUploadPictureButton = "(//span[@role='button' and @variant='outlined'])[2]"; 
	String viewAccountUpdatePictureButton = "//span[text()='Update Picture']";

	String viewAccountEditProfileDetailsButton = "//span[text()='Edit Profile Details']";
	String viewAccountFirstNameTextBoxID = "(//input[@type='text'])[2]";
	String viewAccountLastNameTextBoxID = "(//input[@type='text'])[3]";
	String viewAccountPhoneNumberTextBoxID = "//input[@type='tel']";
	String viewAccountSelectCountryButton = "//Button[@aria-label='Select country']";
	String viewAccountDailCode = "//span[text()='India']";
	String viewAccountEditAddressDetailsButton = "//span[text()='Edit Address Details']";
	String viewAccountAddress1TextBox = "//input[@id='address1']";
	String viewAccountAddress2TextBox = "//input[@id='address2']";
	String viewAccountCityTextBox = "//input[@id='city']";
	String viewAccountStateTextBox = "//input[@id='state']";
	String viewAccountZipTextBox = "//input[@id='postalCode']";
	String viewAccountCountryCodeDropdownButton = "//button[@aria-label='Select country']";
	String viewAccountCountry = "//li[@data-country-code='in']";
	String profileUpdateConfirmation = "//div[text()='Profile Successfully Updated']";
	String addressUpdateConfirmation = "//div[text()='Billing Address Successfully Updated']";
	String viewAccountCountryTextBox = "//input[@id='controllable-states-demo']";
	String viewAccountClearCountryTextBox = "(//button[@title='Clear'])[2]";
	String viewAccountSaveButton = "//span[text()='Save']";
	String accountDeactivateButton = "//span[text()='Deactivate Account']";
	String accountDeactivateConfirmation = "//h4[contains(text(),'deactivated')]";

	// All other Variables
	String pictureFilesPath = projectDirectory + "\\FilesToUpload\\PicturesFiles\\";
	String pictureFileName = "ProfilePicture.jpg";

	// All Variables which fetches data from config.properties file
	String strUrl = prop.getProperty("strUrl");
	String strUsername = prop.getProperty("strUsername");
	String strPasword = prop.getProperty("strPasword");
	String strfirstname = prop.getProperty("strfirstname");
	String strlastname = prop.getProperty("strlastname");
	String strnumber = prop.getProperty("strnumber");
	String address1 = prop.getProperty("address1");
	String address2 = prop.getProperty("address2");
	String city = prop.getProperty("city");
	String state = prop.getProperty("state");
	String zipcode = prop.getProperty("zipcode");
	String country = prop.getProperty("country");

	public void verifyUserAbleToSignOutFromCurrentAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Visible And Clicked Successfully");
			clickWebElement(signoutButtonLink);
			logPassStepInExtentReportWithScreenshot("Sign Out Button Visible And Clicked Successfully");
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(logoutSuccessLink)) {
				logPassStepInExtentReportWithScreenshot("Redirected To Login Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Login Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToSignOutFromCurrentAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToViewAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Clicked Successfully");
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(accountViewDetailsConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Redirected To User Account Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To User Account");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToViewAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToSupportPageFromProfileTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Clicked Successfully");
			clickWebElement(supportButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("Support Button Clicked Successfully");
			explicitWaitInSeconds(5);
			swithToWindowBasedOnTitle("ioMoVo Customer Support | Knowledge Base");

			if (isWebElementDisplayed(supportPageDivTitleLabel)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Support Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Support Page");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToSupportPageFromProfileTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithWebCamTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(viewAccountDeleteProfilePictureButton)) {
				logPassStepInExtentReportWithScreenshot("Image Already Uploaded. Attempting to Delete And Changing The Picture");
				clickWebElement(viewAccountDeleteProfilePictureButton);
				explicitWaitInSeconds(10);
				if (isWebElementDisplayed(viewAccountUploadProfilePictureButtonDeleteStatus)) {
					logPassStepInExtentReportWithScreenshot("Image Removed Successfully");
				}
			} else if (isWebElementDisplayed(viewAccountNoPictureConfirmation)) {
				logPassStepInExtentReportWithScreenshot("No Image Available To Remove");
			}
			isWebElementDisplayed(viewAccountUploadPictureButton);
			clickWebElement(viewAccountUploadPictureButton);
			logPassStepInExtentReport("clicking On Upload Button To Upload User Profile Image");
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountTakePictureButton);
			logPassStepInExtentReportWithScreenshot("Clicked On Take Picture Button And WebCam Started Successfully");
			clickWebElement(viewAccountTakePictureButton);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountClickPictureButton);
			explicitWaitInSeconds(3);
			logPassStepInExtentReport("User Image Clicked Successfully and Ready For Update");
			clickWebElement(viewAccountClickPictureButton);
			explicitWaitInSeconds(3);
			isWebElementDisplayed(viewAccountUpdatePictureButton);
			clickWebElement(viewAccountUpdatePictureButton);
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountUploadProfilePictureButtonSuccessStatus);
			logPassStepInExtentReportWithScreenshot("User Profile WebCam Image update Successfully ");
		} 
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountWithUploadImageTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(viewAccountDeleteProfilePictureButton)) {
				logPassStepInExtentReportWithScreenshot("Image Already Uploaded. Attempting to Delete And Upload A New Picture");
				clickWebElement(viewAccountDeleteProfilePictureButton);
				explicitWaitInSeconds(10);
				if (isWebElementDisplayed(viewAccountUploadProfilePictureButtonDeleteStatus)) {
					logPassStepInExtentReportWithScreenshot("Image Removed Successfully");
				}
			} else if (isWebElementDisplayed(viewAccountNoPictureConfirmation)) {
				logPassStepInExtentReportWithScreenshot("No Image Available To Remove");
			}
			isWebElementDisplayed(viewAccountUploadProfilePictureButton);
			clickWebElement(viewAccountUploadProfilePictureButton);
			logPassStepInExtentReport("clicking On Upload Button To Upload User Profile Image");
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountUploadPictureButton);
			logPassStepInExtentReportWithScreenshot("Clicked On Take Picture Button And Waiting for Image upload");
			clickWebElement(viewAccountUploadPictureButton);
			explicitWaitInSeconds(5);
			uploadFileUsingRobotClass(pictureFilesPath, pictureFileName);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("User Image Updated Successfully");
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountUploadProfilePictureButtonSuccessStatus);
			logPassStepInExtentReportWithScreenshot("User Profile Image uploaded Successfully ");
		}
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToDeleteOrChangeTheProfilePicFromUserAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(viewAccountEditProfileDetailsButton);
			logPassStepInExtentReport("Edit Profile Button Clicked Successfully");
			WebElement firstName  = uiElement(viewAccountFirstNameTextBoxID);
			firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountFirstNameTextBoxID, strfirstname);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the FirstName Text Field");
			explicitWaitInSeconds(5);
			WebElement lastName = uiElement(viewAccountLastNameTextBoxID);
			lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountLastNameTextBoxID, strlastname);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the LastName Text Field");
			explicitWaitInSeconds(5);
			clickWebElement(viewAccountCountryCodeDropdownButton);
			explicitWaitInSeconds(5);
			clickWebElement(viewAccountCountry);
			explicitWaitInSeconds(3);
			setTextInTextField(viewAccountPhoneNumberTextBoxID, strnumber);
			logPassStepInExtentReport("Selected the desired Country and Entered the Phone Number");
			explicitWaitInSeconds(3);
			clickWebElement(viewAccountSaveButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("Successfully Updated the Profile Details From User Account");
			if (isWebElementDisplayed(profileUpdateConfirmation)) {
				logPassStepInExtentReport("Successfully Updated the Profile Details From User Account");
			} else {
				logPassStepInExtentReport("Profile Updated Failed");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToUpdateTheProfileDetailsFromUserAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(viewAccountEditAddressDetailsButton);
			logPassStepInExtentReport("Edit Address Button Clicked Successfully");
			WebElement address1Feild  = uiElement(viewAccountAddress1TextBox);
			address1Feild.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountAddress1TextBox, address1);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the Address1 Text Field");
			explicitWaitInSeconds(3);
			WebElement address2Feild = uiElement(viewAccountAddress2TextBox);
			address2Feild.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountAddress2TextBox, address2);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the Address2 Text Field");
			explicitWaitInSeconds(3);
			WebElement cityFeild  = uiElement(viewAccountCityTextBox);
			cityFeild.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountCityTextBox, city);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the city Text Field");
			explicitWaitInSeconds(3);
			WebElement stateFeild  = uiElement(viewAccountStateTextBox);
			stateFeild.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountStateTextBox, state);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the state Text Field");
			explicitWaitInSeconds(3);
			WebElement zipCodeFeild  = uiElement(viewAccountZipTextBox);
			zipCodeFeild.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountZipTextBox, zipcode);
			logPassStepInExtentReport("Cleared the Old Data and Entered The New Data in the zipcode Text Field");
			explicitWaitInSeconds(3);
			WebElement countryInput = uiElement(viewAccountCountryTextBox); 
			countryInput.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			setTextInTextField(viewAccountCountryTextBox,country);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Selected the desired Country");
			explicitWaitInSeconds(5);
			clickWebElement(viewAccountSaveButton);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("Successfully Updated the Address Details From User Account");
			if (isWebElementDisplayed(addressUpdateConfirmation)) {
				logPassStepInExtentReport("Successfully Updated the Billing Address Details From User Account");
			} else {
				logPassStepInExtentReport("Billing Address Updated Failed");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed In verifyUserAbleToUpdateTheAddressDetailsFromUserAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsAbleToDeactivateAccountTestTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("View Account Link Clicked Successfully");
			clickWebElement(accountDeactivateButton);
			logPassStepInExtentReportWithScreenshot("Deactivation Button clicked Successfully");

			if (isWebElementDisplayed(accountDeactivateConfirmation)) {
				logPassStepInExtentReportWithScreenshot("User Account Deactivated Successfully");
			} else {
				logFailStepInExtentReport("Failed To Deactivate The User Account");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsAbleToDeactivateTheUserAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToSwitchAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			explicitWaitInSeconds(5);

			if (isWebElementDisplayed(PersonalAccountStatus)) {
				logPassStepInExtentReportWithScreenshot("User is Currently Logged in with Personal IoMoVo Account ");

				clickWebElement(profileButtonLink);
				explicitWaitInSeconds(3);
				clickWebElement(switchAccountButtonLink);
				logPassStepInExtentReport("Clicked on Switch Account Successfully");
				explicitWaitInSeconds(5);

				if (isWebElementDisplayed(accountSwitchingButton)){
					explicitWaitInSeconds(5);
					logPassStepInExtentReportWithScreenshot("Clicking On Switch Button / Switching To IoMoVo Team Account ");
					clickWebElement(accountSwitchingButton);
					explicitWaitInSeconds(10);
					isWebElementDisplayed(TeamAccountStatus);
					logPassStepInExtentReportWithScreenshot("User Successfully Switched To IoMoVo Team Account ");
				} else {
					logFailStepInExtentReport("Failed To Switch Account");
					assertTrue(false);
				}
			} else if (isWebElementDisplayed(TeamAccountStatus)) {
				logPassStepInExtentReportWithScreenshot("User is Currently Logged in with IoMoVo Team Account ");

				clickWebElement(profileButtonLink);
				explicitWaitInSeconds(3);
				clickWebElement(switchAccountButtonLink);
				logPassStepInExtentReport("Clicked on Switch Account Successfully");
				explicitWaitInSeconds(5);

				if (isWebElementDisplayed(accountSwitchingButton)){
					explicitWaitInSeconds(5);
					logPassStepInExtentReportWithScreenshot("Clicking On Switch Button / Switching To ioMoVo Personal Account ");
					clickWebElement(accountSwitchingButton);
					explicitWaitInSeconds(10);
					isWebElementDisplayed(PersonalAccountStatus);
					logPassStepInExtentReportWithScreenshot("User Successfully Switched To IoMoVo Personal Account ");
				} else {
					logFailStepInExtentReport("Failed To Switch Account");
					assertTrue(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToSwitchAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserAbleToSignInFromDifferentAccountTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Visible And Clicked Successfully");
			explicitWaitInSeconds(5);
			clickWebElement(signInWithDifferentAccountLInk);
			logPassStepInExtentReportWithScreenshot("Different Account SignIn Link Visible And Clicked Successfully");

			if (isWebElementDisplayed(logoutSuccessLink)) {
				logPassStepInExtentReportWithScreenshot("Redirected To Login Page Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Login Page");
				assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserAbleToSignInFromDifferentAccountTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest() throws Exception {
		try {
			logConsoleOutputMessage("strUrl: " + strUrl);
			refreshWebPage();
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Clicked Successfully");
			clickWebElement(viewAccountButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("View Account Button Clicked Successfully");
			explicitWaitInSeconds(5);
			isWebElementDisplayed(viewAccountGeneralPageButton);
			if (isWebElementDisplayed(accountViewDetailsConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Redirected To View Account Sucessfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To View Account");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountPlanPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountPlanPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Plan Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Plan Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountMarketplacePageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountMarketplacePageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Marketplace Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Marketplace Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountBillingPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountBillingPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Billing Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Billing Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountActivitiesPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountActivitiesPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Activities Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Activities Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountConnectorsPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountConnectorsPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Connectors Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Connectors Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountSchedulerPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountSchedulerPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Scheduler Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Connectors Page");
				assertTrue(true);
			}
			
			explicitWaitInSeconds(3);

			clickWebElement(viewAccountSiteAdministrationPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountSiteAdministrationConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Site Administration Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Site Administration Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountUsersPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountUsersPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Users Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Users Page");
				assertTrue(true);
			}

			explicitWaitInSeconds(3);

			clickWebElement(viewAccountGroupsPageButton);
			explicitWaitInSeconds(3);
			if (isWebElementDisplayed(viewAccountGroupsPageConfirmation)) {
				logPassStepInExtentReportWithScreenshot("Navigated To Groups Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Groups Page");
				assertTrue(true);
			}	

		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToOtherTabsPageFromViewAccountPageTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
}


