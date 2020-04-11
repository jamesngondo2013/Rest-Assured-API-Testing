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
  "name": "user calls \"addPlaceAPI\" with \"POST\" http request",
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
formatter.step({
  "line": 12,
  "name": "verify that place_id created maps to \"\u003cname\u003e\" using \"getPlaceAPI\"",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
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
      "line": 15,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;1"
    },
    {
      "cells": [
        "James Ngondo",
        "Ndebele",
        "Balaka, Malawi"
      ],
      "line": 16,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;2"
    },
    {
      "cells": [
        "Dennis Gombe",
        "Chichewa",
        "Lilongwe, Malawi"
      ],
      "line": 17,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;3"
    },
    {
      "cells": [
        "Gilby Gombe",
        "English",
        "Blantyre, Malawi"
      ],
      "line": 18,
      "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 16,
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
  "name": "user calls \"addPlaceAPI\" with \"POST\" http request",
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
formatter.step({
  "line": 12,
  "name": "verify that place_id created maps to \"James Ngondo\" using \"getPlaceAPI\"",
  "matchedColumns": [
    0
  ],
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
  "duration": 1664484200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "addPlaceAPI",
      "offset": 12
    },
    {
      "val": "POST",
      "offset": 31
    }
  ],
  "location": "AddPlaceStepDefinition.user_calls_with_http_request(String,String)"
});
formatter.result({
  "duration": 1638404100,
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
  "duration": 3278700,
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
  "duration": 523624700,
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
  "duration": 16848300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "James Ngondo",
      "offset": 38
    },
    {
      "val": "getPlaceAPI",
      "offset": 59
    }
  ],
  "location": "AddPlaceStepDefinition.verify_that_place_id_created_maps_to_using(String,String)"
});
formatter.result({
  "duration": 849663000,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
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
  "name": "user calls \"addPlaceAPI\" with \"POST\" http request",
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
formatter.step({
  "line": 12,
  "name": "verify that place_id created maps to \"Dennis Gombe\" using \"getPlaceAPI\"",
  "matchedColumns": [
    0
  ],
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
  "duration": 2964600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "addPlaceAPI",
      "offset": 12
    },
    {
      "val": "POST",
      "offset": 31
    }
  ],
  "location": "AddPlaceStepDefinition.user_calls_with_http_request(String,String)"
});
formatter.result({
  "duration": 734389000,
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
  "duration": 85500,
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
  "duration": 8870700,
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
  "duration": 8822900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Dennis Gombe",
      "offset": 38
    },
    {
      "val": "getPlaceAPI",
      "offset": 59
    }
  ],
  "location": "AddPlaceStepDefinition.verify_that_place_id_created_maps_to_using(String,String)"
});
formatter.result({
  "duration": 783390600,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
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
  "name": "user calls \"addPlaceAPI\" with \"POST\" http request",
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
formatter.step({
  "line": 12,
  "name": "verify that place_id created maps to \"Gilby Gombe\" using \"getPlaceAPI\"",
  "matchedColumns": [
    0
  ],
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
  "duration": 2690400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "addPlaceAPI",
      "offset": 12
    },
    {
      "val": "POST",
      "offset": 31
    }
  ],
  "location": "AddPlaceStepDefinition.user_calls_with_http_request(String,String)"
});
formatter.result({
  "duration": 725887500,
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
  "duration": 72400,
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
  "duration": 8728400,
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
  "duration": 8308300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Gilby Gombe",
      "offset": 38
    },
    {
      "val": "getPlaceAPI",
      "offset": 58
    }
  ],
  "location": "AddPlaceStepDefinition.verify_that_place_id_created_maps_to_using(String,String)"
});
formatter.result({
  "duration": 769075200,
  "status": "passed"
});
});