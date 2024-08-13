Feature: Demo feature

  Scenario: Verify 2 + 3 = 5
    Given I navigate to home page
    When the page title should be "Web 2.0 scientific calculator"
    And I press button TWO
    And I press button PLUS
    And I press button THREE
    And I press button EQUAL
    Then I open the history dropdown
    Then the result should be 5

  Scenario: Verify 10 - 2 = 8
    Given I navigate to home page
    When the page title should be "Web 2.0 scientific calculator"
    And I press button ONE
    And I press button ZERO
    And I press button MINUS
    And I press button TWO
    And I press button EQUAL
    Then I open the history dropdown
    Then the result should be 8

  Scenario: Verify (10 - 2) * 2 != 20
    Given I navigate to home page
    When the page title should be "Web 2.0 scientific calculator"
    And I press button LEFT_PARENTHESIS
    And I press button ONE
    And I press button ZERO
    And I press button MINUS
    And I press button TWO
    And I press button RIGHT_PARENTHESIS
    And I press button MULTIPLY
    And I press button TWO
    And I press button EQUAL
    Then I open the history dropdown
    Then the result should not be 20

  Scenario: Verify sin(30) = 0.5
    Given I navigate to home page
    When the page title should be "Web 2.0 scientific calculator"
    And I press button SIN
    And I press button THREE
    And I press button ZERO
    And I press button RIGHT_PARENTHESIS
    And I press button EQUAL
    Then I open the history dropdown
    Then the result should be 0.5
