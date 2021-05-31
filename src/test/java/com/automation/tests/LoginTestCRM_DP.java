package com.automation.tests;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import org.testng.annotations.Test;

public class LoginTestCRM_DP extends BaseClass {

	@Test(priority = 1)
	public void loginApp() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToCRM(excelDP.getStringData(0, 0, 0), excelDP.getStringData(0, 0, 1));
		BrowserFactory.threeSecWait();
	}

}
