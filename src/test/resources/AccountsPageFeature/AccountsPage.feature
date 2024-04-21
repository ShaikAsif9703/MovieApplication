Feature:
  As a user of movie website
  I want to login into account
  and I want to check the account page

  Scenario: Testing the UI elements
    Given I in Home
    When I click on account logo
    Then I look the elements

  Scenario: checking logoutButton
    Given I in Home
    When I click on account logo
    Then click logout button