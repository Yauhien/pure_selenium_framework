package com.taf.pages;

import lombok.Getter;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static com.taf.core.Utils.CurrencyHelper.getAmountWithoutPound;

@Component
@Getter
public class ProfilePage extends Page {

  @PostConstruct
  public void init() {
    PageFactory.initElements(webDriverManager.getDriver(), this);
  }
}