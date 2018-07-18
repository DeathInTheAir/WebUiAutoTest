package com.uiframe.baseframe;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.uiframe.utils.LoggerUtil;

public class KeyboardUtils {
	
	Actions actions;
	
	public KeyboardUtils(WebDriver driver){
		this.actions = new Actions(driver);
	}

    public void pressDown(int times) {
    	for(int i=1;i<=times;i++){
    		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
    		LoggerUtil.info("按方向键向下箭头共 "+ times +" 次：第"+ i +"次");
    	}
    }    
	
    public void pressEnter(){
    	actions.sendKeys(Keys.ENTER).build().perform();
    	LoggerUtil.info("按回车键");
    }
    
    public void pressCtrlandA(){
    	
    }
    
    public void pressCtrl(String... key){
    	if(key==null)
    		actions.keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
    	else
    		actions.keyDown(Keys.CONTROL).sendKeys(key[0]).keyUp(Keys.CONTROL).perform();
    }
    
    public void pressKeyByAwt(int keyCode) {
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
        	LoggerUtil.error("实例化操作键盘的对象时出现异常");
        }
        if (rb == null) {
        	LoggerUtil.info("操作键盘的对象为空 退出");
            return;
        }
        rb.keyPress(keyCode); // press key
        rb.delay(100); // delay 100ms
        rb.keyRelease(keyCode); // release key
        LoggerUtil.info("点击键值为" + keyCode + "的键");
    }
}
