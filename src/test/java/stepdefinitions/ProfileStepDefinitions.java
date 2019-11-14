package stepdefinitions;

import com.taf.config.TestConfig;
import com.taf.pages.ProfilePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@Log4j
@ContextConfiguration(classes = {TestConfig.class})
public class ProfileStepDefinitions extends BaseTest {

  @Autowired
  private ProfilePage profilePage;

  @When("user opens loan page")
  public void openLoanPage() {
    log.info("[Step] user opens loan page " + url);
    browser.windowMaximize();
    browser.openUrl(url);
  }

  @When("user activates {string} promocode")
  public void activatePromocode(String promocode) {
    log.info("[Step] user activates " + promocode + " promocode");
    profilePage.activatePromocode(promocode);
  }

  @Then("total repayable sum is decreased by {string}")
  public void checkTotalRepayableSumIsDescriese(String discount) {
    log.info("[Step] total repayable sum is descriesed by  " + discount);
    assertEquals(profilePage.calculateTotalWithDiscount(discount), profilePage.getTotalWithDiscountLocator());
  }
}