package com.in28minutes.microservices.currencyexchangeservice;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources", plugin = { "pretty" })
public class RunCucumberIntegrationTestCase {
}