@smoke
Feature: Verify From Filter Function
  Background: Login function to enter to home page
    Given Login With "standard_user" and pass "secret_sauce"
    Scenario: verify filter with price
      When select filter product with low pice to hight price
      And filter with high price to low price

