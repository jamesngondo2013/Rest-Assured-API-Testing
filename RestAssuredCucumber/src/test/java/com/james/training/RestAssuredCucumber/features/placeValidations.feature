#Author: jamesngondogti@gmail.com

Feature: Validating Place API's


  Scenario: Verify if Place is being added successfully using AddPlaceAPI
    Given Add Place Payload
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
