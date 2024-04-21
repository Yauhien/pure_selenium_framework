package stepdefinitions;

import com.taf.enums.ApplicationVariables;
import com.taf.forms.HeaderForm;
import com.taf.pages.DetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j
public class DetailsStepDefinitions extends BaseTest {

  @Autowired
  DetailsPage detailsPage;

  @Autowired
  HeaderForm headerForm;

  @When("user opens details")
  public void openDetails() {
    headerForm.click(headerForm.getDetailsLink());
  }

  @Then("user info is displayed in the details")
  public void checkUserInfoDisplayedInTheDetails() {
    assertTrue(detailsPage.getNameText().contains(testContext.get(ApplicationVariables.NAME)));
    assertTrue(detailsPage.getEmailText().contains(testContext.get(ApplicationVariables.EMAIL)));
  }
}
