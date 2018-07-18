package com.uiframe.testcases;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiframe.actions.LoginAction;
import com.uiframe.actions.MainPageAction;
import com.uiframe.baseframe.WebDriverFactory;
import com.uiframe.pages.AddAdverPage;
import com.uiframe.pages.LoginPage;
import com.uiframe.pages.MainPage;
import com.uiframe.utils.AssertUtils;
import com.uiframe.utils.ExeclOperator;
import com.uiframe.utils.LoggerUtil;
import com.uiframe.utils.TestCaseBean;

public class PLogin {
	static WebDriver driver;
	Map<String,TestCaseBean> s;
	LoginPage loginPage;
	MainPage mainPage;
	AddAdverPage addAdverPage;
	
	@BeforeTest
	public void setUp(){
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver = WebDriverFactory.getBrowser();
		s = ExeclOperator.getTestData("testdata.xls");
		loginPage = new LoginPage(driver);
		System.out.println(s.get("1"));
	}
	
	@DataProvider(name = "loginData")
		public Object[][] data(){
		    int len = s.size();
			Object[][] data =new Object[len][1];
		for(int i = 0;i<len;i++){
			String num = i+1+"";
			System.out.println(s.get(num).getCaseID());
			data[i][0] = s.get(num);

			System.out.println(data[i][0]);
//			data[i][1] = s.get("C0"+i).getExpectedResult();
		}

			return data;
		
	}
	@Test(dataProvider = "loginData")
	  //登录
	  public void Login(TestCaseBean testCase) {
		
		 LoginAction.setDriver(driver);
		 mainPage = LoginAction.login(testCase.getJsonValue("username"), testCase.getJsonValue("passwd"));

		  //尝试寻找欢迎模块，断言是否登录成功
//		  Assert.assertEquals(loginPage.findElement(loginPage.errorMessage).getText(), testCase.getExpectedResult(), "用例:"+testCase.getCaseID()+"执行失败");
//		 Assert.assertEquals(mainPage.elementIsExist(mainPage.welcomeDiv), testCase.getExpectedResult(), "用例:"+testCase.getCaseID()+"执行失败");
		 AssertUtils.checkBoolen(mainPage.elementIsExist(mainPage.welcomeDiv),true,"用例:"+testCase.getCaseID()+"执行失败");
	}
	
//  @Test(dependsOnMethods = {"Login"})
//  //新建广告主
//  public void createAdver() {
//	  MainPageAction.setDriver(driver);
//	  addAdverPage =  MainPageAction.inAddAdverPage();
//	  //尝试寻找广告主模块，断言是否登录成功
//	  addAdverPage.findElement(addAdverPage.adverName);
//  }

  


  
  @AfterSuite(alwaysRun = true)
  public void tearDown(){
	  try {
		Thread.sleep(3000);
		driver.close();
		LoggerUtil.info("用例执行完毕，关闭浏览器");
	} catch (InterruptedException e) {
		LoggerUtil.error("线程睡眠3s执行失败");;
	}
  }
}
