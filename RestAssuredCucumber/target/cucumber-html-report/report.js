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
formatter.scenarioOutline({
  "line": 6,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Add Place Payload with \"\u003cname\u003e\" \"\u003clanguage\u003e\" \"\u003caddress\u003e\"",
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
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;",
  "rows": [
    {
      "cells": [
        "name",
        "language",
        "address"
      ],
      "line": 14,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;1"
    },
    {
      "cells": [
        "James Ngondo",
        "Ndebele",
        "Balaka, Malawi"
      ],
      "line": 15,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;2"
    },
    {
      "cells": [
        "Dennis Gombe",
        "Chichewa",
        "Lilongwe, Malawi"
      ],
      "line": 16,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;3"
    },
    {
      "cells": [
        "Gilby Gombe",
        "English",
        "Blantyre, Malawi"
      ],
      "line": 17,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Add Place Payload with \"James Ngondo\" \"Ndebele\" \"Balaka, Malawi\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
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
  "arguments": [
    {
      "val": "James Ngondo",
      "offset": 24
    },
    {
      "val": "Ndebele",
      "offset": 39
    },
    {
      "val": "Balaka, Malawi",
      "offset": 49
    }
  ],
  "location": "AddPlaceStepDefinition.add_Place_Payload_with(String,String,String)"
});
formatter.result({
  "duration": 1701847100,
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
  "duration": 2389950201,
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
  "duration": 4172800,
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
  "duration": 24049299,
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
  "duration": 10650199,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Add Place Payload with \"Dennis Gombe\" \"Chichewa\" \"Lilongwe, Malawi\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
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
  "arguments": [
    {
      "val": "Dennis Gombe",
      "offset": 24
    },
    {
      "val": "Chichewa",
      "offset": 39
    },
    {
      "val": "Lilongwe, Malawi",
      "offset": 50
    }
  ],
  "location": "AddPlaceStepDefinition.add_Place_Payload_with(String,String,String)"
});
formatter.result({
  "duration": 6566200,
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
  "duration": 4222459800,
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
  "duration": 100400,
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
  "duration": 12507300,
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
  "duration": 11026200,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Add Place Payload with \"Gilby Gombe\" \"English\" \"Blantyre, Malawi\"",
  "matchedColumns": [
    0,
    1,
    2
  ],
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
  "arguments": [
    {
      "val": "Gilby Gombe",
      "offset": 24
    },
    {
      "val": "English",
      "offset": 38
    },
    {
      "val": "Blantyre, Malawi",
      "offset": 48
    }
  ],
  "location": "AddPlaceStepDefinition.add_Place_Payload_with(String,String,String)"
});
formatter.result({
  "duration": 5136601,
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
  "duration": 1106840300,
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
  "duration": 110100,
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
  "duration": 13725600,
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
  "duration": 14435000,
  "status": "passed"
});
});