package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Saucedemo.feature",
glue = "org.stepdefinition",dryRun = false)
public class TestRunner_ {

	
}
