Feature: Filtration Save

  Scenario: Switching between categories
    Given I am on the site's main page
    When I click on Allow Cookies button
    And I click on Swim Category
    And I click on New In filter category
    And I click on Home Page
    And I click on Swim Category
    Then The New In filter is turned on