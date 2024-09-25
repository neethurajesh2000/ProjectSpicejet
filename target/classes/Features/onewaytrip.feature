
Feature: user search the flights for one way trip on the home page
  Scenario: search flight for one way trip
    Given user is at one way triphome page
    And user select the destination
    And user select the return date
    And user select the category senior citizen
    Then user click the search flight button
  

 
