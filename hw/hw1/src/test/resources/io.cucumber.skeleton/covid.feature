Feature: Covid

  Scenario: get all countries
    When I go to "http://localhost:8080/main"
    And I choose "Portugal" followed by "2020-06-06"
    And I click the "search" button
    Then I should be shown "Portugal" covid info from day "2020-06-06"