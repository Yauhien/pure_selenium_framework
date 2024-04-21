package com.taf.config;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
  //Class for webdriver path and type configuration.
  //Additionally browser options and system variables are set


  @Value("${driver.path}")
  private String driverPath;

  @Value("${browser.type}")
  private String driverType;

  private static String OS = System.getProperty("os.name").toLowerCase();

  private void setChromeSystemProperties(){
    String fullDriverPath = "";

    if (isWindows()) {
      fullDriverPath = driverPath
          .concat("windows")
          .concat(System.getProperty("file.separator"))
          .concat("chromedriver.exe");
    } else if (isLinux()) {
      fullDriverPath = driverPath
          .concat("linux")
          .concat(System.getProperty("file.separator"))
          .concat("chromedriver");
    } else if (isMac()) {
      fullDriverPath = driverPath
          .concat("mac")
          .concat(System.getProperty("file.separator"))
          .concat("chromedriver");
    } else {
      throw new RuntimeException("driverPath cannot be constructed for " + OS);
    }

    System.setProperty("webdriver.chrome.driver", fullDriverPath);
    System.setProperty("webdriver.chrome.logfile", "./chromedriver.log");
    System.setProperty("webdriver.chrome.verboseLogging", "true");
  }

  private void setFirefoxSystemProperties(){
    String fullDriverPath = "";

    if (isWindows()) {
      fullDriverPath = driverPath
          .concat("windows")
          .concat(System.getProperty("file.separator"))
          .concat("geckodriver.exe");
    } else if (isLinux()) {
      fullDriverPath = driverPath
          .concat("linux")
          .concat(System.getProperty("file.separator"))
          .concat("geckodriver");
    } else if (isMac()) {
      fullDriverPath = driverPath
          .concat("mac")
          .concat(System.getProperty("file.separator"))
          .concat("geckodriver");
    } else {
      throw new RuntimeException("driverPath cannot be constructed for " + OS);
    }

    System.setProperty("webdriver.gecko.driver", fullDriverPath);
  }

  private static boolean isWindows() {
    return (OS.contains("win"));
  }

  private static boolean isMac() {
    return (OS.contains("mac"));
  }

  private static boolean isLinux() {
    return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
  }

  public ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    //options.addArguments("--headless");
    options.addArguments("--window-size=1920,1080");
    //options.setExperimentalOption("prefs", getPrefs());
    return options;
  }

  private void setCapabilities() {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
  }

  @Bean
  public WebDriver createDriver() {
    WebDriver driver = null;

    if (driverType.equals("firefox")) {
      setFirefoxSystemProperties();
      driver = new FirefoxDriver();
    } else {
      setChromeSystemProperties();
      setCapabilities();
      ChromeDriverService driverService = ChromeDriverService.createDefaultService();
      driver = new ChromeDriver(driverService, getChromeOptions());
    }
    return driver;
  }
}
