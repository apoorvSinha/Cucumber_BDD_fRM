Feature: Customer Modification
  Background: User is logged in and goes in Customers tab
     Given User launch chrome browser
     When User enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
     And User enters emails as "admin@yourstore.com" and password as "admin"
     And Click on login
     Then page title should be "Dashboard / nopCommerce administration"

   Scenario: User adds a customer role
     Given User clicks on customer main menu item
     And User clicks on Customer roles
     Then Pre registered customer roles are displayed
     Then User clicks on add new Item
     And User enters customer roles details
     When User clicks on save button
     Then User gets a message "The new customer role has been added successfully"

