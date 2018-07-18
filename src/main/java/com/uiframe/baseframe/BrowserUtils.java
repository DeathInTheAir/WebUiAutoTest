package com.uiframe.baseframe;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uiframe.utils.Config;
import com.uiframe.utils.LoggerUtil;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class BrowserUtils {
	
	protected WebDriver driver;
	protected MouseUtils mouse;
	protected KeyboardUtils keyboard;
	
	public BrowserUtils(WebDriver dr){
		driver = dr;
		mouse = new MouseUtils(dr);
		keyboard = new KeyboardUtils(dr);
	}
	public BrowserUtils(){};
/**
 * 
* @author bygui  
* @Title: openUrl 
* @Description: 打开网址 
* @param url    形参列表 
* @return void    返回类型 
* @throws 
* @date 2017年8月24日 下午2:25:54
 */
	public void openUrl(String url){
		try{
			driver.get(url);
			LoggerUtil.info("打开网址："+url);
		}catch(Exception e){
			LoggerUtil.error("打开网址失败,原因是："+e.toString());
			takeScreenShot("error");
			Assert.fail();
		}
	}
	
	public void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
			LoggerUtil.info("等待 "+seconds+" 秒");
		} catch (InterruptedException e) {
			LoggerUtil.error("等待出现异常，原因是"+e.getMessage());
			Assert.fail();
		}
	}
	
    //截图
    public void takeScreenShot(String... pngName) {
    	String fileName ;
//    	String filePath = System.getProperty("user.dir")+Config.SCREEN_SHOTPATH;
    	String filePath = Config.SCREEN_SHOTPATH;
    	File file = new File(filePath);
    	if(!file.exists()) {
    	    file.mkdir();
    	}
        if (pngName.length == 0) {
        	fileName = "shotImage";
        } else {
        	fileName = pngName[0];
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path =  filePath  + fileName + "_" + dateStr + ".png";
        takeScreenShot(driver, path);    	
    }
    
    public void takeScreenShot(WebDriver drivername, String path) {
        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
        File picFile = new File(path);
        LoggerUtil.info("截图保存的路径为:" + path);
        try {
            FileUtils.copyFile(scrFile, picFile);
            LoggerUtil.info("截图成功！！！");
        } catch (Exception e) {
        	LoggerUtil.error("截图失败！！！");
        } 
        LoggerUtil.screenShotLog("截图：" + scrFile, picFile);
    }    
    
}
