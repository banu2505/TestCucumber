#Author: Banupriya
@tag
Feature: To test add new customer functionality

  @tag2
  Scenario Outline: To add new customers
    Given The user is in Guru home page
    And The user logged in as manager
      | mngrid     | mngrpass |
      | mngr154050 | zamynEs  |
    And The user navigates to new customer page
    When The user enters the customer details with "<custname>","<gender>","<dob>","<address>","<city>","<state>","<pin>","<phnum>","<email>","<pass>"
    And The user submits the form
    Then The user should see the success message

    Examples: 
      | custname   | gender | dob        | address | city    | state | pin    | phnum      | email           | pass    |
      | testuser  | female | 11/11/2000 | test    | chennai | tn    | 600119 | 9123456780 | etest@gmail.com | test123 |
      | testuser | male   | 01/02/1989 | test123 | chennai | tn    | 600119 | 9123456780 | gtest@gmail.com | test456 |
