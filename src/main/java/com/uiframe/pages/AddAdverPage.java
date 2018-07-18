package com.uiframe.pages;

import org.openqa.selenium.WebDriver;
import com.uiframe.baseframe.BasePage;
import com.uiframe.baseframe.LocatorBean;

public class AddAdverPage extends BasePage{
	
	public LocatorBean adverName = getLocator("adverName");

	public AddAdverPage(WebDriver dr) {
		super(dr);
	}
	
//	public WebElement findElement(LocatorBean locator){
//		WebElement we = super.findElement(locator);
//		return we;
//	}

}
