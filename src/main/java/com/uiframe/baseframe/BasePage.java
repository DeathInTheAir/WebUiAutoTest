package com.uiframe.baseframe;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uiframe.utils.LoggerUtil;
import com.uiframe.utils.XmlOperator;

public class BasePage extends WebElementUtils{


	public BasePage(WebDriver dr) {
		super(dr);
	}
	
	public void switchToFrameByIdorName(String type){
		try{
			driver.switchTo().frame(type);
			LoggerUtil.info("切换到ID或NAME="+type+" 的frame");
		}catch(Exception e){
			LoggerUtil.error(e.toString());
			takeScreenShot();
			Assert.fail();
		}
	}
	
	public void switchToFrameByWebElement(LocatorBean locator){
		try{
			WebElement el = findElement(locator);
			driver.switchTo().frame(el);
			LoggerUtil.info("切换到【"+locator.getElementName()+"】frame");
		}catch(Exception e){
			LoggerUtil.error(e.toString());
			takeScreenShot();
			Assert.fail();
		}
	}
	
	//浏览器多窗口
	//alert/confirm/prompt处理
	//调用javascript
	//调用DOS命令
    public void printIntoPageInfo(){
    	String pageName = XmlOperator.readUIWebPageName(path);
    	LoggerUtil.info("进入  " + pageName);
    }
    
    public void runCommand(String exeName){
    	try {
    		String path = System.getProperty("user.dir")+"\\exefiles\\";
			Runtime.getRuntime().exec(path+exeName);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }//调用dos命令

}
