package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
	static String dirPath = System.getProperty("user.dir");
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL){
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", dirPath+"\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", dirPath+"\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browserName.equals("opera")){
			System.setProperty("webdriver.opera.driver", dirPath+"\\WebDrivers\\operadriver.exe");
			driver = new OperaDriver();
		}else {
			System.out.println("We do not support this browser");
		}
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		return driver;
	}
	public static void quitApplication(WebDriver driver){
		driver.close();
		driver.quit();
	}
	public static void threeSecWait(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
