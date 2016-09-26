package WebDriverAdvanced;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class JSExecutor {

	WebDriver driver;
	JavascriptExecutor js;
	
  @BeforeMethod
  public void beforeMethod() {	 
	  //System.setProperty("webdriver.gecko.driver", "D:\\Download\\geckodriver.exe");
	  //WebDriver driver = new FirefoxDriver();
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.get("http://www.google.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test
  public void testHandleiFrame() throws Exception {
	  WebElement searchInputBox = driver.findElement(By.id("lst-ib"));
	  WebElement searchButton = driver.findElement(By.name("btnG"));
	  searchInputBox.sendKeys("simulate a click with javascript");
	  Thread.sleep(1000);
	  JavascriptClick(searchButton);
  }

private void JavascriptClick(WebElement element) throws Exception{
	// TODO Auto-generated method stub
	try {
		if (element.isEnabled() && element.isDisplayed()) {
			System.out.println("use javascript click web page element");
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		} else {
			System.out.println("unable to click web page element");
		}
	} catch (StaleElementReferenceException e) {
		// TODO: handle exception
		System.out.println("StaleElementReferenceException" + e.getStackTrace());
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		System.out.println("NoSuchElementException" + e.getStackTrace());	
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("unable to click" + e.getStackTrace());	
	}
	
}

}
