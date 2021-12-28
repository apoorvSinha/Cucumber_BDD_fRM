Feature: Customers

 Background: Below are the common steps for each scenario
		Given User launch chrome browser
		When user enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enters emails as "admin@yourstore.com" and password as "admin"
		And Click on login
		Then User can view Dashboard
#Scenario: Add a new customer
#		Given User launch chrome browser
#		When user enters URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
#		And user enters emails as "admin@yourstore.com" and password as "admin"
#		And Click on login
#		Then User can view Dashboard
#		When User click on customers menu
#		And click on customers menu item
#		And clcik on add new button
#		Then User can view Add new customer page
#		When User enters customer info
#		And click on save button
#		Then User can view confirmation message "The new customer has been added successfully"
#		Then Close the browser
			
			
Scenario: Search customer by EmailID
		
		When User click on customers menu
		And click on customers menu item
		And Enter customer Email
		When click on search button
		Then User should find Email in the search table
		Then Close the browser
		
Scenario: Search customer by Name
	
		When User click on customers menu
		And click on customers menu item
		And Enter customer FirstName
		And Enter customer LastName
		When click on search button
		Then User should find Name in the search table
		Then Close the browser
