package com.automation.tests;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.Helper;
import org.testng.annotations.Test;

public class LoginTestCRM extends BaseClass {

	@Test(priority = 0)
	public void pageTitle(){
		String title = driver.getTitle();
		System.out.println("Title: " + title);
	}

	@Test(priority = 1)
	public void loginApp() {
		logger = reports.createTest("Login t CRM");
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Starting Application");
		loginPage.loginToCRM(configDP.getConfigData("userName"), configDP.getConfigData("password"));
		Helper.captureScreenShot(driver);
		logger.pass("Login done successfully");
		BrowserFactory.threeSecWait();
	}

}
