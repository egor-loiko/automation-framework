Feature: Login to site

  Scenario Outline: Sign in - Correct login and password
    Given Main page is loaded
    And Navigate to Login page
    And Enter email "<email_address>" in Sign in block
    And Enter password "<password>" in Sign in block
    When Click Sign in securely button in Sign in block
    Then Page Account is opened
    And Logout

    Examples:
      | email_address        | password |
      | some_email@gmail.com | 111111   |

  Scenario Outline: Sign in - Invalid credentials
    Given Main page is loaded
    And Navigate to Login page
    And Enter email "<email_address>" in Sign in block
    And Enter password "<password>" in Sign in block
    When Click Sign in securely button in Sign in block
    Then Invalid credentials validation message appears

    Examples:
      | email_address                | password |
      | some_email@gmail.com         | 222222   |
      | some_invalid_email@gmail.com | 111111   |

