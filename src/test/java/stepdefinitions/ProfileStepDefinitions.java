package stepdefinitions;

import com.taf.forms.HeaderForm;
import com.taf.pages.ProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j
public class ProfileStepDefinitions extends BaseTest {

  @Autowired
  private ProfilePage profilePage;

  @Autowired
  private HeaderForm headerForm;

  @Then("new user's profile has no superpowers")
  public void checkNewUserProfileHasNoSuperpowers() {
    log.info("[Step] new user's profile has no superpowers");
    assertTrue(profilePage.getPowersMessage().contains("You have no super powers yet"));
  }

  @When("user opens profile")
  public void openProfile() {
    headerForm.click(headerForm.getProfileLink());
  }

  @Then("admin superpower is displayed")
  public void checkAdminSuperpower() {
    log.info("[Step] admin superpower is displayed");
    //Don't know what is superpower. May be an important functionality
    assertTrue(profilePage.getPowersMessage().contains("Change the course of a waterfall."));
  }

  @Then("the users table is displayed")
  public void checkUsersTableIsNotEmpty() {
    log.info("[Step] the users table is displayed");
    //Hard-coded data. Not enough requirements to check the contents
    assertNotEquals(profilePage.getUsersTable().getSize(), 0);
  }

  @Then("dev superpower is displayed")
  public void checkDevSuperpowerDisplayed() {
    log.info("[Step] dev superpower is displayed");
    //Don't know what is superpower. May be an important functionality
    assertTrue(profilePage.getPowersMessage().contains("Debug a repellent factory storage."));
  }

  @Then("tester superpower is displayed")
  public void checkTesterSuperpowerDisplayed() {
    log.info("[Step] tester superpower is displayed");
    //Don't know what is superpower. May be an important functionality
    assertTrue(profilePage.getPowersMessage().contains("Voltage AND Current."));
  }
}
