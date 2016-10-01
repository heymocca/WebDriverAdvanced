package WebDriverAdvanced;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadFile {

	public static String downloadFilePath = "E:\\TestDownload";
	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;
	Alert alert;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "D:\\Download\\geckodriver.exe");

		baseUrl = "http://download-installer.cdn.mozilla.net/pub/firefox/releases/49.0.1/win64/en-GB/";
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@Test
	public void testDownloadFile() throws Exception {
		driver = new FirefoxDriver(FirefoxDriverProfile());
		driver.get(baseUrl);
		System.out.println("baseUrl:" + baseUrl);
		driver.findElement(By.linkText("Firefox Setup 49.0.1.exe")).click();
		Thread.sleep(1000);
		while (isAlertPresent()) {
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			System.out.println("alert:" + alert.getText());
			return true;
		} catch (NoAlertPresentException Ex) {
			Ex.printStackTrace();
			return false;
		}
	}

	public static FirefoxProfile FirefoxDriverProfile() throws Exception {
		// TODO Auto-generated method stub
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", downloadFilePath);
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"application/octet-steam,application/exe,text/csv,application/pdf");
		profile.setPreference("browser.helperApps.nerverAsk.saveToDisk",
				"application/octet-stream,application/exe,text/csv,application/pdf");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.focusWhenStarting", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);

		return profile;
	}
}
