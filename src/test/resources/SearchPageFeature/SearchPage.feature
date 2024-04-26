Feature:
  As a user of website
  I want to login into account
  and I want to search the movie names

  Scenario: searching movies
    Given Home page
    When I click on search logo
    And I entered the movie name
    Then movie list will be displayed

  Scenario: Movies Not Found
    Given Home page
    When I click on search logo
    And I entered the movie name of spiderman
    Then No movies found should be displayed