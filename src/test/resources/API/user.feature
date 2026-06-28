@api

@User

Feature: User API Testing
  Scenario: Create New User Successfully
    Given endpoint create a new user
    And prepares valid data
    When send Request POST create user
    Then response status should be 200
    Then response body should contain created user data

  Scenario: Get User ID
    Given endpoint has created a new user
    When user send Request GET user by id
    Then response status should be 200
    Then response body should show user details

  Scenario: Update User ID
    Given endpoint has created a user
    And user prepare an update data
    When send Request PUT update user
    Then response status should be 200
    Then response body should contain created update user data

  Scenario: Delete User ID
    Given endpoint has created a user
    When user send Request DELETE user
    Then response status should be 200
    Then data user should be deleted
