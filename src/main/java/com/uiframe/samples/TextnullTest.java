package com.uiframe.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uiframe.baseframe.BrowserUtils;
import com.uiframe.baseframe.WebDriverFactory;
import com.uiframe.utils.Config;

public class TextnullTest {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+"\\"+Config.GECKO_DRIVER;
		System.setProperty("webdriver.gecko.driver", path);
		WebDriver driver = new FirefoxDriver();
		driver.get("http://60.166.12.158:4077/login");
		WebElement element = driver.findElement(By.cssSelector("font[color='red']"));
		System.out.println("text:"+element.getText());
	}

}
