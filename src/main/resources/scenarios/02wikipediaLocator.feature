@Wikipedia
Feature: First Test - Wikipedia
  @WikipediaLocators
  Scenario: Locators with Wikipedia
    Given I open browser to webpage "wikipedia.org"
    Then I wait "30" seconds to see the text "The Free Encyclopedia"
    Then I enter "Apple" to "search.field"
    Then I wait for "3" seconds
    Then I click on "search.btn"
    Then I wait "30" seconds to see the text "fruit"






