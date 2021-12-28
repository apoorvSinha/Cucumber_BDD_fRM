Feature: Login
  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When user enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters emails as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then Page title should be "Your store. Login"
    And Close the browser
    
Scenario Outline: Login data driven
		Given User launch chrome browser
    When user enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And user enters emails as "<email>" and password as "<password>"
    And Click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then Page title should be "Your store. Login"
    And Close the browser
    
    Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin1@yourstore.com | admin123 |