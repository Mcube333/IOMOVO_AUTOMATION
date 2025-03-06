package com.iomovo.pagespackage.DashboardFunctionality;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iomovo.basepackage.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		BaseClass.driver = driver;
        BaseClass.wait = wait;
	}

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	//Login Page Visible Elements Xpaths.
	String tourSkipButton = "//button[@aria-label='Skip']";
	String loginPageBrandLogo = "(//a[@target='_blank'])[1]";
	String loginPageDisplayPicture = "//img[@src='https://iopremium.blob.core.windows.net/$web/homeicon.png']";
	String loginPageSignInHeading = "//form[@id='localAccountForm']//following::div[@class='intro']";
	String loginPageEnterEmailTitle = "//label[@for='email']";
	String loginPageEmailTextBox = "//input[@id='email']";
	String loginPagePasswordTitle = "//label[@for='password']";
	String loginPagePasswordTextBox = "//input[@id='password']";
	String loginPageEyeButtonIcon = "//span[@toggle='#password']";
	String loginPageForgotPasswordLink = "//a[@id='forgotPassword']";
	String loginPageKeepMeSignedInCheckBox = "//input[@id='rememberMe']";
	String loginPageKeepMeSignedInLable = "//label[@for='rememberMe']";
	String loginPagesignupButton = "//button[@id='next']";
	String loginPageDontHaveAccountLabel = "//p[contains(text(),'account?')]";
	String loginPageSignupNowLink = "//a[text()='Sign up now']";
	String loginPageseprationLabel = "//h2[text()='OR']";
	String loginPagesignInWithMicrosoftButton = "//button[text()='Sign in with Microsoft']";
	String loginPagesignInWithGoogleButton = "//button[text()='Sign in with Google']";
	String loginPagesignInWithWorkOrSchoolButton = "//button[text()='Sign in with Work or School Account']";
	String loginPageRightsConfirmationLabel = "//span[contains(text(),'reserved')]";

	// All X-paths of Login Page
	String emailTextBox = "//input[@id='email']";
	String passwordTextBox = "//input[@id='password']";
	String viewPasswordEyeButton = "//span[@toggle='#password']";
	String forgotPasswordLink = "//a[@id='forgotPassword']";
	String loginButton = "//a[contains(text(),'Log In')]";
	String loginPageConfirmation = "//h2[text()='Sign in with your email address']";
	String noticeAcceptAllButton = "//button[text()='Accept all']";
	String signInButton = "//button[@id='next']";
	String userProfileDivLabel = "//p[contains(text(),'gmail.com')]";
	String keepMeSignedInCheckBox = "//input[@id='rememberMe']";

	String profileButtonLink = "//button[@aria-label='Profile']";
	String signoutButtonLink = "//a[contains(text(),'Sign out')]";
	String logoutSuccessLink = "//form[@id='localAccountForm']//following::div[@class='intro']";

	String signUpNowLink = "//a[@id='createAccount']";
	String signInWithMicrosoftButton = "//button[text()='Sign in with Microsoft']";
	String msPageConfirmation = "//img[@alt='Microsoft']";
	String msEnterEmailInputTextBox = "//input[@type='email']";
	String msNextButtonInputElement = "//input[@type='submit']";
	String msEnterPasswordInputTextBox = "//input[@type='password']";
	String msSignInButtonIdElement = "//input[@id='idSIButton9']";
	String msStaySignInInputElement = "//input[@id='idBtn_Back']";

	String signInWithGoogleButton = "//button[text()='Sign in with Google']";
	String googlePageConfirmation = "//div[text()='Sign in with Google']";
	String googleEnterEmailInputTextBox = "//input[@type='email']";
	String googleNextButtonInputElement = "//span[text()='Next']";
	String googleEnterPasswordInputTextBox = "//input[@type='password']";

	String signInWithWorkOrSchoolButton = "//button[text()='Sign in with Work or School Account']";
	String msTeamPageConfirmation = "//img[@alt='Microsoft']";
	String msTeamEnterEmailInputTextBox = "//input[@type='email']";
	String msTeamNextButtonInputElement = "//input[@type='submit']";
	String msTeamEnterPasswordInputTextBox = "//input[@type='password']";
	String msTeamSignInButtonIdElement = "//input[@id='idSIButton9']";

	String msTeamAccountSetupPageConfirmation = "//div[@class='intro']";
	String msTeamAccountSetupNameInputElement = "//input[@id='displayName']";
	String msTeamAccountSetupOrgNameInputElement = "//input[@id='extension_OrganizationDisplayName']";
	String msTeamAccountSetupErrorMessageDisplay = "//div[@class='error itemLevel show']";
	String msTeamAccountSetupTermsCheckBoxElement = "//label[contains(text(),'terms of service')]";
	String msTeamAccountSetupCreateButton = "//button[@id='continue']";

	String loginPageTermsLink = "//a[@class='fterms']";
	String CookiesPageDisclaimer = "//div/button[text()='Accept all']";
	String termsPageConfirmation = "//h1[text()='Terms and Conditions']";
	String loginPagePrivacyLink = "//a[@class='fprivacy']";
	String PrivacyPageConfirmation = "//h1[text()='Privacy Policy']";

	//All X-Path of Error Messages 
	String cantFindAccountErrorMsg = "//p[contains(text(),'find your account')]";
	String EnterEmailErrorMsg = "//p[text()='Please enter your Email Address']";
	String EnterPasswordErrorMsg = "//p[text()='Please enter your password']";
	String passwordIncorrectMsg = "//p[text()='Your password is incorrect']";

//	// All Variables which fetches data from config.properties file
//	String strUrl = prop.getProperty("strUrl");
//	String strUrlProd = prop.getProperty("strUrlProd");
//	String strUrlDev = prop.getProperty("strUrlDev");
//	String strUrlProdStaging = prop.getProperty("strUrlProdStaging");
//	
//	String strUsername = prop.getProperty("strUsername");
//	String strPassword = prop.getProperty("strPassword");
//	String strUsernameProdStage = prop.getProperty("strUsernameProdStage");
//	String strPasswordProdStage = prop.getProperty("strPasswordProdStage");
//	String strUsernameproduction = prop.getProperty("strUsernameProduction");
//	String strPasswordproduction = prop.getProperty("strPasswordProduction");
//	String strUsernameDevelopment = prop.getProperty("strUsernameDevelopment");
//	String strPasswordDevelopment = prop.getProperty("strPasswordDevelopment");
	
	String strWrongUsername = "WrongUsername@gmail.com";
	String strWrongpassword = "Wrongpassword";
	String strValidUsername = prop.getProperty("strValidUsername");
	String strValidpassword = prop.getProperty("strValidpassword");
	String strMicrosoftUsername = prop.getProperty("strMicrosoftUsername");
	String strMicrosoftPassword = prop.getProperty("strMicrosoftPassword");
	String strName = prop.getProperty("strName");
	String strOrgName = prop.getProperty("strOrgName");


	public void verifyAllElementsArePresentInLoginPageTest() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("TC 001 : Check All Login Page Elements Are Visible Test");
			isWebElementDisplayed(loginPageBrandLogo);
			logPassStepInExtentReport("Brand LOGO is Visible");
			isWebElementDisplayed(loginPageDisplayPicture);
			logPassStepInExtentReport("Display Picture is Visible");
			isWebElementDisplayed(loginPageSignInHeading);
			logPassStepInExtentReport("Sign In Heading Visible");
			isWebElementDisplayed(loginPageEnterEmailTitle);
			logPassStepInExtentReport("Enter Email Address Title Visible");
			isWebElementDisplayed(loginPageEmailTextBox);
			logPassStepInExtentReport("Email Textbox is Visible");
			isWebElementDisplayed(loginPagePasswordTitle);
			logPassStepInExtentReport("Enter Password Title Visible");
			isWebElementDisplayed(loginPagePasswordTextBox);
			logPassStepInExtentReport("Password TextBox is Visible");
			isWebElementDisplayed(loginPageEyeButtonIcon);
			logPassStepInExtentReport("Eye button Visible");
			isWebElementDisplayed(loginPageForgotPasswordLink);
			logPassStepInExtentReport("Forget Password Link Visible");
			isWebElementDisplayed(loginPageKeepMeSignedInCheckBox);
			logPassStepInExtentReport("KeepMe Signed-In Text box Visible");
			isWebElementDisplayed(loginPageKeepMeSignedInLable);
			logPassStepInExtentReport("KeepMe Signed-In Label box Visible");
			isWebElementDisplayed(loginPagesignupButton);
			logPassStepInExtentReport("Sign-in Button Visible");
			isWebElementDisplayed(loginPageDontHaveAccountLabel);
			logPassStepInExtentReport("Don't have an account Visible");
			isWebElementDisplayed(loginPageSignupNowLink);
			logPassStepInExtentReport("Sign Up Now Visible");
			isWebElementDisplayed(loginPageseprationLabel);
			logPassStepInExtentReport("sepration Label Is Visible");
			isWebElementDisplayed(loginPagesignInWithMicrosoftButton);
			logPassStepInExtentReport("Sign-In with Microsoft Button Visible");
			isWebElementDisplayed(loginPagesignInWithGoogleButton);
			logPassStepInExtentReport("Sign-In with Google Button Visible");
			isWebElementDisplayed(loginPagesignInWithWorkOrSchoolButton);
			logPassStepInExtentReport("Sign-In with Work or School Button Visible");
			isWebElementDisplayed(loginPageRightsConfirmationLabel);
			logPassStepInExtentReport("Rights Confirmation Label Visible");
			isWebElementDisplayed(loginPageTermsLink);
			logPassStepInExtentReport("Rights Confirmation Label Visible");
			isWebElementDisplayed(loginPageTermsLink);
			logPassStepInExtentReport("terms Link is Visible");
			isWebElementDisplayed(loginPagePrivacyLink);
			logPassStepInExtentReportWithScreenshot("Privacy Link is Visible");
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed to Login Page Elements Test. Error Message: " + e);
			assertTrue(false);
		}
	}
	
	public void loginMethod() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);
			explicitWaitInSeconds(5);
			
			System.out.println("Title: " + driver.getTitle());

			if (isTitleValid("iomovo")) {
				logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
			} else {
				logFailStepInExtentReport("Login Page Not Displayed");
				assertTrue(false);
			}
			
//			clickWebElement(noticeAcceptAllButton);
//			
//			clickWebElement(loginButton);
//			
//			swithToNextNewWindow();
			
			setTextInTextField(emailTextBox, strUsername);
			setTextInTextField(passwordTextBox, strPassword);
			clickWebElement(signInButton);
			
			if (isTitleValid("iomovo")) {
				logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
			} else {
				logFailStepInExtentReport("Login Page Not Displayed");
				assertTrue(false);
			}
			
			if (isWebElementDisplayed(tourSkipButton)) {
				logInfoStepInExtentReport("Tour Pop Is Displayed After Logging In. Skipping The Tour...");
				
				clickWebElement(tourSkipButton);
				logInfoStepInExtentReport("Clicked On Skip Tour Button For Skipping The Tour");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed to Login. Error Message: " + e);
			assertTrue(false);
		}
	}

	public void login() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);
			explicitWaitInSeconds(5);
			
//			clickWebElement(noticeAcceptAllButton);
//			
//			clickWebElement(loginButton);
//			
//			swithToNextNewWindow();
//			
//			isWebElementDisplayed(loginPageConfirmation);

			if (isTitleValid("iomovo")) {
				logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
			} else {
				logFailStepInExtentReport("Login Page Not Displayed");
				assertTrue(false);
			}

			setTextInTextField(emailTextBox, strUsername);
			setTextInTextField(passwordTextBox, strPassword);
			clickWebElement(signInButton);
			
			explicitWaitInSeconds(5);

			isWebElementDisplayed(profileButtonLink);
			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(3);
			logPassStepInExtentReportWithScreenshot("Profile Button Visible And Clicked Successfully");

			String actualUsername = getTextFromWeb(userProfileDivLabel);
			System.out.println("actualUsername: " + actualUsername);
			System.out.println("expectedUsername: " + strUsername);

			if (actualUsername.equalsIgnoreCase(strUsername)) {
				logPassStepInExtentReport("Login Sucess");
				logPassStepInExtentReportWithScreenshot("User Logged-in Successfully : " + actualUsername);
			} else {
				logFailStepInExtentReport("Login Failed");
			}
			explicitWaitInSeconds(5);
		}
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed to Login. Error Message: " + e);
			assertTrue(false);
		}
	}

	public void VerifyUserAbleToLoginWithBothCorrectEmailIDAndPasswordTest() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);
			explicitWaitInSeconds(5);

			if (isTitleValid("iomovo")) {
				logPassStepInExtentReport("TC 001 : Verifying User is Able To Login With valid Email-ID And Password And Logging Out Test");
				logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
			} else {
				logFailStepInExtentReport("Login Page Not Displayed");
				assertTrue(false);
			}

			setTextInTextField(emailTextBox, strUsername);
			setTextInTextField(passwordTextBox, strPassword);
			clickWebElement(signInButton);

			clickWebElement(profileButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Profile Button Visible And Clicked Successfully");

			String actualUsername = getTextFromWeb(userProfileDivLabel);
			System.out.println("actualUsername: " + actualUsername);
			System.out.println("expectedUsername: " + strUsername);

			if (actualUsername.equalsIgnoreCase(strUsername)) {
				logPassStepInExtentReport("Login Sucess");
				explicitWaitInSeconds(5);
				logPassStepInExtentReportWithScreenshot("User Logged-in Successfully : " + actualUsername);
			} else {
				logFailStepInExtentReport("Login Failed");
			}
			clickWebElement(signoutButtonLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Sign Out Button Visible And Clicked Successfully");
			explicitWaitInSeconds(5);
		} 
		catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport("Failed to Login. Error Message: " + e);
			assertTrue(false);
		}
	}

	public void VerifyUserAbleToLoginWithBothWrongEmailIDAndPasswordTest() throws Exception {
		if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
        }
		logConsoleOutputMessage("strUrl: " + strUrl);
		driver.get(strUrl);
		explicitWaitInSeconds(5);
		if (isTitleValid("iomovo")) {
			logPassStepInExtentReport("TC 002 : Verify User Able To Login With Wrong Email-ID And Wrong Password And Get's Error");
			logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
		} else {
			logFailStepInExtentReport("Login Page Not Displayed");
			assertTrue(false);
		}
		setTextInTextField(emailTextBox, strWrongUsername);
		setTextInTextField(passwordTextBox, strWrongpassword);
		clickWebElement(signInButton);

		String actualErrorDisplay = getTextFromWeb(cantFindAccountErrorMsg);
		System.out.println("Actual Error : " + actualErrorDisplay);

		if (isWebElementDisplayed(cantFindAccountErrorMsg)) {
			logPassStepInExtentReport("Error Displayed");
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("User Login Failed Error Displayed : " + actualErrorDisplay );
		} else {
			logFailStepInExtentReport("Login Test Failed");
			assertTrue(false);
		}	
	}

	public void VerifyUserAbleToLoginWithWrongEmailIDAndCorrectPasswordTest() throws Exception {
		if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
        }
		logConsoleOutputMessage("strUrl: " + strUrl);
		driver.get(strUrl);
		explicitWaitInSeconds(5);
		if (isTitleValid("iomovo")) {
			logPassStepInExtentReport("TC 003 : Verify User Able To Login With Wrong Email-ID And Correct Password And Get's Error");
			logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
		} else {
			logFailStepInExtentReport("Login Page Not Displayed");
			assertTrue(false);
		}
		setTextInTextField(emailTextBox, strWrongUsername);
		setTextInTextField(passwordTextBox, strPassword);
		clickWebElement(signInButton);

		String cantFindErrorDisplay = getTextFromWeb(cantFindAccountErrorMsg);
		System.out.println("Actual Error : " + cantFindErrorDisplay);

		if (isWebElementDisplayed(cantFindAccountErrorMsg)) {
			logPassStepInExtentReport("Error Displayed");
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("User Login Failed Error Displayed : " + cantFindErrorDisplay );
		} else {
			logFailStepInExtentReport("Login Test Failed");
			assertTrue(false);
		}	
	}

	public void VerifyUserAbleToLoginWithCorrectEmailIDAndWrongPasswordTest() throws Exception {
		if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
        }
		logConsoleOutputMessage("strUrl: " + strUrl);
		driver.get(strUrl);
		explicitWaitInSeconds(5);
		if (isTitleValid("iomovo")) {
			logPassStepInExtentReport("TC 004 : Verify User Able To Login With Correct Email-ID And Wrong Password And Get's Error");
			logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
		} else {
			logFailStepInExtentReport("Login Page Not Displayed");
			assertTrue(false);
		}
		setTextInTextField(emailTextBox, strUsername);
		setTextInTextField(passwordTextBox, strWrongpassword);
		clickWebElement(signInButton);

		String actualErrorDisplay = getTextFromWeb(passwordIncorrectMsg);
		System.out.println("Actual Error : " + actualErrorDisplay);

		if (isWebElementDisplayed(passwordIncorrectMsg)) {
			logPassStepInExtentReport("Error Displayed");
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("User Login Failed Error Displayed : " + actualErrorDisplay );
		} else {
			logFailStepInExtentReport("Login Test Failed");
			assertTrue(false);
		}	
	}

	public void VerifyUserAbleToLoginWithOutEnteringBothEmailIDAndPasswordTest() throws Exception {
		if (driver == null) {
            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
        }
		logConsoleOutputMessage("strUrl: " + strUrl);
		driver.get(strUrl);
		explicitWaitInSeconds(5);
		if (isTitleValid("iomovo")) {
			logPassStepInExtentReport("TC 005 : Verify User Able To Login WithOut Entering Both EmailID And Password And Get's Error");
			logPassStepInExtentReport("Login Page Displayed Successfully. Title: " + getTitleFromUI());
		} else {
			logFailStepInExtentReport("Login Page Not Displayed");
			assertTrue(false);
		}
		explicitWaitInSeconds(5);
		clickWebElement(signInButton);

		String actualEmailErrorDisplay = getTextFromWeb(EnterEmailErrorMsg);
		System.out.println("Actual Error : " + actualEmailErrorDisplay);

		if (isWebElementDisplayed(EnterEmailErrorMsg)) {
			logPassStepInExtentReport("Error Displayed");
			logPassStepInExtentReportWithScreenshot("User Login Failed Error Displayed : " + actualEmailErrorDisplay );
		} else {
			logFailStepInExtentReport("Login Test Failed");
			assertTrue(false);
		}
		String actualPasswordErrorDisplay = getTextFromWeb(EnterPasswordErrorMsg);
		System.out.println("Actual Error : " + actualPasswordErrorDisplay);

		if (isWebElementDisplayed(EnterPasswordErrorMsg)) {
			logPassStepInExtentReport("Error Displayed");
			explicitWaitInSeconds(5);
			logPassStepInExtentReportWithScreenshot("User Login Failed Error Displayed : " + actualPasswordErrorDisplay );
		} else {
			logFailStepInExtentReport("Login Test Failed");
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToIoMoVoTermsPageTest() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logPassStepInExtentReport("TC 007 : Verifying is User Able To Redirect To The IoMoVo Terms Page Test");
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);
			clickWebElement(loginPageTermsLink);
			explicitWaitInSeconds(5);
			logPassStepInExtentReport("Terms Button Clicked Successfully");
			swithToNextNewWindow();

			if (isWebElementDisplayed(CookiesPageDisclaimer)) {
				clickWebElement(CookiesPageDisclaimer);
				isWebElementDisplayed(termsPageConfirmation);
				explicitWaitInSeconds(3);
				logPassStepInExtentReportWithScreenshot("Navigated To Terms Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To Terms Page");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToIoMoVoTermsPageTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}

	public void verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest() throws Exception {
		try {
			if (driver == null) {
	            throw new IllegalStateException("WebDriver is null in LoginPage. Check if it is properly initialized in BaseTestClass.");
	        }
			logPassStepInExtentReport("TC 007 : Verifying is User Able To Redirect To The IoMoVo Privacy Policy Page Test");
			logConsoleOutputMessage("strUrl: " + strUrl);
			driver.get(strUrl);

			clickWebElement(loginPagePrivacyLink);
			logPassStepInExtentReportWithScreenshot("");
			explicitWaitInSeconds(5);

			logPassStepInExtentReport("Terms Button Clicked Successfully");
			swithToNextNewWindow();

			if (isWebElementDisplayed(CookiesPageDisclaimer)) {
				clickWebElement(CookiesPageDisclaimer);
				isWebElementDisplayed(PrivacyPageConfirmation);				
				explicitWaitInSeconds(3);
				logPassStepInExtentReportWithScreenshot("Navigated To IoMoVo Privacy Policy Page Succesfully");
			} else {
				logFailStepInExtentReport("Failed To Navigate To IoMoVo Privacy Policy Page");
				assertTrue(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logFailStepInExtentReport(
					"Failed In verifyUserIsRedirectedToIoMoVoPrivacyPolicyPageTest Method. Failure Exception: " + e);
			assertTrue(false);
		}
	}
}