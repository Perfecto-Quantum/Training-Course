@calculator
Feature: Quantum Training

  @calculator
  Scenario: Using Locators
    Given I start application by name "Calculator"
    And I am using an AppiumDriver
    Then I click on "btn.01"
    Then I click on "btn.add"
    Then I click on "btn.09"
    Then I click on "btn.equal"

    @somethingElse
  Scenario: whatever