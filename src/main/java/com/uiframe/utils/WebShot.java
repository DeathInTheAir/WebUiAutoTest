package com.uiframe.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class WebShot {

	public File codeImageFile;// 例如"d：/codeImage.png"

	public WebShot(WebElement codeElement) {
		// //截取验证码区域图片
		int x = codeElement.getLocation().x+1;
		int y = codeElement.getLocation().y +66;
		int width = codeElement.getSize().getWidth();
		int height = codeElement.getSize().getHeight();

		// 获取验证码区域
		Rectangle screenRectangle = new Rectangle(x, y, width, height);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			LoggerUtil.error("robot实例化失败："+e.toString());
		}
		// 缓存区域图片
		BufferedImage codeBuffImage = robot.createScreenCapture(screenRectangle);
		
		// 保存
		codeImageFile = new File(Config.CODE_IMAGE_PATH);
		try {
			ImageIO.write(codeBuffImage, "png", codeImageFile);
			
			LoggerUtil.info("验证码图片截图保存成功："+Config.CODE_IMAGE_PATH);
		} catch (IOException e) {
			LoggerUtil.error("验证码图片保存失败："+e.toString());
		}
	}
	
//	public File getImageFile(){		
//		return codeImageFile;	
//	}
	
	public String doOCR() {
//		String path = System.getProperty("user.dir")+"\\"+Config.CODE_IMAGE_PATH;
//		LoggerUtil.info("doocr path:"+path);
//		File codeImageFile = new File(path);
		// 验证码结果、正则匹配对象
		String codeResult = null;

		// 识别验证码图片
		// File imageFile = new File(dstPath+imgPath);

		try {
			Tesseract instance = new Tesseract(); // JNA Interface Mapping
			codeResult = instance.doOCR(this.codeImageFile);
			LoggerUtil.info("doOCR验证码识别结果:" + codeResult);

		} catch (TesseractException e) {
			e.getMessage();
		}
		return codeResult;
	}

}
