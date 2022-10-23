Feature: Create new customer

  Scenario Outline: Create new customer - not existing user
    Given Main page is loaded
    And Navigate to Login page
    And Enter email "<email_address>" in New Customer block
    When Click Continue button
    Then Create New Account page is opened

    Examples:
      | email_address            |
      | some_email_new@gmail.com |

  Scenario Outline: Create new customer - existing user
    Given Main page is loaded
    And Navigate to Login page
    And Enter email "<email_address>" in New Customer block
    When Click Continue button
    Then User exists validation message appears

    Examples:
      | email_address        |
      | some_email@gmail.com |