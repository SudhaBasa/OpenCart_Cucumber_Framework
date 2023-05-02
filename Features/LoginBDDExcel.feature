Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
    Given User Launch Browser
    And Opens URL "http://localhost/opencart/opencart-4.0.2.1/upload"
    When User navigate to MyAccount menu
    And Click Login
    Then Check User navigates to MyAccount Page by passing Email and Password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
