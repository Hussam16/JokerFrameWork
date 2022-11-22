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
	@Test(dataProvider = "auth")
	public void verifyUserLogin(String username,String password) {

		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.clickLoginButton();
		Assert.assertEquals(new ProductsPage(driver).getPageTitle(), "Swag Labs");

	}
	
	@DataProvider(name = "auth")
	public static Object[][] getData() throws Exception {
		
		return ExcelDataProvider.testData("D:\\Interview Preparation\\JokerFrameWork\\testdata\\testData.xlsx", "Sheet3");
		//return ExcelUtils.testDataLogin("D:\\Interview Preparation\\JokerFrameWork\\testdata\\testData.xlsx", "Sheet5");
		
	}
}
