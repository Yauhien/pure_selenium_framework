package stepdefinitions;

import com.taf.config.TestConfig;
import com.taf.enums.ApplicationsPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.springframework.test.context.ContextConfiguration;

@Log4j
@ContextConfiguration(classes = {TestConfig.class})
public class CommonStepDefinitions extends BaseTest{

  @When("user navigates to {string}")
  public void navigateTo(String endpoint) {
    log.info("[Step] user navigates to " + endpoint);
    browser.openUrl(url + ApplicationsPages.valueOf(endpoint).getField());
  }

  @Then("{string} is displayed")
  public void checkPageUrl(String endpoint) {
    log.info("[Step] " + endpoint + " page is displayed");
    assertTrue(browser.getPageUrl().contains(ApplicationsPages.valueOf(endpoint).getField()));
  }
}
