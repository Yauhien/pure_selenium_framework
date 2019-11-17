package com.taf.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class LoginPage extends Page {

  @FindBy(id = "username_input")
  private WebElement userInputField;

  @FindBy(id = "password_input")
  private WebElement userPasswordField;

  @FindBy(id = "login_button")
  private WebElement loginButton;

  private static String VALIDATION_MESSAGE = "//div[@id='status']/p";
  private static String PAGE_NOT_FOUND_MESSAGE = "//pre";

  @PostConstruct
  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }

  public void enterUserName(String userName) {
    sendKeys(userInputField, userName);
  }

  public void enterPassword(String password) {
    sendKeys(userPasswordField, password);
  }

  public String getValidationMessage() {
    return waitToBeVisibleElement(By.xpath(VALIDATION_MESSAGE)).getText();
  }

  public String getPageNotFoundMessage() {
    return waitToBeVisibleElement(By.xpath(PAGE_NOT_FOUND_MESSAGE)).getText();
  }
}
