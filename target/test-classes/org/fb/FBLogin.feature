#Author: Banupriya
@tag
Feature: To test FB Login functionality

  @tag1
  Scenario: To verify error on entering invalid values
    Given The user is in facebook home page
    	|url|https://www.facebook.com/|
    When The user enters username and password
    	|email|password|
    	|greens@test.com|facebook|
    And The user clicks login button
    Then The user should see an error in a new page
