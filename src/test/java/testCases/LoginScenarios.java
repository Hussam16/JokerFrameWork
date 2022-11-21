package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import resources.BaseClass;

public class LoginScenarios extends BaseClass {
	@Test
	public void verifyUserLogin() {

		LoginPage login = new LoginPage(driver);
		login.setUserName("standard_user");
		login.setPassword("secret_sauce");
		login.clickLoginButton();
		Assert.assertEquals(new ProductsPage(driver).getPageTitle(), "Swag Labs");

	}
}
