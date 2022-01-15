Feature: Order related Testing
  Background: User is logged in and goes in Customers tab
    Given User launch chrome browser
    When User enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters emails as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then page title should be "Dashboard / nopCommerce administration"

    Scenario: User Wants to download summary of all orders
      Given User Clicks on Sales Main menu
      And Click on Orders on sub menu
      Then User scrolls Down the page
      And User looks all the PreRegistered Orders
      Then User Downloads the order summary in excel format