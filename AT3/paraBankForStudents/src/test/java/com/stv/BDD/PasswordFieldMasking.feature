Feature: Login Page Additional Test Cases

  Scenario: Password Field Masking
    Given I am on the site's login page
    When I click on Allow All button
    And I click on the password input field
    And I type "Test123" into the password field
    Then the characters should appear as masked