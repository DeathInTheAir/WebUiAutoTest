package com.uiframe.pages;

import org.openqa.selenium.WebDriver;
import com.uiframe.baseframe.BasePage;
import com.uiframe.baseframe.LocatorBean;
import com.uiframe.utils.ElementShot;

public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver dr) {
		super(dr);
	}
	
	LocatorBean usernameInputbox = getLocator("usernameInputbox");
	LocatorBean passwordInputbox = getLocator("passwordInputbox");
	LocatorBean loginButton = getLocator("loginButton");
	LocatorBean verificationCodeInputbox = getLocator("yzmInput");
	LocatorBean verificationCodeImage = getLocator("yzmImage");
	public LocatorBean errorMessage = getLocator("errorMessage");
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

	public void inputUserName(String name){
		input(usernameInputbox,name);
	}
	
	public void inputPasswd(String passwd){
		input(passwordInputbox,passwd);
	}
	
	
	public void inputVerificationCode(){
		String result = doOCR(verificationCodeImage);
//		String result = doOCR(verificationCodeImage);
//		wait(1);
		input(verificationCodeInputbox, result);
	}
	
//	public void clickLoginButton(){
//		click(loginButton);
//	}

}
