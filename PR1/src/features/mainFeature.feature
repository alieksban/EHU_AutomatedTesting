Feature: Checking Parabank Feature

  Scenario: Validating Returning From Forgot login info
    Given User is on Parabank site
    When User presses Forgot login info button
    Then Customer Lookup shows correctly
    When User presses Home button
    Then Main page shows correctly
