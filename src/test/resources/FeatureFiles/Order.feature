Feature: End to end scenarios for placing orders
	
	@Order @One
	Scenario: Verify whether user is able to place an orders
	  Given I login to the application 
	  When I add a product to Bag and checkout
	  And I place an order
	  Then I should see that the order is placed successfully