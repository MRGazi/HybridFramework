package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	File src;
	FileInputStream fis;
	Properties prop;

	public  ConfigDataProvider(){
		src = new File(".\\Configuration\\Config.properties");
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Process not able to load Config file: "+e.getMessage());
		}
	}

	public String getConfigData(String keyToPass){
		return prop.getProperty(keyToPass);
	}

	public String getConfigBrowserC(){
		return prop.getProperty("BrowserC");
	}

	public String getConfigURL(){
		return prop.getProperty("qaURL");
	}
}
