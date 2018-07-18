package com.uiframe.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.uiframe.utils.Config;




public class ActionsTest {

	public static void main(String[] args) {
		
		//初始化chrome浏览器
		System.setProperty("webdriver.chrome.driver", Config.CHROME_DRIVER);
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars","--start-maximized");	
		WebDriver driver = new ChromeDriver(option);
		
		//初始化firefox浏览器
//		System.setProperty("webdriver.gecko.driver", Config.GECKO_DRIVER);
//		WebDriver driver = new FirefoxDriver();
		
		
		Actions action = new Actions(driver);
				
//		driver.manage().window().maximize();
		driver.get("http://image.baidu.com/");
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//刷新
//		action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).sendKeys(Keys.NULL).perform();
		//定位元素
			//图片
		WebElement imgElement = driver.findElement(By.cssSelector("a[data-id='1']"));
//		WebElement music = driver.findElement(By.cssSelector("a[name='i_mp3']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);",imgElement);
		
//		action.contextClick().perform();
//		js.executeScript("window.scrollTO(999,999);");
		
//		((JavascriptExecutor)driver).executeScript("window.scrollTo(999,999)");
		 	//搜索框
		WebElement serchInput = driver.findElement(By.cssSelector("input#kw"));
//		 serchInput.sendKeys("testText");

//		
//		
//		action.dragAndDrop(imgElement,serchInput).perform();
		action.clickAndHold(imgElement).moveByOffset(100,100).perform();
//		action.release();
//		imgElement.click();
		
	}

}
