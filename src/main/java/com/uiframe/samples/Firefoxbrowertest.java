package com.uiframe.samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uiframe.baseframe.BrowserUtils;
import com.uiframe.baseframe.WebDriverFactory;
import com.uiframe.utils.Config;

public class Firefoxbrowertest {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+Config.GECKO_DRIVER;
		System.setProperty("webdriver.gecko.driver", path);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com");

	}

}
