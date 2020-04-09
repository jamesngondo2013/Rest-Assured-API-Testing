#Author: jamesngondogti@gmail.com

Feature: Validating Place API's


  Scenario Outline: Verify if Place is being added successfully using AddPlaceAPI
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    
  Examples:
      |name						| language | address					|
      | James Ngondo	| Ndebele  | Balaka, Malawi		|
      | Dennis Gombe	| Chichewa | Lilongwe, Malawi	|
      | Gilby Gombe		| English  | Blantyre, Malawi	|
   	 
