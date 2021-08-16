Feature: Test Login

  Scenario Outline: Check for successful login with valid credentials
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the homepage

    Examples:
      | username | password |
      | Yuvi     | 12345    |
      | Manjeet  | 12345    |

  Scenario Outline: Check for unsuccessful login with invalid credentials
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then error message is shown

    Examples:
      | username | password |
      | Yuvi     | 1234    |


