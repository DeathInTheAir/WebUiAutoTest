package com.uiframe.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.uiframe.baseframe.LocatorBean;


public class XmlOperator {
	
	public static Map<String,LocatorBean> getLocatorInfo(String path){
		Map<String,LocatorBean> elementInfos= new HashMap<String,LocatorBean>();
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new File(path));
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			Iterator<Element> elements  = root.elementIterator("locator");
			while(elements.hasNext()){
				
				Element element = elements.next();//获取迭代器中的下一个元素
				LocatorBean locator = null;
				String text = element.getText();
				String n = element.attributeValue("name");
				String v = element.attributeValue("value");
				int time = Integer.parseInt(element.attributeValue("timeout"));
				String by = element.attributeValue("type");
				locator = new LocatorBean(n,by,v,time);
				elementInfos.put(text, locator);
			}
		} catch (DocumentException e) {
			LoggerUtil.error("读取元素定位信息异常，原因是"+e.getMessage());
		}
		return elementInfos;
	}
	
	public static String readUIWebPageName(String path) {
		String pageName = "";
		try {
			File file = new File(path);
			SAXReader reader = new SAXReader();
			Document document = reader.read(file);
			Element root = document.getRootElement();
			pageName = root.attributeValue("name").toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageName;
	}

}
