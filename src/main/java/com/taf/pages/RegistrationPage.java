package com.taf.pages;

import lombok.Getter;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

@Component
@Getter
public class RegistrationPage extends Page{

  @FindBy(id="username_input")
  private WebElement userNameInputField;

  @FindBy(id="password_input")
  private WebElement passwordInputField;

  @FindBy(id="name_input")
  private WebElement nameInputField;

  @FindBy(id="email_input")
  private WebElement emailInput;

  @FindBy(id="day_select")
  private WebElement dayDropDown;

  @FindBy(id="month_select")
  private WebElement monthDropDown;

  @FindBy(id="year_select")
  private WebElement yearsDropDown;

  @FindBy(id="submit_button")
  private WebElement submitButton;

  @PostConstruct
  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }

  public void selectDayInDropDown()
  {
    Select select = new Select(dayDropDown);
    select.selectByVisibleText(String.valueOf(RandomUtils.nextInt(1,30)));
  }

  public void deselectDayInDropDown()
  {
    Select select = new Select(dayDropDown);
    select.selectByVisibleText("day");
  }

  public void selectMonthInDropDown()
  {
    int randomMonth = RandomUtils.nextInt(1, 12);
    String monthAsText = Month.of(randomMonth).getDisplayName(TextStyle.FULL, Locale.US);

    Select select = new Select(monthDropDown);
    select.selectByVisibleText(monthAsText);
  }

  public void deselectMonthInDropDown()
  {
    Select select = new Select(monthDropDown);
    select.selectByVisibleText("month");
  }

  public void selectYearInDropDown()
  {
    Select select = new Select(yearsDropDown);
    select.selectByVisibleText(String.valueOf(RandomUtils.nextInt(1991,2015)));
  }

  public void deselectYearInDropDown()
  {
    Select select = new Select(yearsDropDown);
    select.selectByVisibleText("year");
  }
}
