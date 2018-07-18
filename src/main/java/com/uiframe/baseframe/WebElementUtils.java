package com.uiframe.baseframe;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.uiframe.utils.Config;
import com.uiframe.utils.ElementShot;
import com.uiframe.utils.LoggerUtil;
import com.uiframe.utils.WebShot;
import com.uiframe.utils.XmlOperator;




public class WebElementUtils extends BrowserUtils{
	
	protected Map<String,LocatorBean> locatorMap;
	protected String path = null;
	
	
	public WebElementUtils(WebDriver dr) {
		super(dr);
		path = Config.ELEMENTS_PATH+ getClass().getSimpleName()+".xml";
		LoggerUtil.info(getClass().getSimpleName()+"使用元素文件xml："+path);
		locatorMap = XmlOperator.getLocatorInfo(path);
	}
	
	public LocatorBean getLocator(String key){
		LocatorBean locator = locatorMap.get(key);
		return locator;
	}
	
	public WebElement findElement(LocatorBean locator){  //显式等待
		WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
		WebElement el = null;
		try{	
			el = wait.until(
					new ExpectedCondition<WebElement>() {  
						@Override  
						public WebElement apply(WebDriver d) { 
							return getElement(d,locator); 
							}							 
						}  
				);
	}catch(Exception e){
		LoggerUtil.error("【"+locator.getElementName()+"】识别失败：识别超时");	
		takeScreenShot("error");		
	}
		return el;
}
	
	public WebElement getElement(WebDriver dr,LocatorBean locator){
		/*
		*参数：浏览器驱动，定位信息类
		*返回：web元素
		*
		*/
		WebElement el = null;
		try{
			switch(locator.getBy()){
			case "id":
				el = dr.findElement(By.id(locator.getLocatorInfo()));
				break;
			case "css":
				el = dr.findElement(By.cssSelector(locator.getLocatorInfo()));
				break;
			case "className":
				el = dr.findElement(By.className(locator.getLocatorInfo()));
				break;
			case "name":
				el = dr.findElement(By.name(locator.getLocatorInfo()));
				break;
			case "partialLinkText":
				el = dr.findElement(By.partialLinkText(locator.getLocatorInfo()));
				break;
			}
			LoggerUtil.info("【"+locator.getElementName()+"】识别成功");
		}catch(Exception e){
			LoggerUtil.error("【"+locator.getElementName()+"】暂未找到，轮询中...");
		}
		return el;
	}
	
	public void click(LocatorBean locator){
		WebElement el = findElement(locator);
		try{
			el.click();
			LoggerUtil.info("点击【"+locator.getElementName()+"】");
		}catch(Exception e){
			LoggerUtil.error("不能点击【"+locator.getElementName()+"】原因是："+e.toString());
			Assert.fail();
		}
	}
	
	public void submit(LocatorBean locator){
		WebElement el = findElement(locator);
		try{
			el.submit();
			LoggerUtil.info("提交【"+locator.getElementName()+"】");
		}catch(Exception e){
			LoggerUtil.error("不能提交【"+locator.getElementName()+"】原因是："+e.toString());
			Assert.fail();
		}
	}
	
	public void input(LocatorBean locator,String content){
		WebElement el = findElement(locator);
		try{
			el.clear();
			el.sendKeys(content);
			LoggerUtil.info("在【"+locator.getElementName()+"】中输入 "+content);
		}catch(Exception e){
			LoggerUtil.error("不能完成【"+locator.getElementName()+"】中输入，原因是："+e.toString());
		}
	}
	
	/*
	 * @locator 元素定位对象
	 * @功能 对该元素进行截图保存 
	 * */
	public String doOCR(LocatorBean locator){
		WebShot ws = new WebShot(findElement(locator));
		LoggerUtil.debug(ws.codeImageFile.getPath());
		String result = ws.doOCR();
		return result;
	}
//	public String doOCR(LocatorBean locator){
//		String result =null;
//		try {
//			File f = ElementShot.captureElement(findElement(locator));
//			Tesseract instance = new Tesseract();
//			result = instance.doOCR(f);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return result;	
//	}
	
	
	/*
	 * @param locator 元素定位对象
	 * @功能：判断元素是否存在，返回boolean值
	 * */
	public boolean elementIsExist(LocatorBean locator){
		boolean frag = true; 
		try{
			findElement(locator);			
		}catch(Exception e){
			frag = false;
		}
//		if(findElement(locator) == null)
//				
		return frag;
	}
	
	
	public String getText(LocatorBean locator){
		String content = null;
		WebElement el = findElement(locator);
		try{
			content = el.getText();
			LoggerUtil.info("获取【"+locator.getElementName()+"】中文本");
		}catch(Exception e){
			LoggerUtil.error("不能获取【"+locator.getElementName()+"】文本，原因是："+e.toString());
			Assert.fail();
		}
		return content;
	}
	//下拉框处理

}
