package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver lpDriver){
		this.driver = lpDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginBTN;

	public void loginToCRM(String appUserName, String appPassword){
		username.sendKeys(appUserName);
		password.sendKeys(appPassword);
		loginBTN.click();
	}

}
