package com.taf.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
@Getter
public class NewUserPage extends Page {

    @FindBy(xpath="//main/div[2]//p")
    private WebElement welcomeText;

    public void init() {
      PageFactory.initElements(webDriverManager.getDriver(), this);
    }

    public String getWelcomeText(){
      waitToBeVisible(welcomeText);
      return welcomeText.getText();
    }
  }
