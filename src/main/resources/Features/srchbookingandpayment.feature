
Feature: user search a flight and proceed booking and payment
  Scenario: flight booking procedure and payment
    Given user is at bookinghome page
    And user search flight
    And user click on the continue button
    And user enters the bookingfirst name
    And user enters the bookinglast name
    And user enters phone no for booking
    And user enters email and city for booking
    And user enters name for primary customer
    And user enters phoneno and dob for primary customer
    And user select seat number
    And user select meals
    And user click on the continue button
    And user enters the card number for payment
    And user enters the cardholder name for payment
    And user enters the expiry month for payment
    And user enters the expiry year for payment
    When user enters the security code for payment
    Then user click on the payment button
    

 