
Feature: Check the user  registration functionality  
  Scenario: user registration
    Given user is at websitehome page
    When user click on the signup button
    And user select the element
    And user enters the first name    
    And user enter the last name
    And user select country
    And user enter the date of birth
    And user enter the mobile number
    And user enter the email
    And user enter the password and confirm password
    When user click on the conditions
    Then user click on the submit button
    

  