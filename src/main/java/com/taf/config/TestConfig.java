package com.taf.config;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Log4j
@Configuration
@ComponentScan("com.taf")
@PropertySource("classpath:application.properties")
public class TestConfig {

  @Value("${driver.path}")
  private String driverPath;

  @Value("${browser.type}")
  private String driverType;

  @Bean
  public WebDriver chrome() {

    System.setProperty("webdriver.chrome.driver", driverPath);
    System.setProperty("webdriver.chrome.logfile", "./chromedriver.log");
    System.setProperty("webdriver.chrome.verboseLogging", "true");

    //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-infobars"); // disabling infobars
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    options.addArguments("--window-size=1920,1080");
    //options.setBinary(driverPath);
    //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    return new ChromeDriver(options);
  }
}
