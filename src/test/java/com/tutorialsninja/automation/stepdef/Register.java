package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;

import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
public class Register {

	
		// TODO Auto-generated method stub
		@Given("^I launch the application$")
		public void i_launch_the_application()  {
			Base.driver.get(Base.reader.getUrl());
		    
		}

		@And("^I navigate to Account Registration page$")
		public void i_navigate_to_Account_Registration_page()  {
		    
		}

		@When("^I provide all the below valid details$")
		public void i_provide_all_the_below_valid_details(DataTable dataTable)  {
		   
		}

		@And("^I select the Privacy Policy$")
		public void i_select_the_Privacy_Policy()  {
		    
		}

		@And("^I click on Continue button$")
		public void i_click_on_Continue_button()  {
		    
		}

		@Then("^I should see that the User Account has successfully created$")
		public void i_should_see_that_the_User_Account_has_successfully_created()  {
		   
		}


	}


