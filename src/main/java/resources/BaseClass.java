package resources;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected static WebDriver driver;

	@BeforeSuite
	public WebDriver setUp() {

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

	public void takeSnapShot(String methodName) throws Exception {

		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("./Screenshots/" + methodName + "screenshot.png"));
	}

}
