package com.uiframe.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.uiframe.actions.LoginAction;
import com.uiframe.actions.MainPageAction;
import com.uiframe.baseframe.WebDriverFactory;
import com.uiframe.pages.AddAdverPage;
import com.uiframe.pages.LoginPage;
import com.uiframe.pages.MainPage;
import com.uiframe.utils.ExeclOperator;
import com.uiframe.utils.LoggerUtil;
import com.uiframe.utils.TestCaseBean;

public class CreateAddAdver {
	WebDriver driver;
	Map<String,TestCaseBean> s;
	LoginPage loginPage;
	MainPage mainPage;
	AddAdverPage addAdverPage;
	
//	@BeforeSuite
//	public void setUp(){
//		System.setProperty("org.uncommons.reportng.escape-output", "false");
//		driver = WebDriverFactory.getBrowser();
//		s = ExeclOperator.getTestData("testdata.xls");
//		 
//	}
//	
//	@Test
//	  //登录
//	  public void Login() {
//		 LoginAction.setDriver(driver);
//		 mainPage = LoginAction.login(s.get("C01").getJsonValue("username"), s.get("C01").getJsonValue("passwd"));
//		 
//		 //尝试寻找欢迎模块，断言是否登录成功
//		 Assert.assertTrue(mainPage.elementIsExist(mainPage.welcomeDiv), "检查登录是否成功");
//	}
	
  @Test
  //新建广告主
  public void createAdver() {
		driver = PLogin.driver;
	  MainPageAction.setDriver(driver);
	  addAdverPage =  MainPageAction.inAddAdverPage();
	  //尝试寻找广告主模块，断言是否登录成功
	  Assert.assertTrue(addAdverPage.elementIsExist(addAdverPage.adverName), "进入新增页面失败"); 
  }

  
  //@Test(expectedExceptions = Exception.class);

  
//  @Test
//  public void tearDown(){
//	  try {
//		Thread.sleep(3000);
//		driver.close();
//		LoggerUtil.info("用例执行完毕，关闭浏览器");
//	} catch (InterruptedException e) {
//		LoggerUtil.error("线程睡眠3s执行失败");;
//	}
//  }
}
