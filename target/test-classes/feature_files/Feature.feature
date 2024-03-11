Feature: Identifying new bikes


  Scenario: Displaying upcoming bike details and popular car models 
    Given Launching the zigwheels website
    When Selecting upcoming bikes from new bikes menu
    When Selecting Honda in the manufacturer dropdown
    Then Printing all upcoming honda bikes under 4 Lakhs  
  	When Navigating back to homepage
  	Then Selecting Chennai under the used cars menu
  	Then Printing all the popular models 
  	When Again Navigating back to homepage
  	Then Clicking on Login button and selecting Google as login option
  	When Entering an invalid email and clicking next
  	Then Printing the error message 
  	And Closing the browser