Feature: Get all logs of the system
  Background: User is logged in and goes in Systems tab
    Given User launch chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters emails as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then page title should be "Dashboard / nopCommerce administration"

    Scenario Outline: User analyzes log tables to see different types of logs
      Given User clicks on System on main menu
      And User cliks on log menu of SubMenu
      Then User selects the log level with "<log Level options>"
      And User scrolls multiple pages for all alerts
      Then User closes the browser

      Examples:
        |log level options|
        |Debug            |
        |Information      |
        |Warning          |
        |Error            |
        |Fatal            |
