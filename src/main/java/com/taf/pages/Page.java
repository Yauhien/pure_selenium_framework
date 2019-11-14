package com.taf.pages;

import com.taf.core.browser.WebDriverManager;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@Log4j
@Getter
public abstract class Page {

  @Autowired
  protected WebDriverManager webDriverManager;

  private WebDriverWait webDriverWait;

  @PostConstruct
  private void init() {
    webDriverWait = new WebDriverWait(webDriverManager.getDriver(), 10);
  }

  public void click(WebElement element) {
    waitToBeClickable(element);
    element.click();
  }

  protected void waitToBeClickable(WebElement element) {
    webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
  }

  protected void waitToBeVisible(WebElement element) {
    webDriverWait.until(ExpectedConditions.visibilityOfAllElements(element));
  }

  protected void waitToBePresent(By locator) {
    webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  protected boolean isDisplayed(By locator) {
    return findElement(locator).isDisplayed();
  }

  protected WebElement findElement(By locator) {
    waitToBePresent(locator);
    return webDriverManager.getDriver().findElement(locator);
  }

  protected List<WebElement> findElements(By locator) {
    waitToBePresent(locator);
    return webDriverManager.getDriver().findElements(locator);
  }

  protected void checkWebElementCrossedOut(WebElement webElement) {
    Assert.assertEquals("line-through", webElement.getAttribute("class"));
  }

  public void sleep() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}