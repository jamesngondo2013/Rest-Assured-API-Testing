package com.james.training.RestAssuredCucumber.cucumber.Options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/com/james/training/RestAssuredCucumber/features", 
  glue = { "com/james/training/RestAssuredCucumber/stepDefinitions" },
  dryRun=false,
  strict=true,
  monochrome=true,
  plugin = { "pretty", "html:target/cucumber-html-report" })
public class AppTestRunner {

}
