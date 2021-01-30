@Login
Feature: Login features
  I want to perform various login test in this feature file

  @tag1
  Scenario: Success Login
    Given I am on the Home Page
    When I enter my "shireenkamra@gmail.com" and "Shireen12"
    Then I should see the MyAccount page