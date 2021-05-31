package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseWithoutFramework {
	WebDriver driver;
	@Test
	public void testDemo() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Tutorial_IntelliJ\\Hybrid_Framework\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		driver.findElement(By.linkText("Classic CRM")).click();
		driver.findElement(By.name("username")).sendKeys("Selenium_50");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Abcd@123456");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/input[3]")).click();
		driver.close();
		driver.quit();
	}
}
