package com.uiframe.baseframe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.uiframe.utils.LoggerUtil;

public class MouseUtils {
	
	private Actions action;
	
	public MouseUtils(WebDriver dr){
		this.action = new  Actions(dr);
	}
	
	public void rightClick(WebElement el){
		try{
			this.action.contextClick(el).perform();
			LoggerUtil.info("右击元素");
		}catch(Exception e){
			LoggerUtil.error("右击元素异常，原因是 "+e.toString());
		}
	}
	
	public void moveToElement(WebElement el){
		this.action.moveToElement(el).perform();
	}
}
