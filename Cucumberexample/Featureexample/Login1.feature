Feature: Login

 
  Scenario: Successful Login with valid Credentials
  
    Given User Launch chrome browser

    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout
    Then Page title should be "Your store. Login"
    And close browser
  
  Scenario Outline: Login Data Driven
  
    Given User Launch chrome browser

    When user opens URL "http://admin-demo.nopcommerce.com/login"
    And user enters email as "<email>" and password as "<password>"
    And click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout
    Then Page title should be "Your store. Login"
    And close browser
    
    
    Examples:
    | email | password |
    | admin@yourstore.com  | admin |
    | admin1@yourstore.com | admin123 |