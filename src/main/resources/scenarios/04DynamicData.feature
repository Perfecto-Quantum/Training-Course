@dynamicData
Feature: Add Contact

  Scenario Outline: Dynamic Data
    Given I launch Contacts application
    Then I Add Contact with name "<contactName>" and number  "<phoneNumber>"
  Examples: {'datafile' : 'src/main/resources/data/contactNames.csv'}





