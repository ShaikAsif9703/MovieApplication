Feature:
  As a movie viewer
  i want to check the page
  and i made some requirements

  Scenario: logo
    Given I am on Home
    Then check logo

  Scenario: checking nav elements
    Given I am on Home
    Then check nav elements

  Scenario: getting nav elements
    Given I am on Home
    Then Navigated to home movies using home nav link

  Scenario: getting nav elements
    Given I am on Home
    Then Navigated to popular movies using popular nav link

  Scenario: Navigating to search page
    Given I am on Home
    Then Navigating to search page

  Scenario: getting account
    Given I am on Home
    Then checking account