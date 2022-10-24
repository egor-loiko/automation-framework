Feature: Work with Chat

  Scenario: Need help scenario
    Given Main page is loaded
    And Open Live Chat
    Then Live Chat is opened
    And Click Start Chat button
    Then Validation messages appear
    And Close Live Chat
    And Scroll down Home Page
    And Open Help Pages Link
    Then Wiggle Customer Services page is opened
    And Return to Home Page