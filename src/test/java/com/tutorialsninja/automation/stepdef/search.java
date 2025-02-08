package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.SearchResultPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class search {
HeadersSection headerSection=new HeadersSection();
SearchResultPage searchResultPage=new SearchResultPage();
		@When("I search for a product {string}")
		public void i_search_for_a_product(String product) {
			Elements.TypeText(HeadersSection.searchBoxField,product);
			Elements.click(HeadersSection.searchButton);
		    
		}
		@Then("I should see the product in the search results")
		public void i_should_see_the_product_in_the_search_results() {
			Assert.assertTrue(Elements.isDisplayed(SearchResultPage.samsungSyncMasterSearchResult));
		    
		}

		

		@Then("I should see a message informing {string}")
		public void i_should_see_a_page_displaying_the_message(String message) {
		    Assert.assertTrue(Elements.VerifyTextEquals(SearchResultPage.noResultsMessage, message));
		}




}
