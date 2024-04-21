package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@all and not @wip", monochrome = true, features = "src/test/resources/features/", glue = {
        "stepdefinitions", "cucumber.api.spring"}, plugin = {"html:target/cucumber-pretty", "json:target/cucumber.json"})
public class RunCucumberAllTests {
}
