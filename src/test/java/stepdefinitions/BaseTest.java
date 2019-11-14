package stepdefinitions;

import com.taf.core.browser.Browser;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class BaseTest extends Assert {

  @Value("${application.url}")
  protected String url;

  @Autowired
  protected Browser browser;
}
