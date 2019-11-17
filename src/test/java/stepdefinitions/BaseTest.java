package stepdefinitions;

import com.taf.core.browser.Browser;
import com.taf.core.browser.TestContext;
import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Log4j
public class BaseTest extends Assert {

  @Value("${application.url}")
  protected String url;

  @Autowired
  protected Browser browser;

  @Autowired
  protected TestContext testContext;
}
