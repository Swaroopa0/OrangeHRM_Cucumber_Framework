Feature: Login Data Driven



  Scenario Outline: Login Data Driven
    Given User launch Browser
    And opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user enters username as "<username>" and password as "<password>"
    And click on loginButton
    Then user navigates to Dashboard
    


    Examples: 
      | username  | password      | 
      | Admin     | admin123      | 
      | Admin     | admin123      | 