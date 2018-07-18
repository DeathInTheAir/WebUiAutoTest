package com.uiframe.samples;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ElementShot {

	public static void main(String[] args) {
		
		for(int i = 1; i <10;i++){
			Tesseract instance = new Tesseract();
			File imgfile = new File("d:\\test\\"+i+".png");
			String result = null;
			try {
				result = instance.doOCR(imgfile).replace(" ", "");
			} catch (TesseractException e) {
				System.out.println(e.getMessage());
			}
			System.out.print(i+":"+result);
		}
	}

}
