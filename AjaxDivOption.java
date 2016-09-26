package WebDriverAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AjaxDivOption {

	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Download\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "http://www.sogou.com";	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  
  
  @Test
  public void ajaxDivOption() throws Exception {
	  driver.get(baseUrl);
	  WebElement searchInputBox = driver.findElement(By.id("query"));
	  searchInputBox.click();
	  //Thread.sleep(1000);
	  List<WebElement> recommendOptions = driver.findElements(By.xpath("//*[@id='vl']/div/ul/li"));
	  
	  for (WebElement element: recommendOptions){
		  if (element.getText().contains("电脑上也能玩手游")){
			  System.out.println(element.getText());
			  Thread.sleep(3000);
			  element.click();
			  break;
		  }
	  }
  }
}
