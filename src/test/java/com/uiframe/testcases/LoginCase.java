package com.uiframe.testcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.uiframe.actions.LoginAction;
import com.uiframe.baseframe.WebDriverFactory;
import com.uiframe.pages.LoginPage;
import com.uiframe.utils.AssertUtils;
import com.uiframe.utils.ExeclOperator;
import com.uiframe.utils.TestCaseBean;

public class LoginCase {

	static WebDriver driver;
	LoginPage loginPage;
	Map<String,TestCaseBean> caseMap;
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		driver = WebDriverFactory.getBrowser("firefox");
		loginPage = new LoginPage(driver);
		loginPage.openUrl("http://hizhubang.hizhu.com");

	}

//	@DataProvider(name = "loginData")
//	public Object[][] data() {
//		caseMap = ExeclOperator.getTestData("testdata.xls");
//		//读取用例excel，获取数数据驱动的详细
//		int len = caseMap.size();
//		Object[][] data = new Object[len][1];
//		for (int i = 0; i < len; i++) {
//			String num = i + 1 + "";
//			System.out.println(caseMap.get(num).getCaseID());
//			data[i][0] = caseMap.get(num);
//
//			System.out.println(data[i][0]);
////		data[i][1] = s.get("C0"+i).getExpectedResult();
//		}
//		return data;
//	}

	@Test
	// 登录
	public void Login() {
		
//		loginPage.getEle("usernameInputbox").click();
		WebElement we = loginPage.getEle("usernameInputbox");
		we.sendKeys("15000219168");
		loginPage.getEle("passwordInputbox").sendKeys("aa123456,");
//		mainPage = LoginAction.login(testCase.getJsonValue("username"), testCase.getJsonValue("passwd"));

		// 尝试寻找欢迎模块，断言是否登录成功
//	  Assert.assertEquals(loginPage.findElement(loginPage.errorMessage).getText(), testCase.getExpectedResult(), "用例:"+testCase.getCaseID()+"执行失败");
//	 Assert.assertEquals(mainPage.elementIsExist(mainPage.welcomeDiv), testCase.getExpectedResult(), "用例:"+testCase.getCaseID()+"执行失败");
//		AssertUtils.checkBoolen(mainPage.elementIsExist(mainPage.welcomeDiv), true,
//				"用例:" + testCase.getCaseID() + "执行失败");
	}
}
