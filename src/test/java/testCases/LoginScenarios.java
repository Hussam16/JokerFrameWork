package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;
import resources.BaseClass;
import resources.ExcelDataProvider;
import resources.ExcelUtils;

public class LoginScenarios extends BaseClass {
	@Test(dataProvider = "auth",enabled = false)
	public void verifyUserLoginDataProvider(String username,String password) {

		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.clickLoginButton();
		Assert.assertEquals(new ProductsPage(driver).getPageTitle(), "Swag Labs");

	}
	@Test
	public void verifyUserLogin() {

		LoginPage login = new LoginPage(driver);
		login.setUserName("standard_user");
		login.setPassword("secret_sauce");
		login.clickLoginButton();
		Assert.assertEquals(new ProductsPage(driver).getPageTitle(), "Swag Labs");

	}
	
	@DataProvider(name = "auth")
	public static Object[][] getData() throws Exception {
		
		return ExcelDataProvider.testData("D:\\Interview Preparation\\JokerFrameWork\\testdata\\testData.xlsx", "Sheet3");
		
		
	}
}
