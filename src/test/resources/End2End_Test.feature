Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.

  Scenario: Customer place an order by purchasing an item from search
    Given user is on Home Page
    When user clicks on login button
    And user enter userName
    And user enter password
    And user logs in
    And correct user is logged in
