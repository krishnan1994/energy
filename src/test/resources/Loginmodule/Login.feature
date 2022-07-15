Feature: To validate login functionality of flipkart application

  Background: 
    Given user in flipkart login page

  Scenario: To validate login page using different credentials
    When user enter invalid phoneno and invalid password in a login page
    And user enter invalid phoneno and valid password in a login page
    And user enter valid phoneno and invalid password in a login page
    Then user should get incorrect message for invalid login

  Scenario: To validate login page using Equivalence Partitioning
    When user have to enter maximum ten numbers phoneno if it is minimum
    And user have to enter minimum ten numbers phoneno if it is maximum
    And user have to login without entering passing the values
    Then user should get incorrect message for invalid login access

  Scenario: To validate login page valid credentials and add the product into cart
    When user have to valid username and valid password
    When user have to search for the products and add the product into add cart
