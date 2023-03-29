
Feature: OrangeHRM Application
  I want to use this template for my feature file

  @sanity
  Scenario: Login with valid credentials
    Given User launch Browser
    And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user enters username as "Admin" and password as "1234"
    And click on loginButton
    Then user navigates to Dashboard

  