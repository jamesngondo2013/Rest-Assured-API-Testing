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
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@addPlace"
    }
  ]
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
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@addPlace"
    }
  ]
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
  "duration": 1691196700,
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
  "duration": 1736159900,
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
  "duration": 2304400,
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
  "duration": 490249000,
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
  "duration": 15932500,
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
  "duration": 827131800,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@addPlace"
    }
  ]
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
  "duration": 3669000,
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
  "duration": 734249900,
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
  "duration": 74400,
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
  "duration": 10845100,
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
  "duration": 9825700,
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
  "duration": 776049900,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Verify if Place is being added successfully using AddPlaceAPI",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-place-is-being-added-successfully-using-addplaceapi;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@addPlace"
    }
  ]
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
  "duration": 3383300,
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
  "duration": 725684500,
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
  "duration": 86500,
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
  "duration": 9457700,
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
  "duration": 10791900,
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
  "duration": 790153800,
  "status": "passed"
});
formatter.before({
  "duration": 47800,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Verify if Delete Place functionality is working",
  "description": "",
  "id": "validating-place-api\u0027s;verify-if-delete-place-functionality-is-working",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 21,
      "name": "@deletePlace"
    }
  ]
});
formatter.step({
  "line": 23,
  "name": "delete place payload",
  "keyword": "Given "
});
formatter.step({
  "line": 24,
  "name": "user calls \"deletePlaceAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "the API call is successful with status code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddPlaceStepDefinition.delete_place_payload()"
});
formatter.result({
  "duration": 1038200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "deletePlaceAPI",
      "offset": 12
    },
    {
      "val": "POST",
      "offset": 34
    }
  ],
  "location": "AddPlaceStepDefinition.user_calls_with_http_request(String,String)"
});
formatter.result({
  "duration": 762260600,
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
  "duration": 64800,
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
  "duration": 12290200,
  "status": "passed"
});
});