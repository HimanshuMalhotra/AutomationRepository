Feature: Online shopping
		 

	@test
	Scenario: Order a teshirt and verify orderid in order history
      Given user logs in to the application
      When user orders a teshirt
      Then orderId is displayed in order history

      @test
    Scenario: Update personal information in my account
        Given user logs in to the application
        When user edits user account details
        Then user details are updated



