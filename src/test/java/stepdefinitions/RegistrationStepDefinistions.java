package stepdefinitions;

import com.taf.enums.ApplicationVariables;
import com.taf.pages.LandingPage;
import com.taf.pages.NewUserPage;
import com.taf.pages.RegistrationPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang3.RandomStringUtils;

@Log4j
public class RegistrationStepDefinistions extends BaseTest{

  @Autowired
  RegistrationPage registrationPage;

  @Autowired
  LandingPage landingPage;

  @Autowired
  NewUserPage newUserPage;

  @When("user clicks to sigh up")
  public void clickToSighUp() {
    log.info("[Step] user clicks to sigh up");
    landingPage.getSignUpButton().click();
  }

  @When("new user sigh ups to the application")
  public void sighUpUser() {
    log.info("[Step] new user sigh ups to the application");
    String userName = RandomStringUtils.randomAlphanumeric(8);
    String password = RandomStringUtils.randomAlphanumeric(7);
    String name = RandomStringUtils.randomAlphanumeric(5);
    String email = RandomStringUtils
        .randomAlphanumeric(4)
        .concat("@")
        .concat(RandomStringUtils.randomAlphanumeric(3));

    registrationPage.sendKeys(registrationPage.getUserNameInputField(), userName);
    registrationPage.sendKeys(registrationPage.getPasswordInputField(), password);
    registrationPage.sendKeys(registrationPage.getNameInputField(), name);
    registrationPage.sendKeys(registrationPage.getEmailInput(), email);
    registrationPage.selectDayInDropDown();
    registrationPage.selectMonthInDropDown();
    registrationPage.selectYearInDropDown();

    registrationPage.click(registrationPage.getSubmitButton());

    testContext.set(ApplicationVariables.USERNAME,userName);
    testContext.set(ApplicationVariables.PASSWORD,password);
    testContext.set(ApplicationVariables.NAME,name);
    testContext.set(ApplicationVariables.EMAIL,email);
  }

  @Then("welcome message is displayed")
  public void checkWelcomeMessageDisplayed() {
    log.info("[Step welcom message is displayed]");
    newUserPage.getWelcomeText().contains(testContext.get(ApplicationVariables.NAME));
  }

  @When("new user sigh ups with empty {string}")
  public void signUpUserWithEmptyFields(String field) {
    log.info("[Step] new user sigh ups with empty " + field);

    String userName = RandomStringUtils.randomAlphanumeric(8);
    String password = RandomStringUtils.randomAlphanumeric(7);
    String name = RandomStringUtils.randomAlphanumeric(5);
    String email = RandomStringUtils
        .randomAlphanumeric(4)
        .concat("@")
        .concat(RandomStringUtils.randomAlphanumeric(3));

    registrationPage.sendKeys(registrationPage.getUserNameInputField(), userName);
    registrationPage.sendKeys(registrationPage.getPasswordInputField(), password);
    registrationPage.sendKeys(registrationPage.getNameInputField(), name);
    registrationPage.sendKeys(registrationPage.getEmailInput(), email);
    registrationPage.selectDayInDropDown();
    registrationPage.selectMonthInDropDown();
    registrationPage.selectYearInDropDown();

    switch (field){
      case("username"):
        registrationPage.getUserNameInputField().clear();
        break;
      case("password"):
        registrationPage.getPasswordInputField().clear();
        break;
      case ("email"):
        registrationPage.getEmailInput().clear();
        break;
      case("name"):
        registrationPage.getNameInputField().clear();
        break;
      case("day"):
        registrationPage.deselectDayInDropDown();
        break;
      case("month"):
        registrationPage.deselectMonthInDropDown();
        break;
      case("year"):
        registrationPage.deselectYearInDropDown();
        break;
        default:
          throw new RuntimeException("The field " + field + " is not found");
    }

    registrationPage.click(registrationPage.getSubmitButton());
  }

  @When("new user sigh ups with invalid email")
  public void sighUpsWithInvalidEmail() {
    log.info("[Step] new user sigh ups with invalid email");
    String userName = RandomStringUtils.randomAlphanumeric(8);
    String password = RandomStringUtils.randomAlphanumeric(7);
    String name = RandomStringUtils.randomAlphanumeric(5);
    String invalidEmail = RandomStringUtils
        .randomAlphanumeric(4)
        .concat(RandomStringUtils.randomAlphanumeric(3));

    registrationPage.sendKeys(registrationPage.getUserNameInputField(), userName);
    registrationPage.sendKeys(registrationPage.getPasswordInputField(), password);
    registrationPage.sendKeys(registrationPage.getNameInputField(), name);
    registrationPage.sendKeys(registrationPage.getEmailInput(), invalidEmail);
    registrationPage.selectDayInDropDown();
    registrationPage.selectMonthInDropDown();
    registrationPage.selectYearInDropDown();

    registrationPage.click(registrationPage.getSubmitButton());
  }
}
