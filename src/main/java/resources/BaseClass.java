package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	protected static  WebDriver driver;

	@BeforeSuite
	public  WebDriver setUp() {

		if (new ConfigFileReader().getBrowser().equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			driver.get(new ConfigFileReader().getApplicationUrl());

		} else if (new ConfigFileReader().getBrowser().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(new ConfigFileReader().getApplicationUrl());

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
		
	}

	@AfterSuite
	public void tearDown() {
		driver.close();

	}

}
