package com.cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/features/BanyanTask.feature", glue = "com.stepDefinitions", tags = "@LoginVerify", plugin = {
        "pretty" }, monochrome = true, stepNotifications = true)

public class TestRunner {
    
}
