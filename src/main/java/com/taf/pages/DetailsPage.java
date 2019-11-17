package com.taf.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DetailsPage extends Page {

  @FindBy(xpath = "//main/div[2]//li[1]")
  private WebElement nameText;

  @FindBy(xpath = "//main/div[2]//li[2]")
  private WebElement emailText;

  @PostConstruct
  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }

  public String getNameText(){
    waitToBeVisible(nameText);
    return nameText.getText();
  }

  public String getEmailText(){
    waitToBeVisible(emailText);
    return emailText.getText();
  }
}
