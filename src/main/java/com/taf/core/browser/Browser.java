package com.taf.core.browser;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j
@Component
@Getter
public class Browser {

  @Autowired
  private WebDriverManager webDriverManager;

  public Browser openUrl(String url) {
    webDriverManager.getDriver().navigate().to(url);
    return this;
  }

  public void windowMaximize() {
    log.info("[Browser] Maximize browser window.");
    webDriverManager.getDriver().manage().window().maximize();
  }
}
