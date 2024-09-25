
Feature: user select the flight for round trip on home page
  Scenario: user select the flight for round trip
    Given user is at round trip home page
    And user click on the round trip button
    And user select destination for round trip
    And  user selec the return date for round trip
    When user select the category
    Then user click on the search flight button for round trip

 