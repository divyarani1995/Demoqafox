package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.Browser;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.framework.Waits;
import com.tutorialsninja.automation.pages.CheckoutPage;
import com.tutorialsninja.automation.pages.HeadersSection;
import com.tutorialsninja.automation.pages.LoginPage;
import com.tutorialsninja.automation.pages.OrderSuccessPage;
import com.tutorialsninja.automation.pages.SearchResultPage;
import com.tutorialsninja.automation.pages.ShoppingCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Order {
	HeadersSection headersSection=new HeadersSection ();
	LoginPage loginPage=new LoginPage();
	SearchResultPage searchResultPage=new SearchResultPage();
	ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
	CheckoutPage checkoutPage=new CheckoutPage();
	OrderSuccessPage orderSuccessPage=new OrderSuccessPage();
		@Given("I login to the application")
		public void i_login_to_the_application() {
		   Browser.openApplicationURL();
		   HeadersSection.navigateToLoginPage();
		   LoginPage.dologin();
		}
		@When("I add a product to Bag and checkout")
		public void i_add_a_product_to_bag_and_checkout() {
		  HeadersSection.searchProduct();
		 SearchResultPage.addFirstProductInTheSearchResultToCart();
		HeadersSection.navigateToShoppingCartPage();
		ShoppingCartPage.navigateToCheckoutPage();
		}
		@When("I place an order")
		public void i_place_an_order() {
		   CheckoutPage.placeAnOrder();
		}
		@Then("I should see that the order is placed successfully")
		public void i_should_see_that_the_order_is_placed_successfully() {
			
		    	Assert.assertTrue(Elements.isDisplayed(OrderSuccessPage.successBreadcrumb));
		}




}
