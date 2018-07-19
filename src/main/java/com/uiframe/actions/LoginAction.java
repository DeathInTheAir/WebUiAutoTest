package com.uiframe.actions;




import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import com.uiframe.pages.LoginPage;
import com.uiframe.pages.MainPage;
import com.uiframe.utils.Config;


public class LoginAction {
	
	private static WebDriver driver;
	static LoginPage loginPage;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		LoginAction.driver = driver;
	}
	
	public static  MainPage login(String name,String passwd){
		loginPage = new LoginPage(getDriver());
		loginPage.openUrl(Config.PROJECT_URL);
//		loginPage.inputUserName(name);
//		loginPage.inputPasswd(passwd);
//		loginPage.inputVerificationCode();
		
		return new MainPage(getDriver());
	}
	
	//伪登录，添加cookie跳过登录
	public static  MainPage pLogin(){
		driver = LoginAction.getDriver();
		loginPage = new LoginPage(driver);
		loginPage.openUrl(Config.PROJECT_URL);
		Cookie cookie = new Cookie("PHPSESSID", "6vi62fnb3ertb9f8dorf490a81");
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
		return new MainPage(driver);
	}
	
}
