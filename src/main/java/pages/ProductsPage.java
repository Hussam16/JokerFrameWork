package pages;

import org.openqa.selenium.WebDriver;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
		
		
	}
}
