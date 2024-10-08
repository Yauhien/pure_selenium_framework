package com.taf.pages;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
@Getter
public class LandingPage extends Page {

  @FindBy(id="login_link")
  private WebElement LoginButton;

  @FindBy(id="signup_link")
  private WebElement SignUpButton;

  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }
}
