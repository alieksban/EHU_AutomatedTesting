Feature: Login functionality

  Scenario Outline: Verify login with different inputs
    Given I am on the site's login page
    When I click on Allow All button
    And I click on the login input field
    And I type <login> into the login field
    And I click on the password input field
    And I type <password> into the password field
    And I click on the sign in button
    Then I should see <result>

      Examples:
        | login           | password | result          |
        | ""              | "pass"   | "no email"      |
        | "wrong@mail.ru" | ""       | "no password"   |
        | "wrong"         | "passw"  | "invalid email" |