package WebDriverAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class DownloadFile {

	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Download\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("http://www.google.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

  @Test
  public void f() {
	  System.out.println("test");
  }
}
