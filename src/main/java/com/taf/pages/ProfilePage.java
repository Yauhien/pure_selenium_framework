package com.taf.pages;

import lombok.Getter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class ProfilePage extends Page {

  @FindBy(xpath = "//main/div[2]//p[2]")
  private WebElement powersMessage;

  @FindBy(xpath = "//table[@id='users_list_table']//tbody")
  private WebElement usersTable;

  @PostConstruct
  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }

  public String getPowersMessage(){
    waitToBeVisible(powersMessage);
    return powersMessage.getText();
  }

  public WebElement getUsersTable(){
    waitToBeVisible(usersTable);
    return usersTable;
  }
}