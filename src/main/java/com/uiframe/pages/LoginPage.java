package com.uiframe.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiframe.baseframe.BasePage;
import com.uiframe.baseframe.LocatorBean;
import com.uiframe.utils.ElementShot;

public class LoginPage extends BasePage{

	public  Map<String, WebElement> eleMap;
	public LoginPage(WebDriver dr) {
		super(dr);	
	}
	
	public WebElement getEle(String eleName) {//根据元素名称生成元素对象
		return this.findElement(locatorMap.get(eleName));
	}
//	public Map<String, WebElement> getEleMap() {//根据locatorBean生成元素map
//		for(String key : locatorMap.keySet()) {
//			eleMap.put(key, findElement(locatorMap.get(key)));
//		}
//		return eleMap;
//	}
	
//	LocatorBean usernameInputbox = getLocator("usernameInputbox");
//	LocatorBean passwordInputbox = getLocator("passwordInputbox");
//	LocatorBean loginButton = getLocator("loginButton");
//	LocatorBean verificationCodeInputbox = getLocator("yzmInput");
//	LocatorBean verificationCodeImage = getLocator("yzmImage");
//	public LocatorBean errorMessage = getLocator("errorMessage");
	/**
	 * 
	* @author bygui  
	* @Title: inputUserName 
	* @Description: 输入用户名 
	* @param name    形参列表 
	* @return void    返回类型 
	* @throws 
	* @date 2017年8月29日 上午9:09:04
	 */

//	public void inputUserName(String name){
//		input(usernameInputbox,name);
//	}
//	
//	public void inputPasswd(String passwd){
//		input(passwordInputbox,passwd);
//	}
//	
//	
//	public void inputVerificationCode(){
//		String result = doOCR(verificationCodeImage);
////		String result = doOCR(verificationCodeImage);
////		wait(1);
//		input(verificationCodeInputbox, result);
//	}
//	
//	public void clickLoginButton(){
//		click(loginButton);
//	}

}
