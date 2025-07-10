
Feature: Login
  @Login
  Scenario: Successful login
    Given the user is on the website
    When the user enter their credentials and click the submit button
    Then the user see the validation message
