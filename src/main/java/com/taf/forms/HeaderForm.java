package com.taf.forms;

import com.taf.pages.Page;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
@Getter
public class HeaderForm extends Page {

  @FindBy(id="profile_link")
  private WebElement profileLink;

  @FindBy(id="details_link")
  private WebElement detailsLink;

  @FindBy(xpath = "//div[@id='status']//a")
  private WebElement logOutLink;

  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }

  public WebElement getLogOutLink(){
    waitToBeVisible(logOutLink);
    return logOutLink;
  }
}
