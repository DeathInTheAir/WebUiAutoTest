package com.uiframe.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static final String PROJECT_URL = getPro("projectUrl");
	public static final String SCREEN_SHOTPATH =getPro("screenShotPath");
	public static final int LOG_SETTING = Integer.parseInt(getPro("isPrintMsgToReport"));
	public static final int MAX_RETRY_TIMES = Integer.parseInt(getPro("maxRetryTimes").trim());
	public static final String TEST_CASE_PATH = getPro("testCasePath");
	public static final String CODE_IMAGE_PATH = getPro("codeImagePath");
	public static final int DRIVER_TYPE = Integer.parseInt(getPro("driverType"));
	public static final String GECKO_DRIVER = getPro("firefoxDriver");
	public static final String CHROME_DRIVER = getPro("chromeDriver");
	public static final String ELEMENTS_PATH = getPro("elementsPath");
	
	public static String getPro(String key){
		Properties pps = new Properties();
		String filepath = System.getProperty("user.dir")+"\\configs\\selenium.properties";
		String value = null;
		try{
			InputStream in= new BufferedInputStream(new FileInputStream(filepath));
			pps.load(in);
			value = pps.getProperty(key);
		}catch(Exception e){
			
		}
		return value;
	}
}
