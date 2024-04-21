Feature:
  As a movieApp user
  I want to check the website
  so that the images,logos are
  displayed or not

  Scenario: Checking the website logo
    Given I am on the movie login page
    Then I want to check app logo

  Scenario: checking the heading text is Login
    Given I am on the movie login page
    Then I check the movie page heading

  Scenario: checking the username label
    Given I am on the movie login page
    Then I check the username label

  Scenario: checking the password label
    Given I am on the movie login page
    Then I check the password label

  Scenario: checking the login button
    Given I am on the movie login page
    When  I click on the login button
    Then Error message will be displayed

  Scenario: login with empty input fields
    Given I am on the movie login page
    When I click on the login button
    Then Error message will be displayed

  Scenario: login with empty username
    Given I am on the movie login page
    When I entered the password input
    And I click on the login button
    Then Error message will be displayed

  Scenario: login with empty password
    Given I am on the movie login page
    When  I entered the username input
    And I click on the login button
    Then Error message will be displayed

  Scenario: login with incorrect credentials
    Given I am on the movie login page
    When I entered the username and password input
    And I click on the login button
    Then Error Message

  Scenario: successful login
    Given I am on the movie login page
    When I entered the inputs
    And I click on the login button
    Then return to home page