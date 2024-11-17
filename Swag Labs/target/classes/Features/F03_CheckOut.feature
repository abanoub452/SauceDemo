@smoke
Feature: Verify From Checkout Function
  Background: Login function to enter to home page
   Given Login With "standard_user"
  #First Scenario to test checkout without add any item
  Scenario:verify checkout
    Given open cart after add item to cart
    When click checkout Button
    And Enter first name "first name"
    And Enter last name "last name"
    And Enter postal code "postal code"
    And click on continue button
    And Check order details
    And click on finish Button
    Then confirmation message is display
  #Secound Scenario to test checkout without add any item
  Scenario: test checkout without add any item
    Given open cart Without add item
    When click checkout Button
    And Enter first name "first name"
    And Enter last name "last name"
    And Enter postal code "postal code"
    And click on continue button
    And Check order details
    And click on finish Button
    Then confirmation message is display

