package com.automation.pages;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excelDP;
	public ConfigDataProvider configDP;
	public ExtentReports reports;
	public ExtentReporter reporter;
	public ExtentTest logger;

	@BeforeSuite
	public void setupDP(){
		excelDP = new ExcelDataProvider();
		configDP = new ConfigDataProvider();
		reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM.html"));
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}

	@BeforeClass
	public void setUpApplication(){
		driver = BrowserFactory.startApplication(driver, configDP.getConfigBrowserC(), configDP.getConfigURL());
	}

	@AfterClass
	public void tearDownApp(){
		BrowserFactory.quitApplication(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result){
		if (result.getStatus() ==ITestResult.FAILURE){
			Helper.captureScreenShot(driver);
		}
		reports.flush();
	}
}
