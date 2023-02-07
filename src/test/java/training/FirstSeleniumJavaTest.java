package training;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumJavaTest {
	
	WebDriver driver;
	@Test
	public void TestChromeDriver() {
		
		

		
		driver.get("https://testautomationu.applitools.com/"); 
	 	driver.manage().window().maximize();		
		String title = driver.getTitle();
		System.out.println("TITLE: "+title);
		DateTimeFormatter formatD =  DateTimeFormatter.ofPattern("yyy MMdd HH:MM:SS");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		AssertJUnit.assertTrue(title.equals("Test Automation University | Applitools"));


	}
	
	@BeforeTest
	public void beforeTest() {	
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	

}
