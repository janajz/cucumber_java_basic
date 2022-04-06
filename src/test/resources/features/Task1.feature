Feature:
   Create different scenarios for "Enter a number" page

  Background:
    Given I am on enter a number page

 Scenario Outline: incorrect values for the page
    When I enter a number: <number>
    And I click submit
    Then I can see error text:"<text>" in the error page

   Examples:
     | number  | text                  |
     | 11      | Number is too small   |
     | 111     | Number is too big     |
     | Jana    | Please enter a number |


  Scenario: correct values for the page
    When I enter a number: 64
    And I click submit
    Then I see message:"Square root of 64 is 8.00" in the page






