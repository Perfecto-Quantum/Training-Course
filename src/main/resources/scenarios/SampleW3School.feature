@W3
Feature: First Assignment - Wikipedia

  Scenario: apple page on Wikipedia
    Given I open browser to webpage "w3schools.com"
    Then I wait "30" seconds to see the text "the language"
    Then I click on "//*[text()="LEARN HTML"]"
    Then I wait "30" seconds to see the text "with html you can create"





