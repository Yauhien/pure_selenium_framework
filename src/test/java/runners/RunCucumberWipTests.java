package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@wip", monochrome = true, features = "src/test/resources/features/", glue = {
    "stepdefinitions/"}, plugin = {"html:target/cucumber-pretty", "json:target/cucumber.json"})

public class RunCucumberWipTests {
}
