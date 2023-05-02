Feature: Login with Valid Credentials

#ctrl+Shift+f - to align format

@Sanity
Scenario: Successful Login with Valid Credentials
Given User Launch Browser
And Opens URL "http://localhost/opencart/opencart-4.0.2.1/upload"
When User Navigates to My Account menu
And click on Login
And User enters email as "sudhabasa8@gmail.com" and password as "test123"
And Click on Login button
Then User navigates to MyAccount Page
