Feature: F01_Login | users could Login with accounts
  Scenario:Verify Login Function With Valid user and Password
    Given Open Login Page and Enter Valid User "visual_user"
    When Enter Password "secret_sauce"
    And Click on Login Button
    Then Enter To Home Page
  Scenario: Verify Login Function With Valid user and ivalidPassword
    Given Open Login Page and Enter Valid User "error_user"
    When Enter Password "invalidPassword"
    And Click on Login Button
    Then Login Failed
    And Validation Error Message Is Displayed
  Scenario: Verify Login Function With inValid user and Password
    Given Open Login Page and Enter Valid User "InvalidUser"
    When Enter Password "secret_sauce"
    And Click on Login Button
    Then Login Failed
    And Validation Error Message Is Displayed


