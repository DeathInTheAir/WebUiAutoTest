package com.uiframe.baseframe;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import com.uiframe.utils.Config;
import com.uiframe.utils.LoggerUtil;


public class WebDriverFactory {
	
	private  WebDriver driver;
	
	public  WebDriver  getBrowser(){
		if(Config.DRIVER_TYPE == 1)
			driver = getChrome();
		else if(Config.DRIVER_TYPE == 2)
			driver = getFireFox();
		return driver;
	}
	
	public  WebDriver getBrowser(String bname){
		if(bname.equalsIgnoreCase("chrome"))
			driver = getChrome();
		else if(bname.equalsIgnoreCase("firefox"))
			driver = getFireFox();
		return driver;
	}
	
	public  WebDriver getChrome(){
		try{
			String path =Config.CHROME_DRIVER;
			System.setProperty("webdriver.chrome.driver", path);
			ChromeOptions options = new ChromeOptions();
//			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//			capabilities.setCapability("chrome.switches",
//					Arrays.asList("--start-maximized"));
			options.addArguments("--test-type", "--start-maximized");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			LoggerUtil.info("实例化谷歌浏览器_ok");
		}catch(Exception e){
			LoggerUtil.error("实例化谷歌浏览器_fail，原因是："+e.toString());
			Assert.fail();
		}
		return driver;
	}
	
	public  WebDriver getFireFox(){
		String path = Config.GECKO_DRIVER;
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		return driver; 
	}
}
