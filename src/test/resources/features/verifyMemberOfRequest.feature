@test1
Feature: perform a request for verifying member of account E2E

  Background: Get token from log in request to use in any other request
    Given I perform a POST request to log in and retrieve token


  Scenario: Send a request to get member of and verify status code and response body.
    Given I perform a GET request to "/workspaces/member-of"
    Then the response status code is 200
    And the response headers contains "application/json"
    And the response body contains "new workspace" field
    And the response body contains the following fields:
      | id     | hPdVcYQBXL0WroF_0m4_ |
      | userId | 1kt3tHgB6T29TqnSCje3 |
      | name   | new workspace              |

  Scenario: Create Project
    Given I perform a POST request to "/design/projects"
    Then the response status code is 201
    And the response headers contains "application/json"
    And the response body contains "Default" field
    And the response body contains the following fields:
      | id     | Iy59_YYBH5OXBlMVH5qK |