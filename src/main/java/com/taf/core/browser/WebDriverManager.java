package com.taf.core.browser;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class WebDriverManager {

  @Autowired
  private WebDriver driver;

  public WebDriver getDriver() {
    return driver;
  }

  public void closeDriver() {
    driver.quit();
    driver = null;
  }

  public void configureDriver() {
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
  }
}