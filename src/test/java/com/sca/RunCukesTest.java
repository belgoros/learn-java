package com.sca;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by serguei_cambour on 11/12/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, snippets = SnippetType.CAMELCASE, tags = {"~@ignore"}, features = "src/test/resources/features", glue = "com.sca.steps")
public class RunCukesTest {
}
