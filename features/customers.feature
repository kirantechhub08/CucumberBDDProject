Feature: Customer

Background: common for all steps
Given user launch chrome browser
When user opens url as "https://admin-demo.nopcommerce.com/login"
And user enters username as "admin@yourstore.com" and password as "admin"
And user clicks the login button
Then user can view dashboard
When user click on customers menu
And click on customers menu item


#Scenario: Add New Customer
#And click on Add new button
#Then user can view Add new customer page
#When user enetr customer info
#And click on save button
#Then user can view confirmation message "The new customer has been added successfully."
#And Close browser

Scenario: Search customer by Email
And Enter customer Email
When Click on search button
Then User should found Email in the search table
And Close browser









