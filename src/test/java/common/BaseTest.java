package common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	//For demonstrating parameterized builds
	String browser = System.getProperty("browser");

	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {	
		
		
		if (browser!=null  && browser!="") {
			browser = browser.trim().toLowerCase();
			switch (browser) {
			case "chrome":
				ChromeOptions browserOptions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(browserOptions);
				break;

			case "firefox":
				FirefoxOptions optn = new FirefoxOptions();
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver(optn);
				break;
			case "opera":
				OperaOptions optnO = new OperaOptions();
				WebDriverManager.chromedriver().setup();
				driver = new OperaDriver(optnO);
				break;
			}
		}else {
			ChromeOptions browserOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(browserOptions);
		}

	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
}
