package com.uiframe.actions;

import org.openqa.selenium.WebDriver;

import com.uiframe.pages.AddAdverPage;

import com.uiframe.pages.MainPage;



public class MainPageAction {
	
	private static WebDriver driver;
	static MainPage mainPage;
	
	public static void setDriver(WebDriver driver) {
		MainPageAction.driver = driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static AddAdverPage inAddAdverPage() {
		mainPage = new MainPage(getDriver());
		mainPage.clickMdbuyManag();
		mainPage.clickAdver();
		mainPage.clickAddAdver();
		return new AddAdverPage(getDriver());
	
	}
	
}
