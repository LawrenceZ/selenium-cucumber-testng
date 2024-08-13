package com.mydemo.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.mydemo.stepdefinitions"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
