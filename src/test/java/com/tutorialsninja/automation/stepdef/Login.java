package com.tutorialsninja.automation.stepdef;

import org.junit.Assert;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.ForgotPasswordPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.MyAccountPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login { 
	HeadersSection headersSection=new HeadersSection();
	LoginPage loginPage=new LoginPage();
	MyAccountPage myAccountPage=new MyAccountPage();
	ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage();
	@Given("I naviage to Account Login page")
public void i_naviage_to_account_login_page() {
    
Elements.click(HeadersSection.myAccountLink);
Elements.click(HeadersSection.login);
	}
@When("I login to the application using Username {string} and Password {string}")
public void i_login_to_the_application_using_username_and_password(String email, String password) {
   LoginPage.dologin(email, password);
}


@Then("I should see that the User is able to successfully login")
public void i_should_see_that_the_user_is_able_to_successfully_login() {
	Assert.assertTrue(Elements.isDisplayed(MyAccountPage.registerAffiliateAccount));
    
}
@Then("I should see an error message that the credentials are invalid")
public void i_should_see_an_error_message_that_the_credentials_are_invalid() {
	Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning,"Warning: No match for E-Mail Address and/or Password."));
}

@When("reset the forgotten password for email {string}")
public void reset_the_forgotten_password_for_email(String email) {
	Elements.click(LoginPage.forgetPassword);
    Elements.TypeText(ForgotPasswordPage.emailField, email);
    Elements.click(ForgotPasswordPage.continueButton);
}





@Then("I should see a message informing the user that information related to resetting password have been sent to email address")
public void i_should_see_a_message_informing_the_user_that_information_related_to_resetting_password_have_been_sent_to_email_address() {
	Assert.assertTrue(Elements.VerifyTextEquals(LoginPage.mainWarning,"An email with a confirmation link has been sent your email address."));
	
}
}





