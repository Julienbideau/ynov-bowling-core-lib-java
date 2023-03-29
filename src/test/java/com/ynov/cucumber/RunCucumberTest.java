package com.ynov.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "html:target/cucumber-html-report.html"}, features = "src/test/resources", tags = "not @ignore", publish = true)
public class RunCucumberTest {
}