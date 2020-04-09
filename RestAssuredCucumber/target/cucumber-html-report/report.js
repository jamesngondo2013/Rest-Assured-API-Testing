$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("placeValidations.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: jamesngondogti@gmail.com"
    }
  ],
  "line": 3,
  "name": "Validating Place API\u0027s",
  "description": "",
  "id": "validating-place-api\u0027s",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Add Place Payload",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user calls \"AddPlaceAPI\" with \"Post\" http request",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the API call is successful with status code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "\"scope\" in response body is \"APP\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddPlaceStepDefinition.add_Place_Payload()"
});
formatter.result({
  "duration": 1100265300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AddPlaceAPI",
      "offset": 12
    },
    {
      "val": "Post",
      "offset": 31
    }
  ],
  "location": "AddPlaceStepDefinition.user_calls_with_http_request(String,String)"
});
formatter.result({
  "duration": 2537001600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 44
    }
  ],
  "location": "AddPlaceStepDefinition.the_API_call_is_successful_with_status_code(int)"
});
formatter.result({
  "duration": 3603700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "status",
      "offset": 1
    },
    {
      "val": "OK",
      "offset": 30
    }
  ],
  "location": "AddPlaceStepDefinition.in_response_body_is(String,String)"
});
formatter.result({
  "duration": 22276900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "scope",
      "offset": 1
    },
    {
      "val": "APP",
      "offset": 29
    }
  ],
  "location": "AddPlaceStepDefinition.in_response_body_is(String,String)"
});
formatter.result({
  "duration": 12131500,
  "status": "passed"
});
});