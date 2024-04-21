package stepdefinitions;

import com.taf.config.TestConfig;
import com.taf.enums.ApplicationsPages;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.log4j.Log4j;
import org.springframework.test.context.ContextConfiguration;

@Log4j
@ContextConfiguration(classes = {TestConfig.class})
@CucumberContextConfiguration
public class CommonStepDefinitions extends BaseTest{

  @When("user navigates to {string}")
  public void navigateTo(String endpoint) {
    log.info("[Step] user navigates to " + endpoint);
    browser.openUrl(url + ApplicationsPages.valueOf(endpoint).getField());
    browser.windowMaximize();
  }

  @Then("{string} is displayed")
  public void checkPageUrl(String endpoint) {
    log.info("[Step] " + endpoint + " page is displayed");
    assertTrue(browser.getPageUrl().contains(ApplicationsPages.valueOf(endpoint).getField()));
  }
}
