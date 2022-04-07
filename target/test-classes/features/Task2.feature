Feature:
  Create different scenarios for Task2 page

  Background:
    Given I am on the Task2 home page

  Scenario Outline: Adding one more person to the existing list

    And I click Add person button
    And I enter person's name: "<name>"
    And I enter job: "<job>"
    And I click Add button
    Then I can see name "<name>" appeared
    And I can see job "<job>" appeared

    Examples:

      | name  | job |
      |Pufik  | catlover |

  Scenario: Edit a person

    And I click Pencil button on the first person
    And I enter "Tuslik" as a new name
    And I enter "doglover" as a new job
    And I click Edit button
    Then I can see new name "Tuslik" appeared
    And I can see new job "doglover" appeared

  Scenario: Remove a person

    And I click on remove button
    Then I can see person name and job is removed

  Scenario: reset original list after adding, editing, removing a person

    And I click Add person button
    And I enter person's name: "Pufik"
    And I enter job: "catlover"
    And I click Add button
    Then I can see name "Pufik" appeared
    And I can see job "catlover" appeared
    And I click Pencil button on the first person
    And I enter "Tuslik" as a new name
    And I enter "doglover" as a new job
    And I click Edit button
    Then I can see new name "Tuslik" appeared
    And I can see new job "doglover" appeared
    And I click on remove button
    Then I can see person name and job is removed
    And I click Reset the list
    Then I can see the initial list

  Scenario: Check if Clear button on adding works correctly

    And I click Add person button
    Then I can see name field is empty
    And I can see job field is empty
    And I enter person's name: "Pufik"
    And I enter job: "catlover"
    And I click Clear button
    Then I can see name field is empty
    And I can see job field is empty



















