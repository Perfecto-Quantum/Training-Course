@Wikipedia
Feature: First Test - Wikipedia
  @WikipediaApple
  Scenario: apple page on Wikipedia
    Given I open browser to webpage "wikipedia.org"
    Then I wait "30" seconds to see the text "The Free Encyclopedia"
    Then I enter "Apple" to "//*[@id='searchInput']"
    Then I wait for "3" seconds
    Then I click on "//*[@class="pure-button pure-button-primary-progressive"]"
    Then I wait "30" seconds to see the text "fruit"









