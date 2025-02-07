Feature:Login functionality scenarios
@Login @One
Scenario: Verify whether the user is able to login with valid credentials
    Given I launch the application
    And I naviage to Account Login page
	  When I login to the application using Username "ravi.kiran1@gmail.com" and Password "rkiran"
	  
      Then I should see that the User is able to successfully login
      @Login @Two
      Scenario: Verify whether the user is not  able to login with invalid credentials
    Given I launch the application
    And I naviage to Account Login page
	  When I login to the application using Username "ravi.kiran1@gmail.com" and Password "rkiran"
	 
      Then I should see an error message that the credentials are invalid
      
       @Login @Three
      Scenario: Verify whether the user is not  able to login without providing credentials
    Given I launch the application
    And I naviage to Account Login page
	  When I login to the application using Username "" and Password ""
	 
      Then I should see an error message that the credentials are invalid
      
      @Login @Four
      Scenario: Verify whether the user is   able to reset the forgotten password
    Given I launch the application
    And I naviage to Account Login page
	  When reset the forgotten password for email "ravi.kiran@gmail.com"
	 
      Then I should see a message informing the user that information related to resetting password have been sent to email address