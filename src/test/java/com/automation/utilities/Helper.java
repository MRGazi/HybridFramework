package com.automation.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	//Screenshot, alerts, frames, windows, Sync issue, JsExecutor,
	public static void captureScreenShot(WebDriver driver){
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(".\\ScreenShots\\Login_" + currDataTime()+".png");
		try {
			FileHandler.copy(src, file);
			System.out.println("ScreenShot captured and saved");
		} catch (Exception e) {
			System.out.println("FileHandler cannot copy the src into File! "+e.getMessage());
		}
	}
	public static String dateTime(){
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	public static String currDataTime(){
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currDate = new Date();
		return customFormat.format(currDate);
	}
}
