#Author: Banupriya

@tag
Feature: To test login functionality
  @tag1
  Scenario: To test reset button
    Given The user is in Guru home page
    When The user enters user id and password
    |username|password|
    |user1|pass1|
    |user2|pass2|
    And The user clicks reset button
    Then The user should see the fields cleared

