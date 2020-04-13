package com.james.training.RestAssuredCucumber.cucumber.Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/com/james/training/RestAssuredCucumber/features", 
  glue = { "com/james/training/RestAssuredCucumber/stepDefinitions" },
  //tags= {"@deletePlace"},
  dryRun=false,
  strict=true,
  monochrome=true,
  format = {"pretty", "json:target/jsonReports/cucumber-report.json"},
  plugin = {"json:target/jsonReports/cucumber-report.json"})
public class AppTestRunner {

}
