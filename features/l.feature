Feature: Login
@sanity
Scenario: successful login with valid credentials
Given user launch chrome browser
When user opens url as "https://admin-demo.nopcommerce.com/login"
And user enters username as "admin@yourstore.com" and password as "admin"
And user clicks the login button
Then page title should be "Dashboard / nopCommerce administration"
When user click the logout button
Then Close the browser

@sanity
Scenario Outline: DDT
Given user launch chrome browser
When user opens url as "https://admin-demo.nopcommerce.com/login"
And user enters username as "<email>" and password as "<password>"
And user clicks the login button
Then page title should be "Dashboard / nopCommerce administration"
When user click the logout button
Then Close the browser

Examples:
|email|password|
|test1@yourstore.com|admin|
 

