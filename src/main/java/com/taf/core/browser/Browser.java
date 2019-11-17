package com.taf.core.browser;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Log4j
@Component
@Getter
public class Browser {
  //Class for all browser related operations

  @Autowired
  private WebDriverManager webDriverManager;

  public Browser openUrl(String url) {
    webDriverManager.getDriver().navigate().to(url);
    return this;
  }

  public void windowMaximize() {
    webDriverManager.getDriver().manage().window().maximize();
  }

  public void back() {
    log.info("[Browser] Go one page back.");
    webDriverManager.getDriver().navigate().back();
  }

  public String getPageUrl(){
    return webDriverManager.getDriver().getCurrentUrl();
  }
}
