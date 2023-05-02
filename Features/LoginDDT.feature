Feature: Login Data Driven

  #ctrl+Shift+f - to align format
  Scenario Outline: Login Data Driven
    Given User Launch Browser
    And Opens URL "http://localhost/opencart/opencart-4.0.2.1/upload"
    When User Navigates to My Account menu
    And click on Login
    And User enters email as "<email>" and password as "<password>"
    And Click on Login button
    Then User navigates to MyAccount Page

    Examples: 
      | email                | password |
      | sudhab@gmail.com     | test222  |
      | sudhabasa8@gmail.com | test123  |
