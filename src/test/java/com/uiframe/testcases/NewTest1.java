package com.uiframe.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uiframe.actions.LoginAction;
import com.uiframe.baseframe.WebDriverFactory;


public class NewTest1 {
	WebDriver driver ;
	
	@BeforeTest
	public void setUp(){
		driver = WebDriverFactory.getBrowser();		
	}
  @Test
  public void f() {
	  LoginAction.setDriver(driver);
	  LoginAction.login("admin", "Xylx1.T");
  }
}
