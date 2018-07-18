package com.uiframe.pages;

import org.openqa.selenium.WebDriver;
import com.uiframe.baseframe.BasePage;
import com.uiframe.baseframe.LocatorBean;

public class MainPage extends BasePage{
	
	public LocatorBean welcomeDiv = getLocator("welcomeDiv");
	LocatorBean mediabuyManagement = getLocator("投放管理");
	LocatorBean AdverManagement = getLocator("广告主管理");
	LocatorBean addAdver = getLocator("addAdver");

	public MainPage(WebDriver dr) {
		super(dr);
	}
	
//	public WebElement findElement(LocatorBean locator){
//		WebElement we = super.findElement(locator);
//		return we;
//	}
	//点击投放模块
	public void clickMdbuyManag(){
		click(mediabuyManagement);
	}
	//点击广告主模块
	public void clickAdver(){
		click(AdverManagement);
	}
	//点击新增广告主
	public void clickAddAdver(){
		click(addAdver);
	}
}
