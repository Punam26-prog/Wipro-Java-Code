package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/flipkart.feature", // path of feature file
    glue = "stepDefinition",                                   // package of step defs
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/flipkart-report.html",   // HTML report
    },
    monochrome = true,       // readable console output
    tags = "@flipkart" 
    //tags = "@positive"  // control execution by tags
    //tags =”@positive and @negative” → checks both 
   //tags = “not @positive” → It will Exclude Positive scenario
  //tags =”@positive and @negative” → checks anyone
  //tags = “(@positive or negative) and @filpkart” → Grouping
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
}