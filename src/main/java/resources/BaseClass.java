package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public static void setUp() {

		if (new ConfigFileReader().getBrowser().equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			driver.get(new ConfigFileReader().getApplicationUrl());

		} else if (new ConfigFileReader().getBrowser().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(new ConfigFileReader().getApplicationUrl());

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
