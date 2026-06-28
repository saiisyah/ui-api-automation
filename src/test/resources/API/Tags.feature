@api


Feature: Tags API

  Scenario: Get lists of all Tags
    Given prepare endpoint for get Tags
    When send Request for get Tags
    Then response should be 200
    Then response body should contain tag lists
