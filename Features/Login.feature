Feature: Login
  Scenario: Successful login with valid credentials
    Given User launch chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters emails as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on Logout link
    Then Page title should be "Your store. Login"
    And Close the browser