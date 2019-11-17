package stepdefinitions;

import com.taf.forms.HeaderForm;
import com.taf.pages.LandingPage;
import com.taf.pages.LoginPage;
import cucumber.api.java.en.Then;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import cucumber.api.java.en.When;

@Log4j
public class LoginStepDefinitions extends BaseTest {

  @Autowired
  private LoginPage loginPage;

  @Autowired
  private LandingPage landingPage;

  @Autowired
  HeaderForm headerForm;

  @When("user logins with credentials {string}, {string}")
  public void loginAs(String user, String password) {
    log.info("[Step] user logins with credentials " + user + " " + password);
    landingPage.getLoginButton().click();

    loginPage.enterUserName(user);
    loginPage.enterPassword(password);
    loginPage.getLoginButton().click();
  }

  @Then("error message is displayed")
  public void checkErrorMessageIsDisplayed() {
    log.info("[Step] error message is displayed");
    assertEquals("Wrong credentials. You can do it, try again!", loginPage.getValidationMessage());
  }

  @Then("{string} message is displayed")
  public void checkPageNotFoundMessageDisplayed(String message) {
    log.info("[Step] " + message + " message is displayed");
    assertTrue(loginPage.getPageNotFoundMessage().contains(message));
    browser.back();
  }

  @When("user logs out")
  public void logOut() {
    log.info("[Step] user logs out");
    headerForm.click(headerForm.getLogOutLink());
  }
}
