package com.taf.config;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@ComponentScan("com")
@PropertySource("classpath:application.properties")
public class TestConfig {
  //Class for browser specific options. Selenium manager takes care of driver download

  @Value("${browser.type}")
  private String driverType;

  public ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    //options.addArguments("--headless");
    options.addArguments("--window-size=1920,1080");
    return options;
  }

  private void setCapabilities() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
  }

  @Bean
  public WebDriver createDriver() {
    WebDriver driver = null;

    if (driverType.equals("firefox")) {
      driver = new FirefoxDriver();
    } else {
      setCapabilities();
      ChromeDriverService driverService = ChromeDriverService.createDefaultService();
      driver = new ChromeDriver(driverService, getChromeOptions());
    }
    return driver;
  }
}
