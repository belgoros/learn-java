package com.sca;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, snippets = CucumberOptions.SnippetType.CAMELCASE, features = "src/test/resources/features", glue = "com.sca.steps")
public class RunCukesTest {
}
